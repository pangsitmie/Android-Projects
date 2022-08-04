package com.example.lab_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

   /*Toolbar*/
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()) {
            case R.id.nav_listView:
                intent = new Intent(this, ListViewActivity.class);
                Toast.makeText(getApplicationContext(), "Lab 4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_tabHost:
                intent = new Intent(this, TabHostActivity.class);
                Toast.makeText(getApplicationContext(), "Lab 5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_radioButton:
                intent = new Intent(this, RadioButtonActivity.class);
                Toast.makeText(getApplicationContext(), "Lab 6", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_Notification:
                intent = new Intent(this, NotificationActivity.class);
                Toast.makeText(getApplicationContext(), "Lab 7", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_Fragment:
                intent = new Intent(this, FragmentActivity.class);
                Toast.makeText(getApplicationContext(), "Lab 7", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_Sensors:
                intent = new Intent(this, SensorsActivity.class);
                Toast.makeText(getApplicationContext(), "Lab 8", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_move_image:
                intent = new Intent(this, MoveImageActivity.class);
                Toast.makeText(getApplicationContext(), "Lab 8 Bonus", Toast.LENGTH_SHORT).show();
                break;

        }
        startActivity(intent);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}
