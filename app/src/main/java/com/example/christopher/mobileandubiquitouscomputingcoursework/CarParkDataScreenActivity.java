package com.example.christopher.mobileandubiquitouscomputingcoursework;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        if (MainActivity.carParkInfo.getChoice().equals("SECC"))
            {
                info = carParkDataBaseStorage.findData(MainActivity.carParkInfo.getChoice());
                name.setText(info.getCarParkName());
                capacity.setText(info.getCapacity());
                occupiedSpaces.setText(AsyncRSSParser.rssData.get(0).getOccupiedSpaces());



        }
    }

}
