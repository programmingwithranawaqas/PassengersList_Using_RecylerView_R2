package com.example.passengerslist_r2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PassengerAdapter.OnSinglePassengerClicked {

    ArrayList<Passenger> passengers;
    PassengerAdapter adapter;
    RecyclerView rvList;
    Button btnAddNP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // hooks
        rvList = findViewById(R.id.rvList);
        btnAddNP = findViewById(R.id.btnAddNP);
        rvList.setLayoutManager(new LinearLayoutManager(this));

        passengers = new ArrayList<>();
        passengers.add(new Passenger("bus", "Raza", "B", "Islam"));
        passengers.add(new Passenger("plane", "Shahzaib khaqan", "A-", "Islam"));
        passengers.add(new Passenger("train", "Asim Raza", "O+", "Islam"));
        passengers.add(new Passenger("bus", "Nabeel", "B+", "Islam"));
        passengers.add(new Passenger("plane", "Mohsin Shareef", "A+", "Islam"));
        passengers.add(new Passenger("bus", "Chris Gill", "B+", "Non-Muslim"));

        adapter = new PassengerAdapter(this, passengers);
        rvList.setAdapter(adapter);

        btnAddNP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passengers.add(new Passenger("plane", "Jahangir Tareen", "AB+", "Muslim"));
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, passengers.size()+"", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(int position) {
        Toast.makeText(this, passengers.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}