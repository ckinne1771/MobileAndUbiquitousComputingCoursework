package com.example.christopher.mobileandubiquitouscomputingcoursework;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity {

    private GoogleMap mMap;
    List<CarParkInfo>  dataList;
    private Marker[] markerList = new Marker[11];
    private GoogleMap carMap;
    private float markerColours[] = {210.0f, 120.0f, 300.0f, 330.0f, 270.0f, 0.0f, 180.0f, 50.0f, 250.0f, 150.0f, 150.0f};
    private LatLng glasgowCentre = new LatLng(55.861201, -4.250385);

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_view);
        dataList = new ArrayList<CarParkInfo>();
        CarParkDataBaseStorage carDB = new CarParkDataBaseStorage(this,"CarParkDatabase3.s3db", null, 1);
        try {
            carDB.dbCreate();
        }catch(IOException e)
        {
            e.printStackTrace();
        }

        dataList = carDB.findAllData();
        SetUpMap();
        AddMarkers();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    }

    public void SetUpMap()
    {
        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        if(mMap != null)
        {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(glasgowCentre, 12));
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setCompassEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            mMap.getUiSettings().setRotateGesturesEnabled(true);
        }
    }

    public void AddMarkers()
    {
        MarkerOptions marker;
        CarParkInfo carData;
        String markerTitle;
        String markerText;

        for(int i=0; i < dataList.size(); i++)
        {
            carData = dataList.get(i);
            markerTitle = carData.getCarParkName();
            markerText = "Car Park";
            marker = SetMarker(markerTitle, markerText, new LatLng(carData.getLatitude(), carData.getLongitude()), markerColours[i], true);
            markerList[i] = mMap.addMarker(marker);
        }


    }

    public MarkerOptions SetMarker (String title, String snippet, LatLng position, float markercolour, boolean centreAnchor)
    {
        float anchorX;
        float anchorY;

        if(centreAnchor)
        {
            anchorX = 0.5f;
            anchorY = 0.5f;
        }

        else
        {
            anchorX = 0.05f;
            anchorY = 1.0f;
        }

        MarkerOptions marker = new MarkerOptions().title(title).snippet(snippet).icon(BitmapDescriptorFactory.defaultMarker(markercolour)).anchor(anchorX, anchorY).position(position);
   return marker;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
 
}
