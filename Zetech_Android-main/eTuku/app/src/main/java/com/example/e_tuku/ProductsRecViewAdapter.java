package com.example.e_tuku;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ProductsRecViewAdapter extends RecyclerView.Adapter<ProductsRecViewAdapter.ViewHolder>{

    private static final String TAG = "ProductsRecViewAdapter";


    private ArrayList<ProductData> products = new ArrayList<>();
    private double totalPrice=0.0;

    //initiate variables
    private Context mContext;
    private TextView checkoutPrice;


    public ProductsRecViewAdapter(Context mContext, TextView checkoutPrice) {
        this.mContext = mContext;
        this.checkoutPrice = checkoutPrice;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row_card,parent,false);
        return new ProductsRecViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: Called");

        //format harga menjadi Rp 2500
        String priceFormat=NumberFormat.getCurrencyInstance(new Locale("id","ID")).format(products.get(position).getPrice());
        //holder input
        holder.qty.setText(String.valueOf(products.get(position).getQty()));
        holder.productTitle.setText(products.get(position).getTittle());//untuk update name di rec view
        holder.productDescription.setText(products.get(position).getDescription());//untuk update name di rec view
        //holder.price.setText(priceUnit+products.get(position).getPrice());
        holder.price.setText(priceFormat);
        Glide.with(mContext)
                .asBitmap()
                .load(products.get(position).getImgUrl())
                .into(holder.productImage);
        //add button pressed and add to shopping cart
        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, products.get(position).getTittle()+" has been added to shopping cart", Toast.LENGTH_SHORT).show();
                products.get(position).addQty();
                holder.qty.setText(String.valueOf(products.get(position).getQty()));
                double addedPrice= products.get(position).getPrice();
                totalPrice +=addedPrice;
                String checkoutPriceFormat=NumberFormat.getCurrencyInstance(new Locale("id","ID")).format(totalPrice);
                String totalPriceString = String.valueOf(checkoutPriceFormat);
                checkoutPrice.setText(totalPriceString);//chechkout price dari card nde bawah(beda card) dapet dari constructor
            }
        });

        holder.minBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, products.get(position).getTittle()+" has been removed to shopping cart", Toast.LENGTH_SHORT).show();
                products.get(position).minQty();
                holder.qty.setText(String.valueOf(products.get(position).getQty()));
                double addedPrice= products.get(position).getPrice();
                totalPrice -=addedPrice;
                String checkoutPriceFormat=NumberFormat.getCurrencyInstance(new Locale("id","ID")).format(totalPrice);
                String totalPriceString = String.valueOf(checkoutPriceFormat);
                checkoutPrice.setText(totalPriceString);//chechkout price dari card nde bawah(beda card) dapet dari constructor
            }
        });


    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    //set arraylist setter
    public void setProducts(ArrayList<ProductData> products) {
        this.products = products;
        notifyDataSetChanged();
    }




    //--------------------------------------------------------------------------------
    //inner class
    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView parent;
        TextView productTitle, productDescription, price,qty;
        ImageView productImage;
        Button addBtn,minBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.parent);

            productTitle = itemView.findViewById(R.id.productTitle);
            productDescription = itemView.findViewById(R.id.productDescription);
            productImage = itemView.findViewById(R.id.productImg);
            price = itemView.findViewById(R.id.productPrice);
            addBtn = itemView.findViewById(R.id.addBtn);
            minBtn = itemView.findViewById(R.id.minBtn);
            qty = itemView.findViewById(R.id.qtyText);

        }
    }


}
