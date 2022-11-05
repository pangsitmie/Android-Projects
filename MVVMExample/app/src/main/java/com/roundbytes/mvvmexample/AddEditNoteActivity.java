package com.roundbytes.mvvmexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddEditNoteActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "com.roundbytes.mvvmexample.EXTRA_ID";
    public static final String EXTRA_TITLE = "com.roundbytes.mvvmexample.EXTRA_TITLE";
    public static final String EXTRA_DESC = "com.roundbytes.mvvmexample.EXTRA_DESC";
    public static final String EXTRA_PRIORITY = "com.roundbytes.mvvmexample.EXTRA_PRIORITY";

    private EditText titleET, descET;
    private NumberPicker priorityNP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        titleET = (EditText) findViewById(R.id.titleET);
        descET = (EditText) findViewById(R.id.descET);
        priorityNP = (NumberPicker) findViewById(R.id.priorityNP);

        priorityNP.setMinValue(1);
        priorityNP.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_ID)){
            setTitle("Edit Note");
            titleET.setText(intent.getStringExtra(EXTRA_TITLE));
            descET.setText(intent.getStringExtra(EXTRA_DESC));
            priorityNP.setValue(intent.getIntExtra(EXTRA_PRIORITY,1));
        }
        else{
            setTitle("Add Note");
        }

    }
    private void saveNote(){
        String title = titleET.getText().toString();
        String desc = descET.getText().toString();
        int priority = priorityNP.getValue();
        if(title.trim().isEmpty() || desc.trim().isEmpty()){
            Toast.makeText(this, "Please insert title and desc", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent();

        int id = getIntent().getIntExtra(EXTRA_ID,-1);

        if(id != -1){
            intent.putExtra(EXTRA_ID, id);
        }
        intent.putExtra(EXTRA_TITLE, title);
        intent.putExtra(EXTRA_DESC, desc);
        intent.putExtra(EXTRA_PRIORITY, priority);

        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}