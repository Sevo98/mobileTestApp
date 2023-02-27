package com.example.mobiletestapp.Model;

public class Product {
    private String id, name, price, article, image;

    int wholePartPrice, fractionalPartPrice;

    public Product() {
    }

    public Product(String id, String name, String price, String article, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.article = article;
        this.image = image;
    }

    public void SeparationPrice(String price) {
        double tempPrice = Double.parseDouble(price);

        this.wholePartPrice = (int) tempPrice;

        this.fractionalPartPrice = (int) ((tempPrice - this.wholePartPrice) * 100);
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getWholePartPrice() {
        return wholePartPrice;
    }

    public void setWholePartPrice(int wholePartPrice) {
        this.wholePartPrice = wholePartPrice;
    }

    public int getFractionalPartPrice() {
        return fractionalPartPrice;
    }

    public void setFractionalPartPrice(int fractionalPartPrice) {
        this.fractionalPartPrice = fractionalPartPrice;
    }
}
