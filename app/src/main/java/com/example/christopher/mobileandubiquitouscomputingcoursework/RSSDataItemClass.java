package com.example.christopher.mobileandubiquitouscomputingcoursework;

/**
 * Created by Christopher on 12/12/2015.
 */

import java.io.Serializable;

public class RSSDataItemClass implements Serializable {
    private String Occupancy;
    private String OccupiedSpaces;
    private String CarParkStatus;

    public String getOccupancy()
    {
        return this.Occupancy;
    }

    public void setOccupancy(String occupancy)
    {
        this.Occupancy = occupancy;
    }

    public String getOccupiedSpaces()
    {
        return this.OccupiedSpaces;
    }

    public void setOccupiedSpaces(String occupiedSpaces)
    {
        this.OccupiedSpaces = occupiedSpaces;
    }
    public String getCarParkStatus()
    {
        return this.CarParkStatus;
    }

    public void setCarParkStatus(String carParkStatus)
    {
        this.CarParkStatus = carParkStatus;
    }

    public RSSDataItemClass()
    {
        this.Occupancy = "";
        this.Occupancy = "";
        this.Occupancy = "";
    }

    @Override
    public String toString() {
        String carParkRSSData;
        carParkRSSData = "RSSDataItem[Occupancy=" + Occupancy;
        carParkRSSData = ", OccupiedSpaces=" + OccupiedSpaces;
        carParkRSSData = ", CarParkStatus=" + CarParkStatus +"]";
        return carParkRSSData;
    }


}
