package com.example.helpfromhomeproject;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Locale;

public class FoodPage extends AppCompatActivity implements placeOrderInterface {
    TextView title, price1, descriptionTxt;
    ImageView imageView;
    private TextView placeOrder;
    Button timeButton;
    int hour, minute;
    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_page);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://helpfromhome-2debd.appspot.com");

        String name = getIntent().getStringExtra("TITLE");
        String price = getIntent().getStringExtra("price");
        String distance = getIntent().getStringExtra("distance");
        String foodDescription = getIntent().getStringExtra("foodDescription");
        DAOProduct dao = new DAOProduct();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        title = findViewById(R.id.title);
        price1 = findViewById(R.id.price);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        TextView dist = findViewById(R.id.distance);
        timeButton = findViewById(R.id.selectTime);

        title.setText(name);
        price1.setText(price);
        dist.setText(distance);
        descriptionTxt.setText(foodDescription);
    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(FoodPage.this, HomePage.class);
    }

    public void popTimePicker(View view){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                timeButton.setText(String.format(Locale.getDefault(),"%02d:%02d", hour, minute));
            }
        };
        int style = AlertDialog.THEME_HOLO_DARK;
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hour, minute, true);
        timePickerDialog.setTitle("SelectTime");
        timePickerDialog.show();
    }

    public void placeOrder(View view){
        String selectedTime = timeButton.getText().toString();
        String selectedTitle = title.getText().toString();
        String selectedPrice = price1.getText().toString();
        String selectedDescription = descriptionTxt.getText().toString();

        mDatabase.child("orders").child(selectedTime).setValue(new Order(selectedTitle, selectedPrice, selectedDescription))
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Intent intent = new Intent(FoodPage.this, barcode.class);
                        startActivity(intent);
                    }
                });
    }

    private static class Order {
        public String title;
        public String price;
        public String description;

        public Order() {
            // Default constructor required for calls to DataSnapshot.getValue(Order.class)
        }

        public Order(String title, String price, String description) {
            this.title = title;
            this.price = price;
            this.description = description;
        }
    }
}
