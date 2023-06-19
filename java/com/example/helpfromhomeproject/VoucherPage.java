package com.example.helpfromhomeproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpfromhomeproject.Adapter.VoucherAdapter;
import com.example.helpfromhomeproject.Domain.RecyclerViewInterface;
import com.example.helpfromhomeproject.Domain.VoucherDomain;

import java.util.ArrayList;

public class VoucherPage extends AppCompatActivity implements RecyclerViewInterface {
    private RecyclerView.Adapter adapter3;
    private RecyclerView recyclerVoucher;
    private RecyclerView recyclerVoucher1;
    private RecyclerView recyclerVoucher2;
    private ArrayList<VoucherDomain> voucherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher_page);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        recyclerVoucher();
        recyclerVoucher1();
        recyclerVoucher2();

    }

    private void recyclerVoucher() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerVoucher = findViewById(R.id.view2);
        recyclerVoucher.setLayoutManager(linearLayoutManager);

        voucherList = new ArrayList<VoucherDomain>();
        voucherList.add(new VoucherDomain("10% off BP Petrol", R.drawable.bp_logo));
        voucherList.add(new VoucherDomain("8% off Tesco", R.drawable.tesco_logo));
        voucherList.add(new VoucherDomain("5% off H&M", R.drawable.h_and_m_logo));


        adapter3 = new VoucherAdapter(voucherList, this);
        recyclerVoucher.setAdapter(adapter3);
    }

    private void recyclerVoucher1() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerVoucher1 = findViewById(R.id.view3);
        recyclerVoucher1.setLayoutManager(linearLayoutManager);

        voucherList = new ArrayList<VoucherDomain>();
        voucherList.add(new VoucherDomain("10% off ASDA", R.drawable.asda_logo));
        voucherList.add(new VoucherDomain("5% off M&S", R.drawable.m_and_s_logo));
        voucherList.add(new VoucherDomain("15% off H&M", R.drawable.schuh));

        adapter3 = new VoucherAdapter(voucherList, this);
        recyclerVoucher1.setAdapter(adapter3);
    }

    private void recyclerVoucher2() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerVoucher2 = findViewById(R.id.view4);
        recyclerVoucher2.setLayoutManager(linearLayoutManager);

        voucherList = new ArrayList<VoucherDomain>();
        voucherList.add(new VoucherDomain("5% off Currys PC World", R.drawable.currys));
        voucherList.add(new VoucherDomain("10% off Morrisons", R.drawable.morrisons_logo));
        voucherList.add(new VoucherDomain("5% off Shell", R.drawable.shell_logo));

        adapter3 = new VoucherAdapter(voucherList, this);
        recyclerVoucher2.setAdapter(adapter3);
    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(VoucherPage.this, barcode.class);

        startActivity(intent);
    }
    public void home(View view){
        Intent intent = new Intent(VoucherPage.this, HomePage.class);
        startActivity(intent);
    }

    public void domestic(View view){
        Intent intent = new Intent(VoucherPage.this, DomesticAbuseSupport.class);
        startActivity(intent);
    }
    public void alcohol(View view){
        Intent intent = new Intent(VoucherPage.this, AlcoholSupport.class);
        startActivity(intent);

    }
    public void profile(View view) {
        Intent intent = new Intent(VoucherPage.this, profile.class);
        startActivity(intent);
    }
}