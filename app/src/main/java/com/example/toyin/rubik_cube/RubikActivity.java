package com.example.toyin.rubik_cube;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.IllegalFormatException;

/**
 * Created by Toyin on 18/09/2017.
 */

public class RubikActivity extends AppCompatActivity {

    public EditText dimension;
    public BigInteger rubik_dimen;
    public int total_cublet, inner_cublet, surface_cubes;
    public Button surface, total, inner, hidden_rubik, menu;
    public int i;

    //Recursive call on the rubik's cube

    ArrayList<Integer> rubik_inner_dimension = new ArrayList<>();
    public ArrayList<Integer> peelOff(int dimen){
        dimen = dimen - 2;

        if(dimen < 2){//base case
        }
        else{
            rubik_inner_dimension.add(dimen);
            peelOff(dimen);//Recursive call
        }

        return rubik_inner_dimension;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_resource);

        //Wire widget to their respective resource.
        dimension = (EditText) findViewById(R.id.dimension);
        surface = (Button) findViewById(R.id.surface);
        total = (Button) findViewById(R.id.total);
        inner = (Button) findViewById(R.id.inner_cublet);
        hidden_rubik = (Button) findViewById(R.id.inner_dimension);
        menu = (Button) findViewById(R.id.menu);

        //Set a listener for all the buttons
        surface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BigInteger rubik_dimen = new BigInteger(dimension.getText().toString());
                    total_cublet = (int) Math.pow(rubik_dimen.intValue(), 3);
                    inner_cublet = (int) Math.pow((rubik_dimen.intValue() - 2), 3);
                    surface_cubes = total_cublet - inner_cublet;
                }
                catch (NullPointerException e){
                    Toast.makeText(getApplicationContext(), "You need to enter a number before you can make a click.", Toast.LENGTH_SHORT).show();
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "You need to enter a number before you can make a click.", Toast.LENGTH_SHORT).show();
                }
                catch (IllegalFormatException e){
                    Toast.makeText(getApplicationContext(), "Your input must be a number.", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), "There are " + surface_cubes + " cublets on the surface of the Rubik's cube.", Toast.LENGTH_LONG).show();
            }
        });

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BigInteger rubik_dimen = new BigInteger(dimension.getText().toString());
                    total_cublet = (int) Math.pow(rubik_dimen.intValue(), 3);
                    Toast.makeText(getApplicationContext(), "There are " + total_cublet + " cublets in total in the " + rubik_dimen + " dimension Rubik's cube.", Toast.LENGTH_LONG).show();
                }
                catch (NullPointerException e){
                    Toast.makeText(getApplicationContext(), "You need to enter a number before you can make a click.", Toast.LENGTH_SHORT).show();
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "You need to enter a number before you can make a click.", Toast.LENGTH_SHORT).show();
                }
                catch (IllegalFormatException e){
                    Toast.makeText(getApplicationContext(), "Your input must be a number.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        inner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BigInteger rubik_dimen = new BigInteger(dimension.getText().toString());
                    inner_cublet = (int) Math.pow((rubik_dimen.intValue() - 2), 3);
                }
                catch (NullPointerException e){
                    Toast.makeText(getApplicationContext(), "You need to enter a number before you can make a click.", Toast.LENGTH_SHORT).show();
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "You need to enter a number before you can make a click.", Toast.LENGTH_SHORT).show();
                }
                catch (IllegalFormatException e){
                    Toast.makeText(getApplicationContext(), "Your input must be a number.", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), "There are " + inner_cublet + " hidden cublets.", Toast.LENGTH_LONG).show();
            }
        });

        //The numbers in the hidden_rubik ArrayList.
            hidden_rubik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ArrayList<Integer> hidden_rubiks;
                        try {
                            BigInteger rubik_dimen = new BigInteger(dimension.getText().toString());
                            hidden_rubiks = peelOff(rubik_dimen.intValue());
                            for(i = 0; i < hidden_rubiks.size(); i++) {
                                Toast.makeText(getApplicationContext(), "A rubik cube of dimension: " + hidden_rubiks.get(i) + " is hidden", Toast.LENGTH_LONG).show();
                            }
                        } catch (NullPointerException e) {
                            Toast.makeText(getApplicationContext(), "You need to enter a number before you can make a click.", Toast.LENGTH_SHORT).show();
                        } catch (NumberFormatException e) {
                            Toast.makeText(getApplicationContext(), "You need to enter a number before you can make a click.", Toast.LENGTH_SHORT).show();
                        } catch (IllegalFormatException e) {
                            Toast.makeText(getApplicationContext(), "Your input must be a number.", Toast.LENGTH_SHORT).show();
                        }


                }
            });

        //Click the menu button to return to the menu page.
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RubikActivity.this, LandingActivity.class);
                startActivity(intent);
            }
        });
    }

}
