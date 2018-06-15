package com.example.th.a2bfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button createPlanBtn;
    private TableLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.TrainingBtn);
        layout = findViewById(R.id.layout);
        createPlanBtn = findViewById(R.id.AddPlan);
        createPlanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddPlan();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trainignAct();
            }
        });
    }
    public void trainignAct(){
        Intent i = new Intent(this, LoadPlan.class);
        startActivity(i);
    }
    public void AddPlan(){
//        ArrayList plan1 = new ArrayList();
//        Bundle b = new Bundle();
//        b.putStringArrayList("create", plan1);
        Intent i = new Intent(this, Create.class);
//        i.putExtras(b);
        startActivity(i);
    }
}
