package com.example.chores;

import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.chores.Utils.bnvUtils;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnvSetup();
    }

    /** Runs when the "TEST SETTINGS" button on the home screen is pressed */
    public void testSettings(View view) {
        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
    }

    public void testAddJobs(View view) {
         startActivity(new Intent(MainActivity.this, AddJobsActivity.class));
    }
/** Runs when the "TEST NOTIFICATION" button on the home screen is pressed */
    public void testNotification(View view) {
        Notification.Builder a = ChoresNotificationHelper
                .notificationBuilder(this, "This", "is a test");
        ChoresNotificationHelper.notifyWithBuilder(this, a);
    }
    private void bnvSetup(){
        BottomNavigationView bnv =findViewById(R.id.bottom_navigation);
        bnvUtils.startNav(MainActivity.this, bnv);
        Menu menu = bnv.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
    }
}
