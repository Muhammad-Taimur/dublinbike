//Name : Muhammad Taimur
//Student ID: 15416

//This activity is shows when user click in Map marker or in any list time.

package com.example.android.dublinbikefinal;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

//    Defining all variable
    //Actually this map is using the cardview which I put in top of recycler view.

    public TextView textViewHead;
    public TextView textViewDesc;
    public TextView textViewStatus;
    public TextView textViewLat;
    private TextView bike_stands;
    private TextView available_bikes;

    //assign this for debug the program
    private static final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

//        ImageView iv = (ImageView)findViewById(R.id.myimageview);
//        iv.setImageResource(R.drawable.cycle);


        //these two line is enabling the back button i get from the website link below
        //https://freakycoder.com/android-notes-24-how-to-add-back-button-at-toolbar-941e6577418e

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//getting the extra value  of title which is coming from maps activity when user click on map marker
// its send data to detail activity and show the detail where user is clicked.

        String in = getIntent().getStringExtra("title");

//getting the extra value  of title which is coming from Myadapter class when user click on any item of list
// its send data to detail activity and show the detail where user is clicked.

        String addressGet = getIntent().getStringExtra("Address");

//these 2 line are for testing that data is coming.

        Log.d(TAG, "TEST onCreate: TITLE = " + in);
        Log.d(TAG, "TEST onCreate: Address = " + addressGet);

//        assign the text vied Ids'

        textViewHead = (TextView) findViewById(R.id.textViewHead);
        textViewDesc = (TextView) findViewById(R.id.textViewDesc);
        textViewStatus = (TextView) findViewById(R.id.textViewStatus);
//        textViewLat = (TextView) findViewById(R.id.textViewLat);
        available_bikes = (TextView) findViewById(R.id.textView_available_bikes);
        bike_stands = (TextView) findViewById(R.id.textView_bike_stands);


//        use for loop to show the data and getting the lenth of array the instance of listItem class

        for (int i = 0; i < ListItem.getInstance().getArrayList().size(); i++) {

            //create a list item variable to check which position it is

            ListItem obj = ListItem.getInstance().getArrayList().get(i);

            //assign the position of the address if its equals to the address of user clickes marker
            //it show the list of thta place. And (in) is the value of String which is comoing from Maps activity

            if (obj.getHead().equals(in)) {

//set the text to my id's where use clicks
                textViewHead.setText(obj.getHead());
                textViewDesc.setText(obj.getDesc());
                textViewStatus.setText(obj.getStatus());
//                textViewLat.setText(obj.getLat());
                available_bikes.setText(obj.getAvailable_bikes());
                bike_stands.setText(obj.getBike_stands());

            }

            //this code is doing the same thing as upper code doing but in this code (addressGet) is the
            //value coming from MyAdapter class from the onclick method

            if (obj.getHead().equals(addressGet)) {

//set the text to my id's where use clicks it

                textViewHead.setText(obj.getHead());
                textViewDesc.setText(obj.getDesc());
                textViewStatus.setText(obj.getStatus());
//                textViewLat.setText(obj.getLat());
                available_bikes.setText(obj.getAvailable_bikes());
                bike_stands.setText(obj.getBike_stands());

            }
        }


    }


    //Method to get the back button I geth this code online I attached the link below
    //https://freakycoder.com/android-notes-24-how-to-add-back-button-at-toolbar-941e6577418e

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            NavUtils.getParentActivityIntent(this);
//this is the method calling this method takes user on the back activity
            onBackPressed();

            return true;
        }
        super.onOptionsItemSelected(item);
        return false;
    }

    //This is the onPressed method when button clicked user go to the next activity
    @Override
    public void onBackPressed() {
        //sets the intent where user want to go.
        Intent intent = new Intent(getApplicationContext(), ListView.class);
        startActivity(intent);
    }
}

