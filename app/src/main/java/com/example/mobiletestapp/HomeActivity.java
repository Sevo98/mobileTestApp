package com.example.mobiletestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    String URL = "https://d-element.ru/test_api.php";

    TextView idTextView, nameTextView, priceTextView, articleTextView;

    String name, price, article;

    JSONArray jsonStorage = new JSONArray();

    ArrayList<JSONObject> elements = new ArrayList<JSONObject>();

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_card);

        imageView = findViewById(R.id.imageView);
        nameTextView = findViewById(R.id.name);
        priceTextView = findViewById(R.id.price);
        articleTextView = findViewById(R.id.article);

        RequestQueue requestQueue = Volley.newRequestQueue(this);


        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                response -> {
                    Log.e("Rest Response", response.toString());
                    try {
                        JSONArray jsonArray = response.getJSONArray("items");
                        setJsonArray(jsonArray);

                        for (int i = 0; i < jsonStorage.length(); i++) {
                            elements.add(i, jsonStorage.getJSONObject(i));
                        }
                        name = (String) elements.get(0).get("name");
                        price = (String) elements.get(0).get("price").toString();
                        article = (String) elements.get(0).get("article").toString();

                        Picasso
                                .get()
                                .load("https://i.imgur.com/DvpvklR.png")
                                .into(imageView);


                        setValues();
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                },
                error -> Log.e("Rest Response Error", error.toString())
        );

        requestQueue.add(objectRequest);
    }

    private void setJsonArray(JSONArray jsonArray) {
        jsonStorage = jsonArray;
    }

    private void setValues() {
        nameTextView.setText(name);
        priceTextView.setText(price);
        articleTextView.setText(article);
    }
}