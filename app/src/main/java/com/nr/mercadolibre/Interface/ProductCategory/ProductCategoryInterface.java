package com.nr.mercadolibre.Interface.ProductCategory;

import com.nr.mercadolibre.Model.Entities.Product;

import java.util.ArrayList;

public interface ProductCategoryInterface {
    //En esta interfaz se tiene todos los metedos que va usar la activity ProductSearch
    interface  InterfaceView{

        void requestData(String id_pais,String id_categoria);

        //Para mostrar el progressbar mientras se cargan los datos
        void showProgresBar();

        //Para ocultar el progressbar cuando ya se cargaron los datos
        void hideProgresBar();

        //Va obtener del ApodDetailPresenter los datos que le pidio al modelo que van a ir dentro de la vista
        void showApodDetails(ArrayList<Product> productos);


    }

    //En esta interfaz se tiene todos los metedos que va a usar ProductoPresenter
    interface  InterfacePresenter{

        //El presenter ya tiene los datos y las muestra a la vista
        void onSuccessResult(ArrayList<Product> productos);

        //Aqui el presenter busca los datos
        void requestData(String id_pais,String id_categoria);


    }

    //En esta interfaz se tiene todos los metedos que va a usar ProductInteractor
    interface  InterfaceModel{

        //Consulta
        void querySearch(String id_pais,String id_categoria);

        //Resultado exitoso
        void successfulQuery(ArrayList<Product> productos);

    }
}
