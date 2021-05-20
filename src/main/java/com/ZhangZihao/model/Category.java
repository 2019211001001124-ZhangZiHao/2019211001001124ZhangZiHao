package com.ZhangZihao.model;


public class Category {

    private int CategoryId;
    private String CategoryName;
    private String Des;
    private String Active;

    public Category(){}
    Category(int CategoryId, String CategoryName, String Des, String Active){
        this.CategoryId     =   CategoryId     ;
        this.CategoryName   =   CategoryName   ;
        this.Des            =   Des            ;
        this.Active         =   Active         ;
    }
    public Category(String CategoryName, String Des, String Active){
        this.CategoryName   =   CategoryName   ;
        this.Des            =   Des            ;
        this.Active         =   Active         ;
    }
    public Category(String CategoryName, String Des){
        this.CategoryName   =   CategoryName   ;
        this.Des            =   Des            ;
    }
    public Category(String CategoryName){
        this.CategoryName   =   CategoryName   ;
    }
    public Category(int CategoryId){
        this.CategoryId     =   CategoryId     ;
    }



    //________________________________________________________________________

    public int getCategoryId() {
        return CategoryId;
    }
    public String getCategoryName() {
        return CategoryName;
    }
    public String getDes() {
        return Des;
    }
    public String getActive() {
        return Active;
    }
    //________________________________________________________________________

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }
    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
    public void setDes(String des) {
        Des = des;
    }
    public void setActive(String active) {
        Active = active;
    }
    //________________________________________________________________________

    @Override
    public String toString() {
        return
                CategoryId      +'\n'+
                CategoryName    +'\n'+
                Des             +'\n'+
                Active          +'\n';
    }
}
