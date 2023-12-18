package com.example.myapplication.nintendo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void OnClick(View view)
    {
        ImageView img = (ImageView) view;
        int tag = Integer.parseInt(img.getTag().toString());
        switch (tag) {
            case 1:
                Intent intent1 = new Intent(this, tictactoe.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(this, minesweeper.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(this, chess.class);
                startActivity(intent3);
                break;
            default:
                Toast.makeText(this, "invalid", Toast.LENGTH_SHORT).show();
        }
    }

}