package com.nr.mercadolibre.View.Category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.nr.mercadolibre.Interface.Category.CategoryInterface;
import com.nr.mercadolibre.Model.Entities.Category;
import com.nr.mercadolibre.Presenter.Category.CategoryPresenter;
import com.nr.mercadolibre.R;
import com.nr.mercadolibre.View.ProductCategory.ProductsCategory;

import java.util.ArrayList;
import java.util.List;

public class Categorias extends AppCompatActivity implements CategoryInterface.InterfaceView {
    private ListView listaCategoria;
    private CategoryPresenter presenter;
    private ProgressBar progressbarLoading;
    private String id_pais;
     boolean flagCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
        listaCategoria=findViewById(R.id.listaPaises);
        progressbarLoading=findViewById(R.id.progressbar_loading);
        flagCategoria = getIntent().getExtras().getBoolean("flag");
        id_pais=((flagCategoria)?getIntent().getExtras().getString("pais"):"MCO");
        presenter = new CategoryPresenter(this);
        requestData(id_pais);
    }


    @Override
    public void requestData( String id_pais) {
        Log.i("Categorias", "Categorias prais: "+id_pais);
        presenter.requestData(id_pais);

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
    public void showApodDetails(List<Category> categories) {
        Log.i("Categorias", "Consulta  Ok: "+categories.size());
        ArrayList<String> list=new ArrayList<>();
        for (Category C:categories) {
            list.add(C.getName());
        }
        ArrayAdapter<String> a=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,list);
        listaCategoria.setAdapter(a);
        listaCategoria.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showCategoryIntent = new Intent();
                showCategoryIntent.setClass(Categorias.this, ProductsCategory.class);
                showCategoryIntent.putExtra("categoria", categories.get(position).getId());
                showCategoryIntent.putExtra("pais",id_pais);
                startActivity(showCategoryIntent);
            }
        });

    }

}