package com.example.christopher.mobileandubiquitouscomputingcoursework;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import java.util.concurrent.ExecutionException;


/**
 * Created by Christopher on 27/11/2015.
 */
public class CarParkDataScreenActivity extends AppCompatActivity {

    TextView name;
    TextView capacity;
    TextView occupiedSpaces;
    TextView occupancy;

    CarParkInfo info = new CarParkInfo();

//on activity creation
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carpark_data_screen);
//Attempts to create a database.
        CarParkDataBaseStorage carParkDataBaseStorage = new CarParkDataBaseStorage(this, "CarParkDatabase3.s3db", null, 1);
        try {
            carParkDataBaseStorage.dbCreate();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //sets up object to store parsed data
        RSSDataItemClass carParkparsing = new RSSDataItemClass();
        //The URL to parse from
        String RSSFeedURL = "https://api.open.glasgow.gov.uk/traffic/carparks";
        //Create the means to parse data
        AsyncRSSParser rssAsyncParser = new AsyncRSSParser(this, RSSFeedURL);

        try {
            //execute parsing
            carParkparsing = rssAsyncParser.execute("").get();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }


        //set up the text views.
        name = (TextView)findViewById(R.id.tvName);
        capacity = (TextView)findViewById(R.id.tvCapacity);
        occupiedSpaces = (TextView)findViewById(R.id.tvOccupiedSpaces);
        occupancy = (TextView)findViewById(R.id.tvOccupancy);

        //The following if statements change the values of the Textvies to specific read or parsed
        //data. The static information is read from the created database. The dynamic data is read
        //from the stored parsed data.
        if (MainActivity.carParkInfo.getChoice().equals("SECC"))
            {
                info = carParkDataBaseStorage.findData(MainActivity.carParkInfo.getChoice());
                name.setText("Name of Car Park: " + info.getCarParkName());
                capacity.setText("Capacity: " +info.getCapacity());
                occupiedSpaces.setText("Occupied Spaces: " + AsyncRSSParser.rssData.get(0).getOccupiedSpaces());
                occupancy.setText("Percentage Occupied: " + AsyncRSSParser.rssData.get(0).getOccupancy() + "%");




        }
        if (MainActivity.carParkInfo.getChoice().equals("Duke Street"))
        {
            info = carParkDataBaseStorage.findData(MainActivity.carParkInfo.getChoice());
            name.setText("Name of Car Park: " +info.getCarParkName());
            capacity.setText("Capacity: " + info.getCapacity());
            occupiedSpaces.setText("Occupied Spaces: " + AsyncRSSParser.rssData.get(1).getOccupiedSpaces());
            occupancy.setText("Percentage Occupied: " + AsyncRSSParser.rssData.get(1).getOccupancy() + "%");



        }
        if (MainActivity.carParkInfo.getChoice().equals("Dundasvale 2"))
        {
            info = carParkDataBaseStorage.findData(MainActivity.carParkInfo.getChoice());
            name.setText("Name of Car Park: " +info.getCarParkName());
            capacity.setText("Capacity: " + info.getCapacity());
            occupiedSpaces.setText("Occupied Spaces: " + AsyncRSSParser.rssData.get(2).getOccupiedSpaces());
            occupancy.setText("Percentage Occupied: " + AsyncRSSParser.rssData.get(2).getOccupancy() + "%");




        }

        if (MainActivity.carParkInfo.getChoice().equals("Charing Cross"))
        {
            info = carParkDataBaseStorage.findData(MainActivity.carParkInfo.getChoice());
            name.setText("Name of Car Park: " +info.getCarParkName());
            capacity.setText("Capacity: " + info.getCapacity());
            occupiedSpaces.setText("Occupied Spaces: " + AsyncRSSParser.rssData.get(3).getOccupiedSpaces());
            occupancy.setText("Percentage Occupied: " + AsyncRSSParser.rssData.get(3).getOccupancy() + "%");




        }
        if (MainActivity.carParkInfo.getChoice().equals("Cadogan Square"))
        {
            info = carParkDataBaseStorage.findData(MainActivity.carParkInfo.getChoice());
            name.setText("Name of Car Park: " +info.getCarParkName());
            capacity.setText("Capacity: " + info.getCapacity());
            occupiedSpaces.setText("Occupied Spaces: " + AsyncRSSParser.rssData.get(4).getOccupiedSpaces());
            occupancy.setText("Percentage Occupied: " + AsyncRSSParser.rssData.get(4).getOccupancy() + "%");




        }
        if (MainActivity.carParkInfo.getChoice().equals("Shields Road"))
        {
            info = carParkDataBaseStorage.findData(MainActivity.carParkInfo.getChoice());
            name.setText("Name of Car Park: " +info.getCarParkName());
            capacity.setText("Capacity: " + info.getCapacity());
            occupiedSpaces.setText("Occupied Spaces: " + AsyncRSSParser.rssData.get(5).getOccupiedSpaces());
            occupancy.setText("Percentage Occupied: " + AsyncRSSParser.rssData.get(5).getOccupancy() + "%");




        }
        if (MainActivity.carParkInfo.getChoice().equals("Buchanan Galleries"))
        {
            info = carParkDataBaseStorage.findData(MainActivity.carParkInfo.getChoice());
            name.setText("Name of Car Park: " +info.getCarParkName());
            capacity.setText("Capacity: " + info.getCapacity());
            occupiedSpaces.setText("Occupied Spaces: " + AsyncRSSParser.rssData.get(6).getOccupiedSpaces());
            occupancy.setText("Percentage Occupied: " + AsyncRSSParser.rssData.get(6).getOccupancy() + "%");



        }
        if (MainActivity.carParkInfo.getChoice().equals("Cambridge Street"))
        {
            info = carParkDataBaseStorage.findData(MainActivity.carParkInfo.getChoice());
            name.setText("Name of Car Park: " +info.getCarParkName());
            capacity.setText("Capacity: " + info.getCapacity());
            occupiedSpaces.setText("Occupied Spaces: " + AsyncRSSParser.rssData.get(7).getOccupiedSpaces());
            occupancy.setText("Percentage Occupied: " + AsyncRSSParser.rssData.get(7).getOccupancy() + "%");




        }
        if (MainActivity.carParkInfo.getChoice().equals("Concert Square"))
        {
            info = carParkDataBaseStorage.findData(MainActivity.carParkInfo.getChoice());
            name.setText("Name of Car Park: " +info.getCarParkName());
            capacity.setText("Capacity: " + info.getCapacity());
            occupiedSpaces.setText("Occupied Spaces: " + AsyncRSSParser.rssData.get(8).getOccupiedSpaces());
            occupancy.setText("Percentage Occupied: " + AsyncRSSParser.rssData.get(8).getOccupancy() + "%");




        }
        if (MainActivity.carParkInfo.getChoice().equals("Dundasvale 1"))
        {
            info = carParkDataBaseStorage.findData(MainActivity.carParkInfo.getChoice());
            name.setText("Name of Car Park: " +info.getCarParkName());
            capacity.setText("Capacity: " + info.getCapacity());
            occupiedSpaces.setText("Occupied Spaces: " + AsyncRSSParser.rssData.get(9).getOccupiedSpaces());
            occupancy.setText("Percentage Occupied: " + AsyncRSSParser.rssData.get(9).getOccupancy() + "%");




        }
        if (MainActivity.carParkInfo.getChoice().equals("High Street"))
        {
            info = carParkDataBaseStorage.findData(MainActivity.carParkInfo.getChoice());
            name.setText("Name of Car Park: " +info.getCarParkName());
            capacity.setText("Capacity: " + info.getCapacity());
            occupiedSpaces.setText("Occupied Spaces: " + AsyncRSSParser.rssData.get(10).getOccupiedSpaces());
            occupancy.setText("Percentage Occupied: " + AsyncRSSParser.rssData.get(10).getOccupancy() + "%");



        }

    }


    //handles option creation and logic


   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_datascreen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //Go to Maps
        if (id == R.id.action_ToMaps) {
            Intent mapScreen = new Intent(getApplicationContext(), MapsActivity.class);

            startActivity(mapScreen);
            finish();
        }
        //Got to Canvas
        if(id==R.id.action_canvasDraw){
            Intent canvas = new  Intent(getApplicationContext(), CanvasActivity.class);
            startActivity(canvas);
            finish();
        }

        //Go to Home Screen
        if(id==R.id.action_ToHomeScreen)
        {
            Intent mainScreen = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainScreen);
            finish();
        }

        //Exit Application
        if(id==R.id.action_exit) {
            finish();
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }








}
