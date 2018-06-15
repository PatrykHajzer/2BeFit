package com.example.th.a2bfit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ExerciseAdapter extends ArrayAdapter<Exercise> {

    public ExerciseAdapter(@NonNull CreateDay context, ArrayList<Exercise> exercises) {
        super((Context) context, android.R.layout.simple_list_item_1, exercises);

    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Exercise exercise = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
        }
        // Lookup view for data population
        TextView exerciseRow = (TextView) convertView.findViewById(R.id.exercise_row);
        TextView setRow = (TextView) convertView.findViewById(R.id.set_row);
        TextView repRow = (TextView) convertView.findViewById(R.id.rep_row);
        // Populate the data into the template view using the data object
        assert exercise != null;
        exerciseRow.setText(exercise.name);
        setRow.setText(exercise.setNum);
        repRow.setText(exercise.repNum);
        // Return the completed view to render on screen
        return convertView;
    }
}
