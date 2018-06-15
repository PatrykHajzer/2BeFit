package com.example.th.a2bfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LoadDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_day);


        ListView ch1=(ListView) findViewById(R.id.loadExercises);
        String[] items={"Przysiady ze sztangą set's: 6  rep's 8/8/6/6/4/4",
                "Wiosłowanie w podchwycie set's: 4  rep's 10/8/8/6",
                "Wyciskanie hantli set's: 4  rep's 10/8/8/6",
                "Face pull set's: 4  rep's 8/8/8/8",
                "Dips set's:3 rep's 6/6/6",
                "Uginanie ramion z gryfem set's:3 rep's 10/10/10",
                "Palloff press set's: 3 rep's 10/10/10"
        };

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        ch1.setAdapter(adapter);
    }

}
