package com.nr.mercadolibre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.nr.mercadolibre.View.ProductSearch;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(() -> {
            Intent i = new Intent(SplashScreen.this, ProductSearch.class);
            startActivity(i);
            finish();
        },2000);
    }
}