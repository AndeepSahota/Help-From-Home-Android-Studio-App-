package com.example.helpfromhomeproject.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpfromhomeproject.Domain.RecyclerViewInterface;
import com.example.helpfromhomeproject.Domain.VoucherDomain;
import com.example.helpfromhomeproject.R;

import java.util.ArrayList;

public class VoucherAdapter extends RecyclerView.Adapter<VoucherAdapter.Viewholder> {
    private final RecyclerViewInterface recyclerViewInterface;
    ArrayList<VoucherDomain> voucherList;

    public VoucherAdapter(ArrayList<VoucherDomain> voucherList, RecyclerViewInterface recyclerViewInterface) {
        this.voucherList = voucherList;
        this.recyclerViewInterface = recyclerViewInterface;

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_vouchers, parent, false);
        return new Viewholder(inflate, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.company.setText(voucherList.get(position).getCompany());
        holder.pic.setImageResource(voucherList.get(position).getPic());
    }



    @Override
    public int getItemCount() {
        return voucherList.size();
    }

    // Implements added on click listener 28/03
    public static class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView company;
        ImageView pic;

        public Viewholder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            company = itemView.findViewById(R.id.company);
            pic = itemView.findViewById(R.id.pic);
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

            company.setOnClickListener(this);
        }

        // Set for on click listener 28/03
        // @Override
        public void onClick(View view) {
            //Intent intent = new Intent (v.getContext(), RecyclerView.ViewHolder.class);
        }
    }
}
