package com.ZhangZihao.model;

import java.io.InputStream;

public class Product {
    private int             ProductId   ;
    private String          ProductName ;
    private String          ProductDes  ;
    private InputStream     picture     ;
    private double          price       ;
    private int             CategoryId  ;

    public Product(){}
    public Product(int ProductId, String ProductName, String ProductDes, InputStream picture, double price, int CategoryId){
        this.ProductId      =   ProductId       ;
        this.ProductName    =   ProductName     ;
        this.ProductDes     =   ProductDes      ;
        this.picture        =   picture         ;
        this.price          =   price           ;
        this.CategoryId     =   CategoryId      ;
    }
    public Product(String ProductName, String ProductDes, InputStream picture, double price, int CategoryId){
        this.ProductName    =   ProductName     ;
        this.ProductDes     =   ProductDes      ;
        this.picture        =   picture         ;
        this.price          =   price           ;
        this.CategoryId     =   CategoryId      ;
    }
    public Product(String ProductName, double price, int CategoryId){
        this.ProductName    =   ProductName     ;
        this.price          =   price           ;
        this.CategoryId     =   CategoryId      ;
    }
    public Product(String ProductName, int CategoryId){
        this.ProductName    =   ProductName     ;
        this.CategoryId     =   CategoryId      ;
    }
    public Product(int ProductId){
        this.ProductId      =   ProductId       ;
    }

    //________________________________________________________________________
    public int getProductId() {
        return ProductId;
    }
    public String getProductName() {
        return ProductName;
    }
    public String getProductDes() {
        return ProductDes;
    }
    public InputStream getPicture() {
        return picture;
    }
    public double getPrice() {
        return price;
    }
    public int getCategoryId() {
        return CategoryId;
    }

    //________________________________________________________________________

    public void setProductId(int productId) {
        ProductId = productId;
    }
    public void setProductName(String productName) {
        ProductName = productName;
    }
    public void setProductDes(String productDes) {
        ProductDes = productDes;
    }
    public void setPicture(InputStream picture) {
        this.picture = picture;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    //________________________________________________________________________
    @Override
    public String toString(){
        return
                this.ProductId      +'\n'+
                this.ProductName    +'\n'+
                this.ProductDes     +'\n'+
                this.picture        +'\n'+
                this.price          +'\n'+
                this.CategoryId     +'\n';

    }
}
