package com.example.mobiletestapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        ImageView imageView;

        if (products.get(position).getImage() != null) {

            Picasso
                    .get()                                    //получаемые изображения пустые
                    .load(products.get(position).getImage())
                    .error(R.drawable.baseline_image_24)
                    .into(holder.imageView);
        } else {
            holder.imageView.setImageResource(R.drawable.baseline_image_24);
        }
//        Picasso
//                .get()
//                .load("https://merclondon.ru/upload/resize_cache/iblock/ebe/280_357_0/NEDDY_red_new_3.jpg")
//                .into(holder.imageView);

        if (products.get(position).getPrice() != null) {
            holder.nameTextView.setText(products.get(position).getName());
        } else {
            holder.nameTextView.setText("Название товара уточняется");
        }


        if (products.get(position).getPrice() != null) {
            products.get(position).SeparationPrice(products.get(position).getPrice());
            products.get(position).DivisionPrice(products.get(position).getWholePartPrice());
            holder.priceTextView.setText(products.get(position).getRankPrice() + " руб. " + products.get(position).getFractionalPartPrice() + " коп.");
        } else {
            holder.priceTextView.setText("Цена уточняется");
        }

        if (products.get(position).getArticle() != null) {
            holder.articleTextView.setText(products.get(position).getArticle());
        } else {
            holder.articleTextView.setText("Артикль уточняется");
        }

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {

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
