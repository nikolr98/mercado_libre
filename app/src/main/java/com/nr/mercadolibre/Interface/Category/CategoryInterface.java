package com.nr.mercadolibre.Interface.Category;

import com.nr.mercadolibre.Model.Entities.Category;
import com.nr.mercadolibre.Model.Entities.Country;
import com.nr.mercadolibre.Model.Entities.Product;

import java.util.ArrayList;
import java.util.List;

public interface CategoryInterface {

    interface  InterfaceView{

        void requestData(String id);

        void showApodDetails(List<Category> countries);

    }


    interface  InterfacePresenter{

        void onSuccessResult(List<Category> countries);

        void requestData(String id);

    }

    interface  InterfaceModel{

        void querySearch(String id);

        void successfulQuery(ArrayList<Country> countries);


    }
}
