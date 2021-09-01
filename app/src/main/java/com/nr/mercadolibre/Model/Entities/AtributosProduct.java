package com.nr.mercadolibre.Model.Entities;

import java.io.Serializable;

public class AtributosProduct implements Serializable {
    private String name;
    private String value_name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue_name() {
        return value_name;
    }

    public void setValue_name(String value_name) {
        this.value_name = value_name;
    }
}