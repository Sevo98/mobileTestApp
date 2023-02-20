package com.example.mobiletestapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView nameTextView, priceTextView, articleTextView;
    ImageView imageView;

    public ProductClickListener listener;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        Picasso
                .get()
                .load("https://i.imgur.com/DvpvklR.png")
                .into(imageView);

        nameTextView = itemView.findViewById(R.id.name);
        priceTextView = itemView.findViewById(R.id.price);
        articleTextView = itemView.findViewById(R.id.article);

    }

    @Override
    public void onClick(View view) {
listener.onClick(view, getAdapterPosition(), false);
    }
}
