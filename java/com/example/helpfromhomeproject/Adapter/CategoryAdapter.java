package com.example.helpfromhomeproject.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;
import com.example.helpfromhomeproject.Domain.FoodItemsDomain;
import com.example.helpfromhomeproject.R;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<FoodItemsDomain> FoodItmesDomains;
    public CategoryAdapter(ArrayList<FoodItemsDomain> FoodItemsDomains){
        this.FoodItmesDomains = FoodItemsDomains;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(FoodItmesDomains.get(position).getTitle());
        holder.categoryPic.setImageResource(FoodItmesDomains.get(position).getPic());

        //Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.categoryPic);
    }

    @Override
    public int getItemCount() {

        return FoodItmesDomains.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
TextView categoryName;
ImageView categoryPic;
ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName=itemView.findViewById(R.id.categoryName);
            categoryPic=itemView.findViewById(R.id.categoryPic);

        }
    }
}
