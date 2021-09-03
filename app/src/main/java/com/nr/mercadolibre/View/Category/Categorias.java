package com.nr.mercadolibre.View.Category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nr.mercadolibre.Interface.Category.CategoryInterface;
import com.nr.mercadolibre.Model.Entities.Category;
import com.nr.mercadolibre.Model.Entities.Country;
import com.nr.mercadolibre.Presenter.Category.CategoryPresenter;
import com.nr.mercadolibre.Presenter.Country.CountryPresenter;
import com.nr.mercadolibre.R;
import com.nr.mercadolibre.View.Country.Paises;

import java.util.ArrayList;
import java.util.List;

public class Categorias extends AppCompatActivity implements CategoryInterface.InterfaceView {
    private ListView listaCategoria;
    private CategoryPresenter presenter;
    private String id;
     boolean flagCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
        listaCategoria=findViewById(R.id.listaPaises);
        flagCategoria = getIntent().getExtras().getBoolean("cat");
        id=((flagCategoria)?getIntent().getExtras().getString("pais"):"MLA");

        presenter = new CategoryPresenter(this);
        requestData(id);
    }


    @Override
    public void requestData( String id) {
        presenter.requestData(id);

    }


    @Override
    public void showApodDetails(List<Category> categories) {
        ArrayList<String> list=new ArrayList<>();
        for (Category C:categories) {
            list.add(C.getName());
        }
        ArrayAdapter<String> a=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,list);
        listaCategoria.setAdapter(a);

    }

}