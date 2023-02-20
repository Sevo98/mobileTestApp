package com.example.mobiletestapp.Activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mobiletestapp.R;
import com.example.mobiletestapp.Model.Product;
import com.example.mobiletestapp.Adapter.ProductAdapter;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    String URL = "https://d-element.ru/test_api.php";

    JsonObjectRequest objectRequest;

    JSONArray jsonStorage = new JSONArray();

    ArrayList<JSONObject> elements = new ArrayList<>();

    List<Product> products = new ArrayList<>();
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_products);

        recyclerView = findViewById(R.id.recycler_list);

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
                        ProductAdapter productAdapter = new ProductAdapter(this, products);
                        recyclerView.setAdapter(productAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
}