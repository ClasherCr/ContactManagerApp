package com.example.contactsmanagerapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Repository {

    private final ContactDao contactDao;
    ExecutorService executor;
    Handler handler;

    public Repository(Application application) {


        ContactDatabase contactDatabase = ContactDatabase.getDbInstance(application);
        this.contactDao = contactDatabase.getContactDAO();

        executor = Executors.newSingleThreadExecutor();

         handler = new Handler(Looper.getMainLooper());

    }

    public void addContact(Contacts contacts){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDao.insert(contacts);
            }
        });


    }
    public void deleteContact(Contacts contacts){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDao.delete(contacts);
            }
        });


    }
    public LiveData<List<Contacts>> getAllContacts(){
        return contactDao.getAllContacts();
    }





}
