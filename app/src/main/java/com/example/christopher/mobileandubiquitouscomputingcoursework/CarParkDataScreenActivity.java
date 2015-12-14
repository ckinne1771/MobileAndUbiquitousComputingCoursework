package com.example.christopher.mobileandubiquitouscomputingcoursework;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carpark_data_screen);

        CarParkDataBaseStorage carParkDataBaseStorage = new CarParkDataBaseStorage(this, "CarParkDatabase3.s3db", null, 1);
        try {
            carParkDataBaseStorage.dbCreate();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        RSSDataItemClass carParkparsing = new RSSDataItemClass();
        String RSSFeedURL = "https://api.open.glasgow.gov.uk/traffic/carparks";
        AsyncRSSParser rssAsyncParser = new AsyncRSSParser(this, RSSFeedURL);

        try {
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


        name = (TextView)findViewById(R.id.tvName);
        capacity = (TextView)findViewById(R.id.tvCapacity);
        occupiedSpaces = (TextView)findViewById(R.id.tvOccupiedSpaces);
        occupancy = (TextView)findViewById(R.id.tvOccupancy);

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

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_datascreen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
