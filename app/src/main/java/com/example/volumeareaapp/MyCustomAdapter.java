package com.example.volumeareaapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.sql.Array;
import java.util.ArrayList;

// this class is responsible for creating the
// view for each item and binding data to it
public class MyCustomAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapeArrayList;
    Context context;

    public MyCustomAdapter(@NonNull Context context, ArrayList<Shape> shapeArrayList) {
        super(context, R.layout.grid_item_layout, shapeArrayList);
        this.context = context;
        this.shapeArrayList = shapeArrayList;
    }

    //View holder: used for references to the views within an item layout
    // so views dont need to be repeatedly looked up during scrolling i.e using findViewById

    private static class MyViewHolder{
        ImageView shapeImage;
        TextView shapeName;
    }

     //getView(): used to create and get a view for a specific item in a Grid


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // 1- get the shape object ar current position
        Shape shapes = getItem(position);

        // 2 inflaing the layout
        MyViewHolder myViewHolder;


        if(convertView == null){

            // no view went off screen so creating new view
            myViewHolder = new MyViewHolder();

            // Layoutinflater is class which gets the xml layout
            // and convert them into corresponding view objects
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.grid_item_layout,
                    parent,
                    false
            );

            myViewHolder.shapeImage = (ImageView) convertView.findViewById(R.id.imageView);
            myViewHolder.shapeName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(myViewHolder);

        }else{

            // View went off screen recycling it
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        // Setting the data to the model class
        myViewHolder.shapeName.setText(shapes.getShapeName());
        myViewHolder.shapeImage.setImageResource(shapes.getImageShape());

        return convertView;
    }
}
