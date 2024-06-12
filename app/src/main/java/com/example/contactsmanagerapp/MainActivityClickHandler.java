package com.example.contactsmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class MainActivityClickHandler {

    MainActivity contacts;
    private Context context;

    public MainActivityClickHandler(MainActivity contacts) {
        this.contacts = contacts;
        this.context = contacts;
    }

    public void onFABClicked(View view){
        Intent i = new Intent(view.getContext(), AddNewContactActivity.class);
        context.startActivity(i);
    }
}
