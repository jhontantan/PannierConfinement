package com.i.pannierconfinement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Pannier extends AppCompatActivity {

    List<Produits> pannier;
    AdapterPannier adapter;
    RecyclerView rvListPannier;
    TextView tvTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pannier);
        getSupportActionBar().hide();

        pannier = (List<Produits>) getIntent().getSerializableExtra("Pannier");

        rvListPannier = findViewById(R.id.rvListPannier);
        rvListPannier.setLayoutManager(new GridLayoutManager(Pannier.this,1));
        tvTotal = findViewById(R.id.tvTotal);

        adapter = new AdapterPannier(Pannier.this, pannier,tvTotal);
        rvListPannier.setAdapter(adapter);

    }
}