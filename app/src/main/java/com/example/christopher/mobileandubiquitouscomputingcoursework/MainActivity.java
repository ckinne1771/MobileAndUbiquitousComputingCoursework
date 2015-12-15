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
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carParkInfo = new CarParkInfo();
        carParkChoiceSelection = "";
        carParkChoice = (Spinner) findViewById(R.id.CarParkSelector);
        goButton = (Button) findViewById(R.id.goButton);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent carParkDataScreen = new Intent(getApplicationContext(), CarParkDataScreenActivity.class);

                startActivity(carParkDataScreen);
                }

            }
        );

        settingsButton = (Button) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapScreen = new Intent(getApplicationContext(), MapsActivity.class);

                startActivity(mapScreen);
            }
        });
        exitButton = (Button) findViewById(R.id.ExitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        carParkNames = getResources().getStringArray(R.array.car_park_names);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,carParkNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        carParkChoice.setAdapter(dataAdapter);
        carParkChoice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int choice = carParkChoice.getSelectedItemPosition();
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

    @Override
       public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_ToMaps) {
            Intent mapScreen = new Intent(getApplicationContext(), MapsActivity.class);

            startActivity(mapScreen);
        }
        if(id==R.id.action_canvasDraw){
            Intent canvasScreen = new Intent(getApplicationContext(), CanvasActivity.class);

            startActivity(canvasScreen);
        }

        if(id==R.id.action_ToHomeScreen)
        {
            return true;
        }

        if(id==R.id.action_exit) {
            finish();
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }




}
