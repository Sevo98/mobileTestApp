package com.example.mobiletestapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductListActivity extends AppCompatActivity {

    String URL = "https://d-element.ru/test_api.php";

    TextView idTextView, nameTextView, priceTextView, articleTextView;

    String name, price, article;

    JsonObjectRequest objectRequest;

    JSONArray jsonStorage = new JSONArray();

    ArrayList<JSONObject> elements = new ArrayList<JSONObject>();

    List<Product> products = new ArrayList<>();
    ImageView imageView;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_products);
//        setContentView(R.layout.product_card);

        recyclerView = findViewById(R.id.recycler_list);



//        nameTextView = findViewById(R.id.name);
//        priceTextView = findViewById(R.id.price);
//        articleTextView = findViewById(R.id.article);
//        imageView = findViewById(R.id.imageView);


        RequestQueue requestQueue = Volley.newRequestQueue(this);

        objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                response -> {
                    Log.e("Rest Response", response.toString());
                    try {
                        JSONArray jsonArray = response.getJSONArray("items");
                        setJsonArray(jsonArray);
                        Gson gson = new Gson();
                        for (int i = 0; i < jsonStorage.length(); i++) {
                            elements.add(i, jsonStorage.getJSONObject(i));
                            products.add(gson.fromJson(String.valueOf(elements.get(i)), Product.class));
                        }
                        Adapter adapter = new Adapter(this, products);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//                        setValues(products);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                },
                error -> Log.e("Rest Response Error", error.toString())
        );

        requestQueue.add(objectRequest);

//        recyclerView = findViewById(R.id.recycler_list);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
    }

    private void setJsonArray(JSONArray jsonArray) {
        jsonStorage = jsonArray;
    }

    private void setValues(ArrayList<Product> products) throws JSONException {
//        name = products.get(0).getName();
//        price = products.get(0).getPrice();
//        article = products.get(0).getArticle();
//
//        Picasso
//                .get()
//                .load("https://i.imgur.com/DvpvklR.png")
//                .into(imageView);
//
//        nameTextView.setText(name);
//        priceTextView.setText(price);
//        articleTextView.setText(article);
    }
}