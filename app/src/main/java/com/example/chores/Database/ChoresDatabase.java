package com.example.chores.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.chores.Entities.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)

public abstract class ChoresDatabase extends RoomDatabase {

    public abstract UserDAO getUserDao();

}
