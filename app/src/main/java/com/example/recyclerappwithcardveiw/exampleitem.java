package com.example.recyclerappwithcardveiw;

public class exampleitem {

    private int mImageresource;
    private String mText;

    public exampleitem(int imageResource,String text){
        mImageresource=imageResource;
        mText=text;

    }

    public int getmImageresource() {
        return mImageresource;
    }

    public String getmText() {
        return mText;
    }
}
