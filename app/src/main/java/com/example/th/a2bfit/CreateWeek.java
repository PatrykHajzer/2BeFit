package com.example.th.a2bfit;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CreateWeek extends AppCompatActivity {
    Button recipe_but;
    public ArrayList<String> selectedItems=new ArrayList<String>();
    public String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        Bundle loadBundle = getIntent().getExtras();
        assert loadBundle != null;
        fileName = loadBundle.getString("fileName");

        ListView ch1=(ListView) findViewById(R.id.weekListView);
        ch1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items={"Monday", "Tuesday", "Thursday", "Friday", "Saturday", "Sunday"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list_view_detail,R.id.txt_lan,items);
        ch1.setAdapter(adapter);
        ch1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=((TextView)view).getText().toString();
                if(selectedItems.contains(selectedItem)){
                    selectedItems.remove(selectedItem);
                }
                else{
                    selectedItems.add(selectedItem);
                }
            }
        });

        recipe_but = findViewById(R.id.nextBtn);
        recipe_but.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CreateDay();

            }
        });

        }
    public void CreateDay(){
        Intent i = new Intent(this, CreateDay.class);
        Bundle saveBundle = new Bundle();
        saveBundle.putString("fileName", fileName);
        saveBundle.putStringArrayList("selectedDay", selectedItems);
        i.putExtras(saveBundle);
        startActivity(i);
    }
}
