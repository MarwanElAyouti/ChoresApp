package com.example.chores.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.chores.Models.User;

@Database(entities = {User.class}, version = 2, exportSchema = false)

public abstract class UserDatabase extends RoomDatabase {
    
    public abstract com.example.chores.Database.UserDao getUserDao();

}
