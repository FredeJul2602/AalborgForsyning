package com.example.aalborgforsyning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    // initialize variable
    DrawerLayout drawerLayout;

    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // assign variable
        drawerLayout = findViewById(R.id.drawer_layout);

        // sorteringsguide button
        button = findViewById(R.id.btn_sorteringsguide);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, test2.class);
                startActivity(intent);
            }
        });


    }

    public void ClickMenu(View view) {
        //Open drawer
        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view) {
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view) {
        // Redirect activity to home
        MainActivity.redirectActivity(this, MainActivity.class);
    }

    public void ClickDashboard(View view) {
        // recreate activity
        recreate();
    }

    public void ClickAboutUs(View view) {
        // redirect activity to about us
        MainActivity.redirectActivity(this,AboutUs.class);
    }

    public void ClickLogout(View view) {
        // close app
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // close drawer
        MainActivity.closeDrawer(drawerLayout);
    }
}