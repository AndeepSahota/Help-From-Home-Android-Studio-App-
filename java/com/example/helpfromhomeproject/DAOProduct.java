package com.example.helpfromhomeproject;

import com.example.helpfromhomeproject.Domain.TopPicksDomain;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOProduct {
    private DatabaseReference databaseReference;
    public DAOProduct()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(TopPicksDomain.class.getSimpleName());
    }
    public Task<Void> add(TopPicksDomain product)
    {

        return databaseReference.push().setValue(product);
    }
}
