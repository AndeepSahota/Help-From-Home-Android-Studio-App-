package com.example.helpfromhomeproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpfromhomeproject.Adapter.FoodBagsAdapter;
import com.example.helpfromhomeproject.Domain.RecyclerViewInterface;
import com.example.helpfromhomeproject.Domain.TopPicksDomain;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity implements RecyclerViewInterface {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategory, recyclerViewFoodbags, recyclerViewBreakfast, recyclerViewGroceries;
    private ArrayList<TopPicksDomain> topPicksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        //recyclerViewCategory();
        recyclerViewFoodbags();
        recyclerViewBreakfast();
        recyclerViewGroceries();
    }

    public void recyclerViewFoodbags() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFoodbags = findViewById(R.id.view2);
        recyclerViewFoodbags.setLayoutManager(linearLayoutManager);

        topPicksList = new ArrayList<>();
        topPicksList.add(new TopPicksDomain("Greggs", R.drawable.greggs, "£2.50", "5km", "Enjoy a delicious Greggs food bag filled with tasty treats perfect for breakfast or lunch. This bag includes a freshly baked sausage roll, a fluffy bacon roll with your choice of ketchup or brown sauce, a cheese and onion bake with a crispy golden crust, and a classic Belgian bun topped with sweet icing and fruity currants. Satisfy your hunger with this delightful food bag from Greggs."));
        topPicksList.add(new TopPicksDomain("CoCos", R.drawable.cocos, "£5.50", "8km", "Indulge in Cocos' delectable dessert bag that's sure to satisfy your sweet tooth! The bag includes an assortment of mouth-watering desserts such as their signature chocolate cake, creamy cheesecake, and fruit tartlets. Perfect for a special occasion or just a sweet treat, this dessert bag is sure to leave you wanting more."));
        topPicksList.add(new TopPicksDomain("Asda", R.drawable.asda, "£6.80", "3km", "Asda's food bag contains a mix of fresh produce and pantry staples, providing you with everything you need for a hearty meal. The bag includes items such as pasta, rice, tinned goods, fresh fruit, vegetables, and meat. With Asda's food bag, you can easily prepare delicious and nutritious meals."));

        adapter2 = new FoodBagsAdapter(topPicksList, this);
        recyclerViewFoodbags.setAdapter(adapter2);
    }

    public void recyclerViewBreakfast() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewBreakfast = findViewById(R.id.view3);
        recyclerViewBreakfast.setLayoutManager(linearLayoutManager);

        topPicksList = new ArrayList<>();
        topPicksList.add(new TopPicksDomain("Greggs", R.drawable.greggs, "£2.50", "5km", "Enjoy a delicious Greggs food bag filled with tasty treats perfect for breakfast or lunch. This bag includes a freshly baked sausage roll, a fluffy bacon roll with your choice of ketchup or brown sauce, a cheese and onion bake with a crispy golden crust, and a classic Belgian bun topped with sweet icing and fruity currants. Satisfy your hunger with this delightful food bag from Greggs."));
        topPicksList.add(new TopPicksDomain("OneStop Baguette ", R.drawable.onestop, "£2.00", "8km", "Indulge in Cocos' delectable dessert bag that's sure to satisfy your sweet tooth! The bag includes an assortment of mouth-watering desserts such as their signature chocolate cake, creamy cheesecake, and fruit tartlets. Perfect for a special occasion or just a sweet treat, this dessert bag is sure to leave you wanting more."));
        topPicksList.add(new TopPicksDomain("One Pound Bakery", R.drawable.poundbakery, "£0.89", "3km", "Asda's food bag contains a mix of fresh produce and pantry staples, providing you with everything you need for a hearty meal. The bag includes items such as pasta, rice, tinned goods, fresh fruit, vegetables, and meat. With Asda's food bag, you can easily prepare delicious and nutritious meals."));

        adapter2 = new FoodBagsAdapter(topPicksList, this);
        recyclerViewBreakfast.setAdapter(adapter2);
    }

    public void recyclerViewGroceries() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewGroceries = findViewById(R.id.view4);
        recyclerViewGroceries.setLayoutManager(linearLayoutManager);

        topPicksList = new ArrayList<>();
        topPicksList.add(new TopPicksDomain("Asda", R.drawable.asda, "£2.50", "5km", "Enjoy a delicious Greggs food bag filled with tasty treats perfect for breakfast or lunch. This bag includes a freshly baked sausage roll, a fluffy bacon roll with your choice of ketchup or brown sauce, a cheese and onion bake with a crispy golden crust, and a classic Belgian bun topped with sweet icing and fruity currants. Satisfy your hunger with this delightful food bag from Greggs."));
        topPicksList.add(new TopPicksDomain("Tesco", R.drawable.tescos, "£2.00", "8km", "Indulge in Cocos' delectable dessert bag that's sure to satisfy your sweet tooth! The bag includes an assortment of mouth-watering desserts such as their signature chocolate cake, creamy cheesecake, and fruit tartlets. Perfect for a special occasion or just a sweet treat, this dessert bag is sure to leave you wanting more."));
        topPicksList.add(new TopPicksDomain("Morrisons", R.drawable.morrisons, "£0.89", "3km", "Asda's food bag contains a mix of fresh produce and pantry staples, providing you with everything you need for a hearty meal. The bag includes items such as pasta, rice, tinned goods, fresh fruit, vegetables, and meat. With Asda's food bag, you can easily prepare delicious and nutritious meals."));

        adapter2 = new FoodBagsAdapter(topPicksList, this);
        recyclerViewGroceries.setAdapter(adapter2);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(HomePage.this, FoodPage.class);
        // Title
        String title = topPicksList.get(position).getTitle();
        intent.putExtra("TITLE", title);
        // Price
        String price = topPicksList.get(position).getPrice();
        intent.putExtra("price", price);
        // Picture

        int pic = topPicksList.get(position).getPic();
        intent.putExtra("picture", pic);

        // Distance
        String distance = topPicksList.get(position).getDistance();
        intent.putExtra("distance", distance);
        // Description.
        String description = topPicksList.get(position).getDescription();
        intent.putExtra("foodDescription", description);

        startActivity(intent);
    }

    public void donation(View view){
        Intent intent = new Intent(HomePage.this, Donation.class);
        startActivity(intent);
    }
    public void voucher(View view){
        Intent intent = new Intent(HomePage.this, VoucherPage.class);
        startActivity(intent);
    }

    public void domestic(View view){
        Intent intent = new Intent(HomePage.this, DomesticAbuseSupport.class);
        startActivity(intent);
    }
    public void alcohol(View view){
        Intent intent = new Intent(HomePage.this, AlcoholSupport.class);
        startActivity(intent);

    }
    public void profile(View view) {
        Intent intent = new Intent(HomePage.this, profile.class);
        startActivity(intent);
    }
}
