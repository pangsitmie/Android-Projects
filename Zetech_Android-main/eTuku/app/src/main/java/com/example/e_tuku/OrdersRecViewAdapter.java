package com.example.e_tuku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class OrdersRecViewAdapter extends RecyclerView.Adapter<OrdersRecViewAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<ProductData> orders = new ArrayList<>();

    public OrdersRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_item_card,parent,false);
        return new OrdersRecViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //string price format
        String priceFormat= NumberFormat.getCurrencyInstance(new Locale("id","ID")).format((orders.get(position).getPrice())*(orders.get(position).getQty()));
        //holder input
        holder.orderTitle.setText(orders.get(position).getTittle());
        holder.orderQty.setText("Qty: "+String.valueOf(orders.get(position).getQty())+" . ");
        holder.orderTotalPrice.setText(priceFormat);
        Glide.with(mContext)
                .asBitmap()
                .load(orders.get(position).getImgUrl())
                .into(holder.orderImg);

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public void setOrderItemData(ArrayList<ProductData> orders) {
        this.orders = orders;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView parent;
        ImageView orderImg;
        TextView orderTitle, orderQty, orderTotalPrice, orderDate;
        Button btnDetails;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.orderCardViewParent);
            orderTitle = itemView.findViewById(R.id.orderTitle);
            orderQty = itemView.findViewById(R.id.orderQty);
            orderTotalPrice = itemView.findViewById(R.id.orderTotalPrice);
            orderDate = itemView.findViewById(R.id.orderDate);
            orderImg = itemView.findViewById(R.id.orderImg);
            btnDetails = itemView.findViewById(R.id.btnDetails);
        }
    }
}
