package com.example.helpfromhomeproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.AutoResolveHelper;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.PaymentDataRequest;
import com.google.android.gms.wallet.PaymentsClient;
import com.google.android.gms.wallet.Wallet;
import com.google.android.gms.wallet.WalletConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Donation extends AppCompatActivity {

    private PaymentsClient paymentsClient;
    private static final int LOAD_PAYMENT_DATA_REQUEST_CODE = 991;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        // Initialize the paymentsClient using the Google Pay API
        Wallet.WalletOptions walletOptions = new Wallet.WalletOptions.Builder().setEnvironment(WalletConstants.ENVIRONMENT_TEST).build();
        paymentsClient = Wallet.getPaymentsClient(this, walletOptions);

        // Create an IsReadyToPayRequest to check if the user's device supports Google Pay
        IsReadyToPayRequest readyToPayRequest = null;
        try {
            readyToPayRequest = IsReadyToPayRequest.fromJson(baseConfigurationJson().toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        // Check if the user's device supports Google Pay
        Task<Boolean> task = paymentsClient.isReadyToPay(readyToPayRequest);
        task.addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
            @Override
            public void onComplete(@NonNull Task<Boolean> completeTask) {
                if (completeTask.isSuccessful()){
                    // Show the Google Pay button if the device supports it
                    showGooglePayButton(completeTask.getResult());
                } else {
                    // Handle the case where Google Pay is not supported
                    // You can choose to show an alternative payment method or provide a message to the user
                }
            }
        });

        // Create a PaymentDataRequest to specify the payment details
        PaymentDataRequest request = null;
        try {
            request = PaymentDataRequest.fromJson(paymentRequestJson().toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        // Load the payment data and resolve the task using AutoResolveHelper
        AutoResolveHelper.resolveTask(paymentsClient.loadPaymentData(request), this, LOAD_PAYMENT_DATA_REQUEST_CODE);
    }

    // Update the UI to show/hide the Google Pay button based on whether the user's device is ready to pay
    private void showGooglePayButton(Boolean userIsReadyToPay) {
        Button googlePayButton = findViewById(R.id.google_pay_button);

        if(userIsReadyToPay){
            // Update UI to show the Google Pay button
            googlePayButton.setVisibility(View.VISIBLE);
        } else {
            // Google Pay is not supported. Do not show the button
            googlePayButton.setVisibility(View.GONE);
        }
    }

    // Create a base configuration JSON object
    private static JSONObject baseConfigurationJson() throws JSONException {
        return new JSONObject().put("apiVersion", 2).put("apiVersionMinor", 0).put("allowedPaymentMethods", new JSONArray().put(getCardPaymentMethod()));
    }

    // Create a JSON object for the card payment method
    private static JSONObject getCardPaymentMethod() throws JSONException {
        final String[] networks = new String[] {"VISA", "AMEX"};
        final String[] authMethods = new String [] {"PAN_ONLY", "CRYPTOGRAM_3DS"};

        JSONObject card = new JSONObject();
        card.put("type", "CARD");
        card.put("tokenizationSpecification", getTokenizationSpec());
        card.put("parameters", new JSONObject().put("allowedAuthMethods", new JSONArray(authMethods)).put("allowedCardNetworks", new JSONArray(networks)));
        return card;
    }

    // Create a JSON object for the tokenization specification
    private static JSONObject getTokenizationSpec() throws JSONException {
        JSONObject tokenizationSpec = new JSONObject();
        tokenizationSpec.put("type", "PAYMENT_GATEWAY");
        tokenizationSpec.put("parameters", new JSONObject().put("gateway", "example").put("gatewayMerchantId", "exampleMerchantId"));
        return tokenizationSpec;
    }

    private static JSONObject paymentRequestJson() throws JSONException {
        JSONObject paymentRequestJson = baseConfigurationJson();
        paymentRequestJson.put("transactionInfo", new  JSONObject().put("totalPrice", "12.50").put("totalPriceStatus", "FINAL").put("currencyCode", "USD"));
        paymentRequestJson.put("merchantInfo", new JSONObject().put("merchantID", "0123456789").put("merchantName", "Example Merchant"));
        return paymentRequestJson;
    }
}
