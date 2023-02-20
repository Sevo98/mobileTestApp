package com.example.mobiletestapp;

import android.view.View;

import org.json.JSONObject;

public interface ProductClickListener {
       void onClick(View view, int adapterPosition, boolean isLongClick);
}
