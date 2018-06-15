package com.example.th.a2bfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CreateDay extends Activity {
    ArrayList<String> selectedDay;
    Button button;
    String fileName;
    ArrayList <Exercise> exerciseArrayList = null;
    ListView exListView;
    ExerciseAdapter exerciseAdapter;
    EditText exName;
    EditText exSet;
    EditText exRep;

    Button createEx;
    TextView textView;

    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_day);
        //Przypisywanie elementów frontu do backu
        exName = findViewById(R.id.exName);
        exSet = findViewById(R.id.exSet);
        exRep = findViewById(R.id.exRep);
        createEx = findViewById(R.id.createExBtn);
        button = findViewById(R.id.nextDayBtn);
        textView = findViewById(R.id.dayText);

        //Rozpakowywanie bundle
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        if(bundle.containsKey("inc")){ this.x = bundle.getInt("inc"); }
        else { this.x = 0; }

        String fileName = bundle.getString("fileName");
        selectedDay = bundle.getStringArrayList("selectedDay");
        assert selectedDay != null;
        //Tworzenie nagłówka
        String day = selectedDay.get(x);
        textView.setText(day);

        //Tworze arrayList dla tego cwiczenia
        //arraylist, adapter, listview
//        exListView = findViewById(R.id.exList);
//        exerciseArrayList = new ArrayList<Exercise>();
//        exerciseAdapter = new ExerciseAdapter(this, exerciseArrayList);
//        exListView.setAdapter(exerciseAdapter);





        //Button listener dla create exercise
        createEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = String.valueOf(exName.getText());
                int set = Integer.valueOf(String.valueOf(exSet.getText()));
                int rep = Integer.valueOf(String.valueOf(exRep.getText()));
                // dodaje elementy do listy

                Exercise newExercise = new Exercise(name, set, rep);
                exerciseAdapter.add(newExercise);
            }
        });

        //Button listener dla next
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextDay();

            }
        });


    }

    private void NextDay(){
        this.x++;
        if(x >= this.selectedDay.size()){
            Intent i = new Intent(this, MainActivity.class);
        }
        else {
            Intent i = new Intent(this, CreateDay.class);
            Bundle saveBundle = new Bundle();
            saveBundle.putInt("inc", x);
            saveBundle.putString("fileName", fileName);
            saveBundle.putStringArrayList("selectedDay", selectedDay);
            i.putExtras(saveBundle);
            startActivity(i);
        }
    }


}

