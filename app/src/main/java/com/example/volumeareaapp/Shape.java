package com.example.volumeareaapp;


// This class is acting like "Model Class"
// it represents the data Structure or individual data items
// that adapter is going to display
public class Shape {

    int imageShape;
    String shapeName;

    public Shape(int imageShape, String shapeName){
        this.imageShape = imageShape;
        this.shapeName = shapeName;
    }

    //Getters
    public int getImageShape(){
        return imageShape;
    }
    public String getShapeName(){
        return shapeName;
    }

    //setters
    public void setImageShape(int imageShape){
        this.imageShape = imageShape;
    }
    public void setShapeName(String shapeName){
        this.shapeName = shapeName;
    }
}
