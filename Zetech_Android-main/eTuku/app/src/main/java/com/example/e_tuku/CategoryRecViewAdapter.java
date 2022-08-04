package com.example.e_tuku;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryRecViewAdapter extends  RecyclerView.Adapter<CategoryRecViewAdapter.ViewHolder>{


    private static final String TAG = "CategoryRecViewAdapter";

    private ArrayList<CategoryData> category = new ArrayList<>();
    private Context mContext;

    public CategoryRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    //import these 3 method by ctrl+i
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //iku R.layout itu harus ngambil cardview mana seng mau mbo jadino templete
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");

        //holder.txtProductName.setText(products.get(position).getName());
        holder.txtProductTitle.setText(category.get(position).getName());//untuk update name di rec view
        Glide.with(mContext)
                .asBitmap()
                .load(category.get(position).getImgUrl())
                .into(holder.imgProduct);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext, category.get(position).getName()+"selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, ProductsActivity.class);
                mContext.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    //set arraylist setter
    public void setCategory(ArrayList<CategoryData> category) {
        this.category = category;
        notifyDataSetChanged();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgProduct;
        private TextView txtProductTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtProductTitle = itemView.findViewById(R.id.txtProductTitle);
        }
    }
}
