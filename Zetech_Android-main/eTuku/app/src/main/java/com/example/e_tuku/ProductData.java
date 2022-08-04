package com.example.e_tuku;

import java.text.NumberFormat;
import java.util.Locale;

public class ProductData {
    private String tittle;
    private String description;
    private String imgUrl;
    private double price;
    private int qty;


    public ProductData(String tittle, String description, String imgUrl, double price, int qty) {
        this.tittle = tittle;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
        this.qty = qty;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void addQty()
    {
        qty++;
    }
    public void minQty(){qty--;}

    @Override
    public String toString() {
        return "ProductData{" +
                "tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
