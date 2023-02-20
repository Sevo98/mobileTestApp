package com.example.mobiletestapp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    Context mContext;

    List<Product> mData;

    Uri imageUri = Uri.parse("https://i.imgur.com/DvpvklR.png");

    public Adapter(Context mContext, List<Product> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.product_card, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
//        holder.imageView.setImageURI(imageUri);
        holder.nameTextView.setText(mData.get(position).getName());
        holder.priceTextView.setText(mData.get(position).getPrice());
        holder.articleTextView.setText(mData.get(position).getArticle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView, priceTextView, articleTextView;
        ImageView imageView;

        public myViewHolder(View itemView) {
            super(itemView);
//            Picasso
//                    .get()
//                    .load("https://i.imgur.com/DvpvklR.png")
//                    .into(imageView);

            nameTextView = itemView.findViewById(R.id.name);
            priceTextView = itemView.findViewById(R.id.price);
            articleTextView = itemView.findViewById(R.id.article);
        }
    }
}
