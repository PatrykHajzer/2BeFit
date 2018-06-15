package com.example.th.a2bfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoadPlan extends AppCompatActivity {
    Button plan1;
    Button plan2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_plan);
        plan1 = findViewById(R.id.plan1);
        plan2 = findViewById(R.id.plan2);
        plan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadWeek();
            }
        });
        plan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadWeek();
            }
        });



    }
    public void LoadWeek(){
        Intent i = new Intent(this, LoadWeek.class);
        startActivity(i);
    }
}
