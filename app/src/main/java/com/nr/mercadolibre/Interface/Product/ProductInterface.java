package com.nr.mercadolibre.Interface.Product;


import com.nr.mercadolibre.Model.Entities.Product;

import java.util.ArrayList;

public interface ProductInterface {

    //En esta interfaz se tiene todos los metedos que va usar la activity ProductSearch
    interface  InterfaceView{

        void requestData(String q);

        //Para mostrar el progressbar mientras se cargan los datos
        void showProgresBar();

        //Para ocultar el progressbar cuando ya se cargaron los datos
        void hideProgresBar();

        //Va obtener del ApodDetailPresenter los datos que le pidio al modelo que van a ir dentro de la vista
        void showApodDetails(ArrayList<Product> productos);

        //Va mostrar un error si no se trae la informacion
        void showNetworkError();

        //Un boton para buscar la informacion nuevamente del servidor
        void reloadData();

    }

    //En esta interfaz se tiene todos los metedos que va a usar ProductoPresenter
    interface  InterfacePresenter{

        //El presenter ya tiene los datos y las muestra a la vista
        void onSuccessResult(ArrayList<Product> productos);

        //Aqui el presenter busca los datos
        void requestData(String q);

        //Aqui el presenter muestre error en caso de que la consulta falle
        void onFailureResult();

    }

    //En esta interfaz se tiene todos los metedos que va a usar ProductInteractor
    interface  InterfaceModel{

        //Consulta
        void querySearch(String q);

        //Resultado exitoso
        void successfulQuery(ArrayList<Product> productos);

        //Resultado Fallido
        void onFailureResult();
    }
}
