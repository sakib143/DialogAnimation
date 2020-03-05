package com.example.dialoganimation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowDialog = findViewById(R.id.btn_show_dialog);
        Button btnShowDialog2 = findViewById(R.id.btn_show_dialog_2);
        Button btnShowDialog3 = findViewById(R.id.btn_show_dialog_3);
        Button btnShowDialog4 = findViewById(R.id.btn_show_dialog_4);

        btnShowDialog.setOnClickListener(onClickListener(1));
        btnShowDialog2.setOnClickListener(onClickListener(2));
        btnShowDialog3.setOnClickListener(onClickListener(3));
        btnShowDialog4.setOnClickListener(onClickListener(4));
    }

    private View.OnClickListener onClickListener(final int style) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    switch (style){
                        case 1:
                            buildDialog(R.style.DialogThemeLeftRight, "Left - Right Animation!");
                            break;
                        case 2:
                            buildDialog(R.style.DialogAnimationUpDown, "Up - Down Animation!");
                            break;
                        case 3:
                            buildDialog(R.style.DialogFadEffect, "Fade In - Fade Out Animation!");
                            break;
                        case 4:
                            buildDialog(R.style.DialogZoomEffect, "In -  Out Animation!");
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
    private void buildDialog(int animationSource, String type) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Animation Dialog");
        builder.setMessage(type);
        builder.setNegativeButton("OK", null);
        builder.setPositiveButton("yes",null);
        AlertDialog dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = animationSource;
        dialog.show();
    }
}
