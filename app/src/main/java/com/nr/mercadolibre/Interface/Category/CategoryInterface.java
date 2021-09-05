package com.nr.mercadolibre.Interface.Category;

import com.nr.mercadolibre.Model.Entities.Category;
import java.util.List;

public interface CategoryInterface {

    interface  InterfaceView{

        void requestData(String id_pais);

        void showApodDetails(List<Category> categories);

        void showProgresBar();

        void hideProgresBar();

    }


    interface  InterfacePresenter{

        void onSuccessResult(List<Category> categories);

        void requestData(String id_pais);

    }

    interface  InterfaceModel{

        void querySearch(String id_pais);

        void successfulQuery(List<Category> categories);

    }
}
