package com.example.chores.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.chores.AddJobsActivity;
import com.example.chores.ProfileActivity;
import com.example.chores.R;

public class bnvUtils {

    public static void startNav(final Context context, BottomNavigationView bnv){
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.icon_home:
                        Intent intentHome = new Intent(context, AddJobsActivity.class);
                        context.startActivity(intentHome);
                        break;
                    case R.id.icon_search:
                        Intent intentSearch = new Intent(context, AddJobsActivity.class);
                        context.startActivity(intentSearch);
                        break;
                    case R.id.icon_person:
                        Intent intentPerson = new Intent(context, ProfileActivity.class);
                        context.startActivity(intentPerson);
                        break;

                }
                return false;
            }
        });
    }

}
