package com.nr.mercadolibre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.nr.mercadolibre.Tools.Logger;
import com.nr.mercadolibre.Tools.PermissionStatus;
import com.nr.mercadolibre.View.ProductSearch;


public class SplashScreen extends AppCompatActivity {
    private PermissionStatus permissionStatus;
    private Boolean isIntent=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        permissionStatus = new PermissionStatus(SplashScreen.this, this);
        //permissionStatus.permissionWriteSettings();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (permissionStatus.firstTry) {
            permissionStatus.confirmPermissionMsg();
        } else {
            permissionStatus.reqPermissions();
        }

        if(permissionStatus.validatePermissions() && isIntent){
            new Handler().postDelayed(() -> {
                Log.i("SplashScreen", "Inicio app");
                Intent i = new Intent(SplashScreen.this, ProductSearch.class);
                startActivity(i);
                finish();
            },2000);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isIntent=true;
    }
}