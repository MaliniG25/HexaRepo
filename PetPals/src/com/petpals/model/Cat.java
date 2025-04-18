package com.petpals.model;

public class Cat extends Pet {
    private String catColor;

    public Cat(String name, int age, String breed, String catColor) {
        super(name, age, breed);
        this.catColor = catColor;
    }

    // Getters and Setters
    public String getCatColor() { return catColor; }
    public void setCatColor(String catColor) { this.catColor = catColor; }
}