package com.ttyooyu.market.data.entity;

import android.graphics.drawable.Drawable;

/**
 * author: Jwen
 * date:2016-09-01.
 */
public class Category extends Soul{
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(Drawable img, String name) {
        this.img = img;
        this.name = name;
    }

    public String name;//分类名称
    public Drawable img;//分类图标
}
