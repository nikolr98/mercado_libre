package com.nr.mercadolibre.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nr.mercadolibre.Interface.Product.ProductInterface;
import com.nr.mercadolibre.Model.Entities.Product;
import com.nr.mercadolibre.Presenter.Product.ProductPresenter;
import com.nr.mercadolibre.R;
import com.nr.mercadolibre.View.Category.Categorias;
import com.nr.mercadolibre.View.Country.Paises;
import com.nr.mercadolibre.View.Product.ProductList;

import java.util.ArrayList;

public class ProductSearch extends AppCompatActivity implements ProductInterface.InterfaceView, SearchView.OnQueryTextListener {

    private ProductPresenter mPresenter;
    private LinearLayout errorbusqueda;
    private ProgressBar progressbarLoading;
    private TextView reintento;
    private LinearLayout notnetwork;
    private LinearLayout noResult;
    private ImageView menu;
    private ImageView imaBuscar;
    private androidx.appcompat.widget.SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_search);
        Log.i("ProductSearch", "onCreate DE ProductSearch ");
        initElements();
        menu.setOnClickListener(v -> OptionsMenu());
    }

    private void initElements() {
        mPresenter = new ProductPresenter(this,getApplicationContext());
        errorbusqueda=findViewById(R.id.errorbusqueda);
        reintento=findViewById(R.id.reintento);
        notnetwork=findViewById(R.id.notnetwork);
        menu=findViewById(R.id.menu);
        imaBuscar=findViewById(R.id.icono_buscar);
        noResult=findViewById(R.id.errorbusqueda);
        progressbarLoading=findViewById(R.id.progressbar_apoddetail_loading);
        searchView = findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        imaBuscar.setVisibility(View.VISIBLE);
        hideNetworkError();
        hideError();
    }

    private void OptionsMenu() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow( searchView.getWindowToken(), 0);
        RelativeLayout contenedor = (RelativeLayout) findViewById(R.id.principal);
        final LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        inflater.inflate(R.layout.nav_menu,contenedor,true);

        TextView categorias = findViewById(R.id.categorias);
        categorias.setOnClickListener(v -> {
            Log.i("ProductSearch", "Menu categorias");
            removeOptionsMenu();
            Intent i = new Intent(ProductSearch.this, Categorias.class);
            i.putExtra("flag", false);
            startActivity(i);

        });
        TextView paises = findViewById(R.id.paises);
        paises.setOnClickListener(v -> {
            Log.i("ProductSearch", "Menu paises");
            removeOptionsMenu();
            Intent i = new Intent(ProductSearch.this, Paises.class);
            startActivity(i);

        });

        RelativeLayout m = findViewById(R.id.menuOptions);
        m.setOnClickListener(v -> removeOptionsMenu());
    }
    private void removeOptionsMenu(){
        ViewGroup menu = findViewById(R.id.principal);
        RelativeLayout options = findViewById(R.id.menuOptions);
        menu.removeView(options);
    }

    @Override
    public void requestData(String q) {
        Log.i("ProductSearch", "Producto a buscar: "+q);
        imaBuscar.setVisibility(View.GONE);
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
        Log.i("ProductSearch", "Busqueda  Ok: "+productos.size());
        errorbusqueda.setVisibility(View.GONE);
        Intent showProductIntent = new Intent();
        showProductIntent.setClass(ProductSearch.this, ProductList.class);
        showProductIntent.putExtra("Productos",productos);
        startActivity(showProductIntent);
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
    public void showError() {
        noResult.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNetworkError() {
        notnetwork.setVisibility(View.GONE);
    }

    @Override
    public void hideError() {
        noResult.setVisibility(View.GONE);
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