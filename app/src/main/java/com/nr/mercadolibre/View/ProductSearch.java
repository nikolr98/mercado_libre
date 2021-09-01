package com.nr.mercadolibre.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nr.mercadolibre.Interface.Product.ProductInterface;
import com.nr.mercadolibre.Model.Entities.Product;
import com.nr.mercadolibre.Presenter.ProductPresenter;
import com.nr.mercadolibre.R;
import com.nr.mercadolibre.View.Adapter.AdapterProducto;

import java.util.ArrayList;

public class ProductSearch extends AppCompatActivity implements ProductInterface.InterfaceView, SearchView.OnQueryTextListener {

    private ProductPresenter mPresenter;
    private TextView txterror;
    private RecyclerView recyclerView;
    private AdapterProducto adapterProducto;
    androidx.appcompat.widget.SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_search);
        mPresenter = new ProductPresenter(this,getApplicationContext());
        txterror=findViewById(R.id.txterror);
        recyclerView = findViewById(R.id.recycler1);
        searchView = findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public void requestData(String q) {
        mPresenter.requestData(q);
    }

    @Override
    public void showProgresBar() {

    }

    @Override
    public void hideProgresBar() {

    }

    @Override
    public void showResult() {

    }

    @Override
    public void hideResult() {

    }

    @Override
    public void showApodDetails(ArrayList<Product> productos) {
        txterror.setVisibility(View.GONE);
        adapterProducto = new AdapterProducto(productos,this);
        recyclerView.setAdapter(adapterProducto);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void fetchProductDetails() {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void reloadData() {

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
}