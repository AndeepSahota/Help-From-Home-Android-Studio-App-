package com.example.helpfromhomeproject.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpfromhomeproject.Domain.FoodItemsDomain;
import com.example.helpfromhomeproject.Domain.RecyclerViewInterface;
import com.example.helpfromhomeproject.Domain.TopPicksDomain;
import com.example.helpfromhomeproject.R;

import java.util.ArrayList;

public class FoodBagsAdapter extends RecyclerView.Adapter<FoodBagsAdapter.Viewholder> {
    private final RecyclerViewInterface recyclerViewInterface;
    ArrayList<TopPicksDomain> topPicksList;

    public FoodBagsAdapter(ArrayList<TopPicksDomain> topPicksList, RecyclerViewInterface recyclerViewInterface) {
        this.topPicksList = topPicksList;
        this.recyclerViewInterface = recyclerViewInterface;


    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_top_picks, parent, false);
        return new Viewholder(inflate, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodBagsAdapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {


        holder.title.setText(topPicksList.get(position).getTitle());
        holder.price.setText(topPicksList.get(position).getPrice());
        holder.distance.setText(topPicksList.get(position).getDistance());
        //holder.description.setText(topPicksList.get(position).getDescription());
        holder.pic.setImageResource(topPicksList.get(position).getPic());

        //int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(TopPicksDomain.get(position).getPic(), "drawable",holder.itemView.getContext().getPackageName());
    }


    @Override
    public int getItemCount() {
        return topPicksList.size();
    }

    // Implements added on click listener 28/03
    public static class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, distance, price;
        ImageView pic;

        public Viewholder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            pic = itemView.findViewById(R.id.pic);
            distance = itemView.findViewById(R.id.distance);
            price = itemView.findViewById(R.id.price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

            title.setOnClickListener(this);
        }

        // Set for on click listener 28/03
        // @Override
        public void onClick(View view) {
            //Intent intent = new Intent (v.getContext(), RecyclerView.ViewHolder.class);
        }
    }
}


