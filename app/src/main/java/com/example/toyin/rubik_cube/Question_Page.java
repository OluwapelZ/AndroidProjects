package com.example.toyin.rubik_cube;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by Toyin on 18/09/2017.
 */

public class Question_Page extends AppCompatActivity {

    private EditText dimension;
    private int rubik_dimension, total_cublet, inner_cublet;

    @Override
    public void onCreate(Bundle savedInstanceState){
        //Overriding method should call super.onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_resource);

        //Wire widget to their respective resource.
        dimension = (EditText) findViewById(R.id.dimension);

        //Get the number of dimension input
        rubik_dimension = Integer.parseInt(dimension.getText().toString());

        total_cublet = (int) Math.pow(rubik_dimension, 3);
        inner_cublet = (int) Math.pow((rubik_dimension - 2), 3);

        int surface_cublet = total_cublet - inner_cublet;

    }

    public static void rhombic_dimension(int dimen){
        //Put everything required in an array.
        dimen = dimen - 2;

        if(dimen < 2){//base case
        }
        else{
            rhombic_dimension(dimen);//Recursive call
        }

    }


}
