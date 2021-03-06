package com.example.christopher.mobileandubiquitouscomputingcoursework;

//This class contains getters and setters
public class CarParkInfo {

    private int CarParkID;
    private String CarParkName = " ";
    private String Capacity = " ";
    private double Latitude;
    private double Longitude;
    private String Choice;

    public void setCarParkName(String carParkName)
    {
        this.CarParkName = carParkName;
    }
    public String getCarParkName()
    {
        return CarParkName;
    }

    public void setCapacity(String capacity)
    {
        this.Capacity = capacity;
    }

    public String getCapacity()
    {
        return Capacity;
    }

    public void SetChoice( String choice)
    {
        this.Choice = choice;
    }

    public String getChoice()
    {
        return Choice;
    }

    public void setCarParkID(int carParkID)
    {
        this.CarParkID = carParkID;
    }

    public int getCarParkID()
    {
        return CarParkID;
    }

    public void setLongitude(double longitude)
    {
        this.Longitude = longitude;
    }

    public double getLongitude()
    {
        return Longitude;
    }

    public void setLatitude(double latitude)
    {
        this.Latitude = latitude;
    }

    public double getLatitude()
    {
        return Latitude;
    }

    //returns the string value of all the current data stored.
    @Override
    public String toString()
    {
        String carParkData;
        carParkData = "CarParkInfo [CarParkID=" + CarParkID;
        carParkData = ", CarParkName=" + CarParkName;
        carParkData = ", Capacity=" + Capacity;
        carParkData = ", Latitude=" + Latitude;
        carParkData = ", Longitude=" + Longitude +"]";
        return carParkData;
    }

    public CarParkInfo()
    {

    }


}
