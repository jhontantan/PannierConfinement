package com.i.pannierconfinement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class AdapterProduits extends RecyclerView.Adapter<AdapterProduits.ProduitsViewHolder> {

    Context context;
    TextView tvCmptProduct;
    Button btnPanier;
    List<Produits> listProduits;
    List<Produits> pannier;

    public AdapterProduits(Context context, TextView tvCmptProduct, Button btnPanier, List<Produits> listProduits, List<Produits> pannier) {
        this.context = context;
        this.tvCmptProduct = tvCmptProduct;
        this.btnPanier = btnPanier;
        this.listProduits = listProduits;
        this.pannier = pannier;
    }

    @NonNull
    @Override
    public ProduitsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_produits,null,false);
        return new AdapterProduits.ProduitsViewHolder(v);
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
                    tvCmptProduct.setText(""+(Integer.parseInt(tvCmptProduct.getText().toString().trim())+1));
                    pannier.add(listProduits.get(position));
                }
                else if (produitsViewHolder.cbPanier.isChecked() == false) {
                    tvCmptProduct.setText(""+(Integer.parseInt(tvCmptProduct.getText().toString().trim())-1));
                    pannier.remove(listProduits.get(position));
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
