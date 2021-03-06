package com.example.myquizzesapplication.Game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myquizzesapplication.AllMainActivities.GameStartActivity;
import com.example.myquizzesapplication.Interfaces.ActivityInterfaceWithButtons;
import com.example.myquizzesapplication.R;

import java.util.ArrayList;

public class SelectionQuizzesToGameActivity extends AppCompatActivity implements ActivityInterfaceWithButtons {

    //wybór quizów do gry

    QuizzesSelectionGameAdapter adapter;
    RecyclerView recyclerView;
    TextView selectedTextView;
    Button OKButton, CANCELButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_quizzes_to_game);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setView();
        buttonsSettings();

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new QuizzesSelectionGameAdapter(this,selectedTextView,OKButton);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        adapter.initializeSelectedItemsList();
    }

    @Override
    public void buttonsSettings() {
        OKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> selectedItems = adapter.getSelectedItemsList();
                Intent intent = new Intent(SelectionQuizzesToGameActivity.this, GameStartActivity.class);
                intent.putExtra("SelectedItemsList",selectedItems);
                startActivity(intent);
                finish();
            }
        });
        CANCELButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void getDataFromIntent() {}

    @Override
    public void setView() {
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view_quiz_selection);
        selectedTextView = (TextView)findViewById(R.id.quantity_od_selected_quizzes);
        OKButton = (Button)findViewById(R.id.ok_button_quizzes_selected);
        CANCELButton = (Button)findViewById(R.id.calncel_button_quizzes_selected);

        recyclerView.setHasFixedSize(true);
    }
}
