package com.example.helpfromhomeproject;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AlcoholSupport extends AppCompatActivity {

    private EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcohol_support);

        searchEditText = findViewById(R.id.search_bar);
    }

    public void home(View view){
        Intent intent = new Intent(AlcoholSupport.this, HomePage.class);
        startActivity(intent);
    }

    public void voucher(View view){
        Intent intent = new Intent(AlcoholSupport.this, VoucherPage.class);
        startActivity(intent);
    }

    public void domestic(View view){
        Intent intent = new Intent(AlcoholSupport.this, DomesticAbuseSupport.class);
        startActivity(intent);
    }

    public void profile(View view) {
        Intent intent = new Intent(AlcoholSupport.this, profile.class);
        startActivity(intent);
    }
    public void onSearchButtonClick(View view) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        EditText editText = findViewById(R.id.search_bar);
        String query = editText.getText().toString();
        intent.putExtra(SearchManager.QUERY, query);
        startActivity(intent);
    }
}
