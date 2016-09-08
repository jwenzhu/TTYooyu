package com.ttyooyu.market.data.entity;

/**
 * author: Jwen
 * date:2016-08-31.
 */
public class Product extends Soul{

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, String price, int isAdvertisement) {
        this.name = name;
        this.price = price;
        this.isAdvertisement = isAdvertisement;
    }

    public String name;
    public String price;
    public int isAdvertisement;

}
