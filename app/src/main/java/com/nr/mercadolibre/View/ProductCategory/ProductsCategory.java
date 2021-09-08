package com.nr.mercadolibre.View.ProductCategory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nr.mercadolibre.Interface.ProductCategory.ProductCategoryInterface;
import com.nr.mercadolibre.Model.Entities.Product;
import com.nr.mercadolibre.Presenter.ProductCategory.ProductCategoryPresenter;
import com.nr.mercadolibre.R;
import com.nr.mercadolibre.View.Adapter.AdapterProducto;

import java.util.ArrayList;

public class ProductsCategory extends AppCompatActivity implements ProductCategoryInterface.InterfaceView {
    private String id_pais;
    private String id_categoria;
    private ProductCategoryPresenter mPresenter;
    private LinearLayout errorbusqueda;
    private ProgressBar progressbarLoading;
    private TextView reintento;
    private LinearLayout notnetwork;
    private LinearLayout noResult;
    private ImageView menu;
    private RecyclerView recyclerView;
    private AdapterProducto adapterProducto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_category);
        mPresenter = new ProductCategoryPresenter(this,getApplicationContext());
        recyclerView = findViewById(R.id.recycler1);
        errorbusqueda=findViewById(R.id.errorbusqueda);
        reintento=findViewById(R.id.reintento);
        notnetwork=findViewById(R.id.notnetwork);
        menu=findViewById(R.id.menu);
        noResult=findViewById(R.id.errorbusqueda);
        progressbarLoading=findViewById(R.id.progressbar_loading);
        id_pais=getIntent().getExtras().getString("pais");
        id_categoria=getIntent().getExtras().getString("categoria");
        requestData(id_pais,id_categoria);
    }


    @Override
    public void requestData(String id_pais,String id_categoria) {
        Log.i("ProductsCategory", "Productos por categoria "+"id_pais: "+id_pais+"  id_categoria  "+id_categoria);
        mPresenter.requestData(id_pais,id_categoria);

    }

    @Override
    public void showProgresBar() {
        progressbarLoading.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgresBar() {
        progressbarLoading.setVisibility(View.GONE);

    }

    @Override
    public void showApodDetails(ArrayList<Product> productos) {
        Log.i("ProductsCategory", "Productos por categoria "+"id_pais: "+id_pais+"  id_categoria  "+id_categoria);
        adapterProducto = new AdapterProducto(productos,this);
        recyclerView.setAdapter(adapterProducto);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setVisibility(View.VISIBLE);

    }

}