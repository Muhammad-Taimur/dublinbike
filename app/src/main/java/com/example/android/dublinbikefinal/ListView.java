//Name : Muhammad Taimur
//Student ID: 15416

//In this avtivity I'm using recycler View and I'm doign the collowing things.
// 1). Create the 2 varaibles for adapter and recycelr View.
// 2). Inside the Oncreate method calling them assigned the varaible with the ID. (Specifying the variable)
// 3). Setting layout manager with recycler view.
// 4). Getting the adapter
// 5). Set the adapter
// 6). Using the method to bring the back button in the screen


package com.example.android.dublinbikefinal;

import android.content.Intent;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

public class ListView extends AppCompatActivity {

    //Create the varaible

    private RecyclerView recyclerView;
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        //Layoutmanager is using for positiong and measurin the items in recycke View.

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Assigning the apdapter to get the value from.

        adapter = new MyAdapter(ListItem.getInstance().getArrayList(), getApplicationContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //these two line is enabling the back button i get from the website link below
        //https://freakycoder.com/android-notes-24-how-to-add-back-button-at-toolbar-941e6577418e
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.getParentActivityIntent(ListView.this);

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
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}



