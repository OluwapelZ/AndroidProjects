package com.example.toyin.rubik_cube;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity {

    private Button play_button, quit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        //Wire widgets to their respective resource.
        play_button = (Button) findViewById(R.id.play_button);
        quit_button = (Button) findViewById(R.id.quit_button);

        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingActivity.this, RubikActivity.class);
                startActivity(intent);
            }
        });

        quit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExitMessage();
            }
        });
    }

    public void showExitMessage(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LandingActivity.this);
        alertDialogBuilder.setTitle("Exit Application");
        alertDialogBuilder.setMessage("Spend a little more time will you")
                .setCancelable(true)
                .setPositiveButton("No, I don't want to", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
//                        LandingActivity.this.finish();
                        System.exit(1);

                    }
                })
                .setNegativeButton("Okay", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).setIcon(android.R.drawable.screen_background_light).show();
    }
}
