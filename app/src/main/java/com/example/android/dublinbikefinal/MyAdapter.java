//Name : Muhammad Taimur
//Student ID: 15416

//This is the adapter class which extends the recycler View. In this activity i do the following things.
// 1). assing the variable for lisitem and context anc create the constructor for my Adapter
// 2). In onCreate method Using the layout inflator to get the xml layouts.
// 3). In OnbindViewHolder setting our textview's in holder to show the data.
// 4). Create onClick listner in each listItem and passign the value of Intent
// 5). Item count method will go to the size of list and repeating the data till the list Item finish.
// 6). In public class of view holder which extends the holder class. I assign the varible which are the id's
// in out xml file.


//LayoutInflater is used to manipulate Android screen using predefined XML layouts.
// This class is used to instantiate layout XML file into its corresponding View objects
package com.example.android.dublinbikefinal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Taimur on 04/03/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//to fetch the layout
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//keep repeatign the layout
        View rootView = inflater.inflate(R.layout.list_item, parent, false);


        //Have to create a new list_item xml file to link this list item whichi s red.


        return new ViewHolder(rootView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final ListItem listItem = listItems.get(position);

        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDesc.setText(listItem.getDesc());
        holder.textViewStatus.setText(listItem.getStatus());
//        holder.textViewLat.setText(listItem.getLat());
//        holder.textViewLat.setText(listItem.getLng());
        holder.textView_bike_stands.setText(listItem.getBike_stands());
        holder.textView_available_bikes.setText(listItem.getAvailable_bikes());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You Clicked " + listItem.getHead(), Toast.LENGTH_LONG).show();


                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Address", listItem.getHead());

                //I put the context here because its dont know where we trying to start the activity from because
                // we are inside the Recycler View adapter

                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView textViewStatus;
        //        public TextView textViewLat;
        public TextView textView_available_bikes;
        public TextView textView_bike_stands;


        public LinearLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);


            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            textViewStatus = (TextView) itemView.findViewById(R.id.textViewStatus);
//            textViewLat = (TextView) itemView.findViewById(R.id.textViewLat);
            textView_bike_stands = (TextView) itemView.findViewById(R.id.textView_bike_stands);
            textView_available_bikes = (TextView) itemView.findViewById(R.id.textView_available_bikes);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);


        }
    }

}
