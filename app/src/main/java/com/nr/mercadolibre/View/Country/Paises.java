package com.nr.mercadolibre.View.Country;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.nr.mercadolibre.Interface.Country.CountryInterface;
import com.nr.mercadolibre.Model.Entities.Country;
import com.nr.mercadolibre.Presenter.Country.CountryPresenter;
import com.nr.mercadolibre.R;
import com.nr.mercadolibre.View.Category.Categorias;

import java.util.ArrayList;
import java.util.List;

public class Paises extends AppCompatActivity implements CountryInterface.InterfaceView {
    ListView listaPaises;
    private CountryPresenter presenter;
    private ProgressBar progressbarLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        progressbarLoading=findViewById(R.id.progressbar_loading);
        listaPaises=findViewById(R.id.listaPaises);
        presenter = new CountryPresenter(this);
        requestData();
    }

    @Override
    public void requestData() {
        Log.i("Paises", "Solicitar paises");
        presenter.requestData();
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
    public void showApodDetails(List<Country> countries) {
        Log.i("Paises", "Solicitud   Ok: "+countries.size());
        ArrayList<String> list=new ArrayList<>();
        for (Country C:countries) {
            list.add(C.getName());
        }
        ArrayAdapter<String> a=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,list);
        listaPaises.setAdapter(a);
        listaPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showCategoryIntent = new Intent();
                showCategoryIntent.setClass(Paises.this, Categorias.class);
                showCategoryIntent.putExtra("pais", countries.get(position).getId());
                showCategoryIntent.putExtra("flag", true);
                startActivity(showCategoryIntent);
            }
         });

    }

}