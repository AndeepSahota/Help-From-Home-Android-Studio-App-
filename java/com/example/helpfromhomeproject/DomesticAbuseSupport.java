package com.example.helpfromhomeproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class DomesticAbuseSupport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domestic_abuse_support);

        Fragment fragment = new Map_Fragment();
        //getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
    }
    public void toMaps(View view){
        Intent intent = new Intent(DomesticAbuseSupport.this, maps.class);
        startActivity(intent);
    }
    public void home(View view){
        Intent intent = new Intent(DomesticAbuseSupport.this, HomePage.class);
        startActivity(intent);
    }
    public void voucher(View view){
        Intent intent = new Intent(DomesticAbuseSupport.this, VoucherPage.class);
        startActivity(intent);
    }
    public void alcohol(View view){
        Intent intent = new Intent(DomesticAbuseSupport.this, AlcoholSupport.class);
        startActivity(intent);

    }
    public void profile(View view) {
        Intent intent = new Intent(DomesticAbuseSupport.this, profile.class);
        startActivity(intent);
    }
}