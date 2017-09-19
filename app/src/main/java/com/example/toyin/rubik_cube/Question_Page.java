package com.example.toyin.rubik_cube;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by Toyin on 18/09/2017.
 */

public class Question_Page extends AppCompatActivity {

    private EditText dimension;
    private int rubik_dimension, total_cublet, inner_cublet, inner_dimension;

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

        int surface_cubes = total_cublet - inner_cublet;

        //Get the recursive call on the inner dimension that can be gotten.
        inner_dimension = rubik_dimension(rubik_dimension);

        showParameterMessage(rubik_dimension, total_cublet, inner_cublet, surface_cubes, inner_dimension);


    }

    //Recursive call on the rubik's cube
    public static int rubik_dimension(int dimen){
        //Put everything required in an array.
        dimen = dimen - 2;

        if(dimen < 2){//base case
        }
        else{
            rubik_dimension(dimen);//Recursive call
        }

        return dimen;
    }

    public void showParameterMessage(int dimension, int total, int inner, int surface, int inner_dimension){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Question_Page.this);
        alertDialogBuilder.setTitle("Rubik cube with dimension " + dimension + ".");
        alertDialogBuilder.setMessage("The total cublet of the Rubik's cube is: " + total + "\n The total number of inner cubes is: " +
        inner + "\n The total number of cubes on the surface of the Rubik's cube is: " + surface + "\n. The inner dimension that can be gotten from the rubik's cube is: " +
         inner_dimension + ".")
                .setCancelable(true)
                .setPositiveButton("Play again", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Question_Page.this, Question_Page.class);
                        startActivity(intent);

                    }
                })
                .setNegativeButton("Menu", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Question_Page.this, Landing_Page.class);
                        startActivity(intent);
                    }
                }).setIcon(android.R.drawable.ic_dialog_alert).show();
    }


}
