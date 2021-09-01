package com.nr.mercadolibre.Model.Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaProduct implements Serializable {
    ArrayList<Product> results;

    public ArrayList<Product> getResults() {
        return results;
    }

    public void setResults(ArrayList<Product> results) {
        this.results = results;
    }
}