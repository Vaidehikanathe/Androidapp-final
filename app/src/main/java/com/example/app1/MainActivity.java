package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    ImageButton buttonDrawerToggle;
    Button button1;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerLayout);
        buttonDrawerToggle=findViewById(R.id.buttonDrawerToggle);
        navigationView=findViewById(R.id.navigationView);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
//When this button is clicked, it opens the drawer layout.
        buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.open();
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
                int itemId= Item.getItemId();

                if (itemId==R.id.home){
                    Toast.makeText(MainActivity.this, "Home Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemId==R.id.complaint){
                    Toast.makeText(MainActivity.this, "Complaint Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemId==R.id.query){
                    Toast.makeText(MainActivity.this, "Query Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemId==R.id.about){
                    Toast.makeText(MainActivity.this, "About Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemId == R.id.logout) {
                    // Handle logout action here
                    logout();
                }
                drawerLayout.close();

                return false;
            }
        });



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new activity for button1
                Intent intent = new Intent(MainActivity.this, button1activity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new activity for button2
                Intent intent = new Intent(MainActivity.this, button1activity.class);
                startActivity(intent);
            }
        });

}
    private void logout() {
        // Perform logout actions here
        // For example, clear user session, navigate to login screen, etc.

        // For demonstration, let's assume LoginActivity is your login activity class
        Intent intent = new Intent(this, Loginact.class);
//        flag_Act_clear_top  clear the activity stack, removing all activities above the targeted activity
//        flag_act_new_task  the new activity will be started in a new task
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // Finish the current activity to prevent returning to it via back button
        Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
    }
    }