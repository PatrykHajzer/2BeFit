package com.example.th.a2bfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Create extends AppCompatActivity {
    EditText editText;
    Button button;
    public ArrayList<String> selectedItems=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        editText = (EditText) findViewById(R.id.planName);
        button =(Button) findViewById(R.id.createBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateWeek();
            }
        });



    }
    public void CreateWeek(){
        Intent i = new Intent(this, CreateWeek.class);
        String t = String.valueOf(editText.getText());
        i.putExtra("fileName", t);
        startActivity(i);
    }
}
