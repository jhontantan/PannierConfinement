package com.i.pannierconfinement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvCmptProduct;
    Button btnPanier;
    RecyclerView rvListProducts;
    AdapterProduits adaptader;
    List<Produits> listProducts = new ArrayList<>();
    List<Produits> pannier = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        tvCmptProduct = findViewById(R.id.tvCmptProduct);
        btnPanier = findViewById(R.id.btnPanier);
        rvListProducts = findViewById(R.id.rvListProducts);
        rvListProducts.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));

        listProducts.add(new Produits("1","Manzana","Fruta",100));
        listProducts.add(new Produits("2","Pera","Fruta Verde",50));
        listProducts.add(new Produits("3","Banano","Fruta Amarilla",20));

        adaptader = new AdapterProduits(MainActivity.this,tvCmptProduct,btnPanier,listProducts,pannier);
        rvListProducts.setAdapter(adaptader);


    }
}