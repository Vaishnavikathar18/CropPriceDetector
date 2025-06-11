package com.example.model;

public class Crop {
    private String name;
    private String season;
    private String location;
    private double predictedPrice;

    public Crop() {
    }

    public Crop(String name, String season, String location, double predictedPrice) {
        this.name = name;
        this.season = season;
        this.location = location;
        this.predictedPrice = predictedPrice;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPredictedPrice() {
        return predictedPrice;
    }

    public void setPredictedPrice(double predictedPrice) {
        this.predictedPrice = predictedPrice;
    }
}
