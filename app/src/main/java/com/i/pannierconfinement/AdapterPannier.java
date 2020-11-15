package com.i.pannierconfinement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class AdapterPannier extends RecyclerView.Adapter<AdapterPannier.ProduitsViewHolder> {

    Context context;
    TextView tvTotal;
    List<Produits> pannier;
    double total=0;

    public AdapterPannier(Context context, List<Produits> pannier, TextView tvTotal) {
        this.context = context;
        this.tvTotal = tvTotal;
        this.pannier = pannier;

        for (int i = 0 ; i < pannier.size() ; i++) {
            total = total + Double.parseDouble(""+pannier.get(i).getPrix());
        }

        tvTotal.setText(""+total);
    }

    @NonNull
    @Override
    public ProduitsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_pannier,null,false);
        return new AdapterPannier.ProduitsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitsViewHolder produitsViewHolder, int position) {
        produitsViewHolder.tvNombProduit.setText(pannier.get(position).getNomProd());
        produitsViewHolder.tvDescProduit.setText(pannier.get(position).getDesc());
        produitsViewHolder.tvTotal.setText(""+pannier.get(position).getPrix());

    }

    @Override
    public int getItemCount() {
        return pannier.size();
    }

    public class ProduitsViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombProduit, tvDescProduit, tvTotal;

        public ProduitsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombProduit = itemView.findViewById(R.id.tvNombProduit);
            tvDescProduit = itemView.findViewById(R.id.tvDescProduit);
            tvTotal = itemView.findViewById(R.id.tvTotal);


        }
    }
}
