package com.example.mobiletestapp.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobiletestapp.Model.Product;
import com.example.mobiletestapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.myViewHolder> {

    Context mContext;

    List<Product> products;

    Uri imageUri = Uri.parse("https://i.imgur.com/DvpvklR.png");

    public ProductAdapter(Context mContext, List<Product> products) {
        this.mContext = mContext;
        this.products = products;
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
//        Picasso
//                .get()                                    //получаемые изображения пустые
//                .load(products.get(position).getImage())
//                .into(holder.imageView);

        Picasso
                .get()
                .load("https://i.imgur.com/DvpvklR.png")
                .into(holder.imageView);
        holder.nameTextView.setText(products.get(position).getName());
        holder.priceTextView.setText(products.get(position).getPrice());
        holder.articleTextView.setText(products.get(position).getArticle());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView, priceTextView, articleTextView;
        ImageView imageView;

        public myViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.name);
            priceTextView = itemView.findViewById(R.id.price);
            articleTextView = itemView.findViewById(R.id.article);
        }
    }
}
