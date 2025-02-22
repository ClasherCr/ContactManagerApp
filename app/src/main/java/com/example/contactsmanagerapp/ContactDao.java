package com.example.contactsmanagerapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDao {
    @Insert
    void insert(Contacts contacts);
    @Delete
    void delete(Contacts contacts);

    @Query("SELECT * FROM contacts_tabel")
    LiveData<List<Contacts>> getAllContacts();

}
