package io.db.webproject.entities;

import javax.persistence.*;

@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int goodid;
    private String GoodName;
    private int category_id;
    private int manufactur_id;
    private int count;
    private int price;
    public Goods(){}
    public Goods(String GoodName, int category_id, int manufactur_id, int count, int price){
        this.GoodName = GoodName;
        this.category_id = category_id;
        this.manufactur_id = manufactur_id;
        this.count = count;
        this.price = price;
    }

    public int getGoodid() {
        return goodid;
    }

    public String getGoodName() {
        return GoodName;
    }

    public int getCategory_id() {
        return category_id;
    }

    public int getManufactur_id() {
        return manufactur_id;
    }


    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public void setName(String name) {
        this.GoodName = name;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setManufactur_id(int manufactur_id) {
        this.manufactur_id = manufactur_id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
