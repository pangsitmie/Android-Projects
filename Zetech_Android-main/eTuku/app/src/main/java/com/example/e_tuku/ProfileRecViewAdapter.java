package com.example.e_tuku;

import android.content.Context;
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


public class ProfileRecViewAdapter extends RecyclerView.Adapter<ProfileRecViewAdapter.ViewHolder> {

    //initiate variables
    private Context mContext;
    private ArrayList<ProfileItemData> profileItemData = new ArrayList<>();

    public ProfileRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_item_card,parent,false);
        return new ProfileRecViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(profileItemData.get(position).getText());
        Glide.with(mContext)
                .asBitmap()
                .load(profileItemData.get(position).getIconURL())
                .into(holder.icon);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, profileItemData.get(position).getText()+" is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return profileItemData.size();
    }
    public void setProfileItemData(ArrayList<ProfileItemData> profileItemData) {
        this.profileItemData = profileItemData;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView parent;
        TextView title;
        ImageView icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.profileCardParent);
            title = itemView.findViewById(R.id.profileItemText);
            icon = itemView.findViewById(R.id.profileItemIcon);


        }
    }
}

