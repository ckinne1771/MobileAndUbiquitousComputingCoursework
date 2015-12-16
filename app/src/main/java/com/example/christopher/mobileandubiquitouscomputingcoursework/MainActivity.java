package com.example.christopher.mobileandubiquitouscomputingcoursework;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;

import java.io.IOException;


public class MainActivity extends AppCompatActivity{

   public static CarParkInfo carParkInfo;
    TextView text;
    Spinner carParkChoice;
    String[] carParkNames;
    Button goButton;
    Button settingsButton;
    Button exitButton;
    String carParkChoiceSelection;

    //called when the Activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instance of CarParkInfo class. Needed to carry over choice in Spinner
        carParkInfo = new CarParkInfo();
        //set the value of choice selection
        carParkChoiceSelection = "";
        //The Spinner
        carParkChoice = (Spinner) findViewById(R.id.CarParkSelector);
        //Button to go to CarParkDataScreenActivity
        goButton = (Button) findViewById(R.id.goButton);
        //When Button is clicked
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent carParkDataScreen = new Intent(getApplicationContext(), CarParkDataScreenActivity.class);

                startActivity(carParkDataScreen);
                }

            }
        );
        //button to go to maps
        settingsButton = (Button) findViewById(R.id.settingsButton);
        //When button is clicked
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapScreen = new Intent(getApplicationContext(), MapsActivity.class);

                startActivity(mapScreen);
            }
        });
        //Button to exit the program
        exitButton = (Button) findViewById(R.id.ExitButton);
        //When button is clicked
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        //Set the array of car park names equal to an array of pre-defined strings
        carParkNames = getResources().getStringArray(R.array.car_park_names);
        //Array needs adapted to be used in spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,carParkNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attach the adapted array
        carParkChoice.setAdapter(dataAdapter);
        //Handle Option Selection
        carParkChoice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               //get the place in the array selected
                int choice = carParkChoice.getSelectedItemPosition();
                //get the name of the car park selected
                carParkChoiceSelection = carParkNames[choice];
                carParkInfo.SetChoice(carParkNames[choice]);




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Handles Option menu creation and logic
    @Override
       public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //Go to maps
        if (id == R.id.action_ToMaps) {
            Intent theMapScreen = new Intent(getApplicationContext(), MapsActivity.class);

            startActivity(theMapScreen);
        }
        //Go to canvas
        if(id==R.id.action_canvasDraw){
            Intent canvasScreen = new Intent(getApplicationContext(), CanvasActivity.class);

            startActivity(canvasScreen);
        }
        //Go to home screen. Does nothing as we are already there
        if(id==R.id.action_ToHomeScreen)
        {
            return true;
        }

        //exit the application
        if(id==R.id.action_exit) {
            finish();
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }




}
