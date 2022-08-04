package com.example.e_tuku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView categoryRecView;
    private CategoryRecViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       /* categoryRecView = findViewById(R.id.categoryRecView);
        adapter = new CategoryRecViewAdapter(this);

        categoryRecView.setAdapter(adapter);
        categoryRecView.setLayoutManager(new GridLayoutManager(this, 3));


        ArrayList<CategoryData> category = new ArrayList<>();
        category.add(new CategoryData("Vegetables", "https://img.icons8.com/color/48/000000/finocchio.png","this is vegetables"));
        category.add(new CategoryData("Food Material", "https://img.icons8.com/color/48/000000/rice-bowl.png", "this is rice"));
        category.add(new CategoryData("Fruit", "https://img.icons8.com/cotton/64/000000/grape.png","this is Fruit"));
        category.add(new CategoryData("Spices", "https://img.icons8.com/cotton/64/000000/onion--v1.png","this is Spices"));
        category.add(new CategoryData("Liquid", "https://img.icons8.com/fluent/48/000000/technical-fluid.png","this is liquid"));
        category.add(new CategoryData("Snack", "https://img.icons8.com/color/48/000000/nachos.png","this is snack"));


        adapter.setCategory(category);*/

        //set the bottom navigation view
       BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
       bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
       //make the first time create to homeFragment
       getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new  BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selected = null;
                    switch (item.getItemId()){
                        case R.id.nav_home :
                            selected = new HomeFragment();
                            //Toast.makeText(HomeActivity.this, "home selected", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.nav_orders:
                            selected = new OrdersFragment();
                            //Toast.makeText(HomeActivity.this, "order selected", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.nav_profile:
                            selected = new ProfileFragment();
                            //Toast.makeText(HomeActivity.this, "profile selected", Toast.LENGTH_SHORT).show();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,selected).commit();
                    return true;

                }
            };
}