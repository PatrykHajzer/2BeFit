package com.example.th.a2bfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LoadWeek extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_week);

        ListView ch1=(ListView) findViewById(R.id.LoadWeek);
        ch1.setClickable(true);
        String[] items={"Monday", "Thursday", "Saturday", "Sunday"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        ch1.setAdapter(adapter);
        ch1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SelectedDay();
            }
        });
    }
    public void SelectedDay(){
        Intent i = new Intent(this, LoadDay.class);
        startActivity(i);
    }
}
