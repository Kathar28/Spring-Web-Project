package io.db.webproject.entities;

import javax.persistence.*;

@Entity
public class manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int manufactur_id;

    private String manufactur_name;

    private int category_id;
    public manufacturer(){}

    public manufacturer(String manufactur_name, int category_id){
        this.manufactur_name = manufactur_name;
        this.category_id = category_id;
    }

    public int getManufactur_id(){return manufactur_id;}

    public void setManufactur_id(int manufactur_id){
        this.manufactur_id = manufactur_id;
    };

    public String getManufactur_name(){return manufactur_name;}

    public void setManufactur_name(String manufactur_name) {
        this.manufactur_name = manufactur_name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
