//Name : Muhammad Taimur
//Student ID: 15416


//In this activity I just define the image view, the image which is using for background.
package com.example.android.dublinbikefinal;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        ImageView imgbg = (ImageView) findViewById(R.id.imgbg);

        //these two line is enabling the back button i get from the website link below
        //https://freakycoder.com/android-notes-24-how-to-add-back-button-at-toolbar-941e6577418e

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

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
