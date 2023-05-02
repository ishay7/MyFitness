package com.example.myfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button profile;
    Button startWorkout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile = findViewById(R.id.btnMenuProfile);
        startWorkout = findViewById(R.id.btnStartWorkout);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();

        if(id == R.id.itemMenuConnectOrLogin)
        {
            Toast.makeText(this, "you selected connect or login", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.itemMenuBmiCalculator)
        {
            Toast.makeText(this, "you selected BMI calculator", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.itemMenuProteinRemind)
        {
            Toast.makeText(this, "you selected prodein reminder", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}