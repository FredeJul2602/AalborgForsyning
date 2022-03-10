package com.example.aalborgforsyning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class AboutUs extends AppCompatActivity {

    // initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        // assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
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
        // redirect activity to dashboard
        MainActivity.redirectActivity(this,Dashboard.class);
    }

    public void ClickAboutUs(View view) {
        // recreate activity
        recreate();
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