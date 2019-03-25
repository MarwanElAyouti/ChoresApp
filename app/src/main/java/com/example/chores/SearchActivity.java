package com.example.chores;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.chores.Utils.bnvUtils;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnvSetup();
    }
    private void bnvSetup(){
        BottomNavigationView bnv =findViewById(R.id.bottom_navigation);
        bnvUtils.startNav(SearchActivity.this, bnv);
        Menu menu = bnv.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);


    }
}
