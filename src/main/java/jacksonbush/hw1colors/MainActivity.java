package jacksonbush.hw1colors;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

//import java.awt.Color;  // i am really at a loss as to why this doesnt work

public class MainActivity extends AppCompatActivity {

    EditText textInput;
    Button changeColorButton, changeActivityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInput = (EditText) findViewById(R.id.textInput);
        final TextView colorInfo = (TextView) findViewById(R.id.textColorInfo);

        changeColorButton = (Button) findViewById(R.id.changeColorButton);
        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = 0xFF000000 | new Random().nextInt(0xFFFFFF);
                textInput.setTextColor(color);

                int r = (color & 0xFF0000) >> 16;
                int g = (color & 0xFF00) >> 8;
                int b = (color & 0xFF);

                color = (int) Long.parseLong(Integer.toString(color), 16);
                String hex = Integer.toHexString(color);
                String s = "Color: " + r + "r " + g + "g " + b + "b " + "#" + hex;
                colorInfo.setText(s);
            }
        });

        changeActivityButton = (Button) findViewById(R.id.changeActivityButton);
        changeActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityDrawing.class));
            }
        });
    }
}