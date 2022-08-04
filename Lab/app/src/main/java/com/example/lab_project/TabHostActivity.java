package com.example.lab_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class TabHostActivity extends AppCompatActivity {

    TextView tvDate, tvTime;
    Button dateBtn, timeBtn;

    //listview
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);

        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        dateBtn = findViewById(R.id.dateBtn);
        timeBtn = findViewById(R.id.timeBtn);

        lv = (ListView) findViewById(R.id.lv);

        ArrayList<Users> userList = new ArrayList<>();
        for (int i=0;i<500;i++)
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
                Toast.makeText(getApplicationContext(), String.valueOf(position)+" Selected", Toast.LENGTH_SHORT).show();
//                Users listItem = (Users) lv.getItemAtPosition(position);
//                AlertDialog.Builder builder = new AlertDialog.Builder(TabHostActivity.this);
//                builder.setTitle("Result");
//                builder.setIcon(R.drawable.ic_privacy);
//                builder.setMessage(listItem.getTitle()+" selected");
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                    }
//                });
//                builder.show();
            }
        });

//        CALENDER
        final Calendar mCalendar = Calendar.getInstance();




//        TABHOST
        final TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec TS;
        TS = tabHost.newTabSpec("");
        TS.setContent(R.id.tab1);
        TS.setIndicator("Set Date");
        tabHost.addTab(TS);

        TS = tabHost.newTabSpec("");
        TS.setContent(R.id.tab2);
        TS.setIndicator("Set Time");
        tabHost.addTab(TS);

        TS = tabHost.newTabSpec("");
        TS.setContent(R.id.tab3);
        TS.setIndicator("ListView");
        tabHost.addTab(TS);

        TS = tabHost.newTabSpec("");
        TS.setContent(R.id.tab4);
        TS.setIndicator("About");
        tabHost.addTab(TS);

//      BUTTONS
//        Date
        final DatePickerDialog.OnDateSetListener dateSetListener;
        dateSetListener =  new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String setDate = year+"-"+String.valueOf(month+1)+"-"+dayOfMonth;
                Log.d("tag", setDate);
                tvDate.setText(setDate);
            }
        };
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(TabHostActivity.this,dateSetListener,
                        mCalendar.get(Calendar.YEAR),
                        mCalendar.get(Calendar.MONTH),
                        mCalendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });

//        Time
        final TimePickerDialog.OnTimeSetListener onTimeSetListener;
        onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String setTime = hourOfDay + ":" + minute;
                Log.d("tag", setTime);
                tvTime.setText(setTime);
            }
        };

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog = new TimePickerDialog(TabHostActivity.this, onTimeSetListener,
                        mCalendar.get(Calendar.HOUR),
                        mCalendar.get(Calendar.MINUTE),
                        false);
                dialog.show();
            }
        });




    }
}