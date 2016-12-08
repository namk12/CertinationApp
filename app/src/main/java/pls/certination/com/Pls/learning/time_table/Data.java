package pls.certination.com.Pls.learning.time_table;

import java.util.ArrayList;

import pls.certination.com.certination.R;


public class Data {


    public static ArrayList<Information> getData() {

        ArrayList<Information> data = new ArrayList<>();

        int[] images = {
                R.drawable.google,
                R.drawable.intel,
                R.drawable.micro,
                R.drawable.apple,
                R.drawable.adobe,
                R.drawable.red,
                R.drawable.vm,
                R.drawable.hp
        };

        String[] Categories = {"GOOGLE","INTEL","MICROSOFT","APPLE","ADOBE","REDHAT","vmware","HP"
                              };
        for (int i = 0; i < images.length; i++) {

            Information current = new Information();
            current.title = Categories[i];
            current.imageId = images[i];

            data.add(current);
        }

        return data;
    }

}
