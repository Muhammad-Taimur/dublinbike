//Name : Muhammad Taimur
//Student ID: 15416

//In this activity I assigning the buttons and set the onclick listner on them.

package com.example.android.dublinbikefinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.android.dublinbikefinal.ListItem.URL_DATA;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //As soon my app start this method start fectching the data from server and its more faster
        // for the user to interact with the app.a
        ListItem.getInstance().loadRecyclerViewData(this, new ListItem.ListItemListener() {
            @Override
            public void onComplete() {

            }
        });

//        assign Buttons
        ImageButton btnListVew = (ImageButton) findViewById(R.id.btnListView);
        ImageButton btnMaps = (ImageButton) findViewById(R.id.btnMaps);
        ImageButton btnAbout = (ImageButton) findViewById(R.id.btnAbout);
        ImageView imgbg = (ImageView) findViewById(R.id.imgbg);


//        Button Clicked  for the list view
        btnListVew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //this is calling the ListView activity
                Intent list = new Intent(getApplicationContext(), ListView.class);

                startActivity(list);

            }
        });

//        Button Clicked for the maps

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //this is calling the map activity
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);

                startActivity(intent);

            }
        });


        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //this is calling the About activity
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);

                startActivity(intent);

            }
        });


    }


}
