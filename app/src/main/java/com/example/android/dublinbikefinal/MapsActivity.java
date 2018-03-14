//Name : Muhammad Taimur
//Student ID: 15416

//This is the Map activity in this activity doing the following things.
// 1). Creating a for loop to get the latitude and longitude.
// 2). Parsing the latitude and longitude in to Double. as GOOOGLE lat lng using double value.
// 3). Making the market on the location by getting the data from APi.
// 4). Move camer on the marker when clicked and make them zoom about 14.
// 5). Using the method to set the click listner in the marker.
// 6). Creating the new activity and forwarding the value of title
// 7). Starting the activity.

package com.example.android.dublinbikefinal;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker marker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        //using for loop to get the data from the array list which is in the ListItem java class.
        for (int i = 0; i < ListItem.getInstance().getArrayList().size(); i++) {


//            Parsing the fetced lat lng in double because they are in String and google Map is taking the lat lng in
//            Double
            double lat = Double.parseDouble(ListItem.getInstance().getArrayList().get(i).getLat());
            double lng = Double.parseDouble(ListItem.getInstance().getArrayList().get(i).getLng());

//          Getting the address from the json and stored them in String
            String title = ListItem.getInstance().getArrayList().get(i).getHead();

//            Adding marker in different place with lat lng double implementing in the lat lng value
            marker = mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title(title).icon(BitmapDescriptorFactory.fromResource((R.drawable.unnamed))));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 14));
        }


        //This is on click marker method using this method to click the marker and going to the next actity
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {


//      This is the onClick listner show the new activity when user click on the markers in Google Maps
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("title", marker.getTitle());
                startActivity(intent);
            }
        });

    }


}
