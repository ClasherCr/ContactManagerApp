package com.example.contactsmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {

    Contacts contacts;
    Context context;
    MyViewModel myViewModel;

    public AddNewContactClickHandler(Contacts contacts,
                                     Context context,
                                     MyViewModel myViewModel) {
        this.contacts = contacts;
        this.context = context;
        this.myViewModel = myViewModel;
    }

    public void onSubmitBtnClick(View view){

        if (contacts.getName() == null || contacts.getEmail() == null) {
            Toast.makeText(context,
                    "Field Cannot Be Empty",
                    Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(context,MainActivity.class);
//            i.putExtra("Name",contacts.getName());
//            i.putExtra("Email",contacts.getEmail());

            Contacts c = new Contacts(
                    contacts.getName(),
                    contacts.getEmail()
            );

            myViewModel.addNewContact(c);


            context.startActivity(i);
        }

    }

}
