package com.nr.mercadolibre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.nr.mercadolibre.Tools.Logger;
import com.nr.mercadolibre.Tools.PermissionStatus;
import com.nr.mercadolibre.View.ProductSearch;


public class SplashScreen extends AppCompatActivity {
    private PermissionStatus permissionStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        permissionStatus = new PermissionStatus(SplashScreen.this, this);
        permissionStatus.permissionWriteSettings();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (permissionStatus.firstTry) {
            permissionStatus.confirmPermissionMsg();
        } else {
            permissionStatus.reqPermissions();
        }

        if(permissionStatus.validatePermissions()){
            new Handler().postDelayed(() -> {
                Intent i = new Intent(SplashScreen.this, ProductSearch.class);
                startActivity(i);
                finish();
            },2000);
        }
    }
}