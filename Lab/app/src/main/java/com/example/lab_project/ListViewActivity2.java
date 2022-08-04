package com.example.lab_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity2 extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);


        lv = (ListView) findViewById(R.id.lv);


        ArrayList<Users> userList = new ArrayList<>();
        for (int i=1;i<=500;i++)
        {
            Users user = new Users("User "+i, "desc "+i);
            userList.add(user);
        }
        Log.d("TAG", "onCreate: "+ userList.get(8).getTitle());

        ListAdapter adapter = new ListAdapter(this, R.layout.listview_layout, userList);
        lv.setAdapter(adapter);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Users listItem = (Users) lv.getItemAtPosition(position);
                String title = listItem.getTitle();

                Intent intent = new Intent(getApplicationContext(), RadioButtonActivity3.class);
                Bundle bundle = new Bundle();
                bundle.putString("title",title);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}