package com.example.market;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListItemMarketAdapterActivity extends RecyclerView.Adapter<ListItemMarketAdapterActivity.ViewHolder> {

    private int listItemLayout;
    private ArrayList<Item> itemList;

    public ListItemMarketAdapterActivity(int listItemLayout, ArrayList<Item> itemList) {
        this.listItemLayout = listItemLayout;
        this.itemList = itemList;
    }



    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position < itemList.size()){
            Item item = itemList.get(position);
            holder.title.setText(item.title);
            holder.description.setText(item.description);
            holder.image.setImageResource(item.img);
        }
    }



    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public TextView description;
        public ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.TextViewTitleRow);
            description = itemView.findViewById(R.id.textDescriptionRow);
            image = itemView.findViewById(R.id.imageViewRow);
        }

        @Override
        public void onClick(View view) {
            TextView titleTextView = view.findViewById(R.id.TextViewTitleRow);
            Toast.makeText(view.getContext(), ":D -"+titleTextView.getText(), Toast.LENGTH_SHORT).show();
            Log.d("onclick", "onClick"+ getLayoutPosition()+""+titleTextView.getText());
        }
    }
}