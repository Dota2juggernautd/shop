package com.example.shop;

public class State {

    private String name; // название
    private String capital;  // столица
    private int flagResource; // ресурс флага

    private float price; // Цена

    public State(String name, String capital, int flag, float price){

        this.name=name;
        this.capital=capital;
        this.flagResource=flag;
        this.price=price;
    }
    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.name = String.valueOf(price);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getFlagResource() {
        return this.flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }
}