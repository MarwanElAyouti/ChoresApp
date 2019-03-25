package com.example.chores;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


import com.example.chores.Utils.bnvUtils;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bnvSetup();
        toolbarSetup();
    }
    private void bnvSetup(){
        BottomNavigationView bnv =findViewById(R.id.bottom_navigation);
        bnvUtils.startNav(ProfileActivity.this, bnv);
        Menu menu = bnv.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
    }
    private void toolbarSetup(){
        Toolbar toolbar = findViewById(R.id.toolbarProfile);
        setSupportActionBar(toolbar);
        ImageView settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

}
