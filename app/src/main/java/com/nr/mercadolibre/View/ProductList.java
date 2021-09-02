package com.nr.mercadolibre.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.nr.mercadolibre.Model.Entities.AtributosProduct;
import com.nr.mercadolibre.Model.Entities.Product;
import com.nr.mercadolibre.R;
import com.nr.mercadolibre.View.Adapter.AdapterProducto;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterProducto adapterProducto;
    private ArrayList<Product> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        recyclerView = findViewById(R.id.recycler1);
        productos=(ArrayList<Product>) getIntent().getSerializableExtra("Productos");
        adapterProducto = new AdapterProducto(productos,this);
        recyclerView.setAdapter(adapterProducto);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setVisibility(View.VISIBLE);
    }
}