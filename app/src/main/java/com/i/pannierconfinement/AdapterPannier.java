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

    public AdapterPannier(Context context, TextView tvTotal, List<Produits> pannier) {
        this.context = context;
        this.tvTotal = tvTotal;
        this.pannier = pannier;

        for (int i = 0 ; i < pannier.size() ; i++) {
            total = total + Double.parseDouble(""+pannier.get(i).getPrix());

        }
    }

    @NonNull
    @Override
    public ProduitsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_produits,null,false);
        return new AdapterPannier.ProduitsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitsViewHolder produitsViewHolder, int position) {
        produitsViewHolder.tvNombProduit.setText(listProduits.get(position).getNomProd());
        produitsViewHolder.tvDescProduit.setText(listProduits.get(position).getDesc());
        produitsViewHolder.tvPrix.setText(""+listProduits.get(position).getPrix());

        produitsViewHolder.cbPanier.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (produitsViewHolder.cbPanier.isChecked() == true) {
                    tvCmptProduct.setText(""+Integer.parseInt(tvCmptProduct.getText().toString().trim())+1);
                    pannier.add(listProduits.get(position));
                }
            }
        });

        btnPanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Pannier.class);
                intent.putExtra("Pannier", (Serializable) pannier );
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listProduits.size();
    }

    public class ProduitsViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombProduit, tvDescProduit, tvPrix;
        CheckBox cbPanier;

        public ProduitsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombProduit = itemView.findViewById(R.id.tvNombProduit);
            tvDescProduit = itemView.findViewById(R.id.tvDescProduit);
            tvPrix = itemView.findViewById(R.id.tvPrix);
            cbPanier = itemView.findViewById(R.id.cbPanier);


        }
    }
}
