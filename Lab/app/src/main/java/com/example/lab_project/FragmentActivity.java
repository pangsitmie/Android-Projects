package com.example.lab_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class FragmentActivity extends AppCompatActivity {
    private ArrayList<View> viewList = new ArrayList<>();
    private ViewPager viewPager;
    private int currentFragmentID =0;
    private Button prevBtn, nextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        prevBtn = findViewById(R.id.prevBtn);
        nextbtn = findViewById(R.id.nextBtn);
        viewPager = findViewById(R.id.viewPager);
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());

        View v1 = (inflater.inflate(R.layout.fragment_1, null));
        View v2 = (inflater.inflate(R.layout.fragment_2, null));
        View v3 = (inflater.inflate(R.layout.fragment_3, null));

        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);

        viewPager.setAdapter(new VPAdapter(viewList));
        viewPager.setCurrentItem(currentFragmentID);

        ImageView img1 = (ImageView) v1.findViewById(R.id.imgView);
        ImageView img2 = (ImageView) v2.findViewById(R.id.imgView);
        ImageView img3 = (ImageView) v3.findViewById(R.id.imgView);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("key",currentFragmentID);

                Intent intent = new Intent(getApplicationContext(), FragmentResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("key",currentFragmentID);

                Intent intent = new Intent(getApplicationContext(), FragmentResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("key",currentFragmentID);

                Intent intent = new Intent(getApplicationContext(), FragmentResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentFragmentID!=0)
                    currentFragmentID --;
                else
                    currentFragmentID = viewList.size()-1;
                viewPager.setCurrentItem(currentFragmentID);
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentFragmentID!=viewList.size()-1)
                    currentFragmentID ++;
                else
                    currentFragmentID = 0;
                viewPager.setCurrentItem(currentFragmentID);
            }
        });

    }
}