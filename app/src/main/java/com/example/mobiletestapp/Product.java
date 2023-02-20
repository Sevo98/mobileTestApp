package com.example.mobiletestapp;

public class Product {
    private String id, name, price, article;

    public Product() {
    }

    public Product(String id, String name, String price, String article) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.article = article;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
