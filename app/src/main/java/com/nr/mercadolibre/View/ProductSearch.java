package com.nr.mercadolibre.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nr.mercadolibre.Interface.Product.ProductInterface;
import com.nr.mercadolibre.Model.Entities.Product;
import com.nr.mercadolibre.Presenter.ProductPresenter;
import com.nr.mercadolibre.R;
import com.nr.mercadolibre.View.Adapter.AdapterProducto;

import java.util.ArrayList;

public class ProductSearch extends AppCompatActivity implements ProductInterface.InterfaceView, SearchView.OnQueryTextListener {

    private ProductPresenter mPresenter;
    private LinearLayout errorbusqueda;
    private AdapterProducto adapterProducto;
    private ProgressBar progressbarLoading;
    private TextView reintento;
    private LinearLayout notnetwork;
    androidx.appcompat.widget.SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_search);
        mPresenter = new ProductPresenter(this,getApplicationContext());
        errorbusqueda=findViewById(R.id.errorbusqueda);
        reintento=findViewById(R.id.reintento);
        notnetwork=findViewById(R.id.notnetwork);
        progressbarLoading=findViewById(R.id.progressbar_apoddetail_loading);
        searchView = findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public void requestData(String q) {
        mPresenter.requestData(q);
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
        errorbusqueda.setVisibility(View.GONE);
        Context context = this;
        Intent showPostIntent = new Intent();
        showPostIntent.setClass(context, ProductList.class);
        showPostIntent.putExtra("Productos",productos);
        context.startActivity(showPostIntent);
    }

    @Override
    public void showNetworkError() {
        notnetwork.setVisibility(View.VISIBLE);

    }

    @Override
    public void reloadData() {
        notnetwork.setVisibility(View.GONE);
        requestData(searchView.getQuery().toString());
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchView.clearFocus();
        requestData(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    public  void onViewClickedReload(View view){reloadData();}
}