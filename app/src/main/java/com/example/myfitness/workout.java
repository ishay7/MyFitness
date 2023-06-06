package com.example.myfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class workout extends AppCompatActivity implements View.OnClickListener {

    Button btn1and4, btn2and5, btn3and6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn1and4 = (Button) findViewById(R.id.btn1and4);
        btn2and5 = (Button) findViewById(R.id.btn2and5);
        btn3and6 = (Button) findViewById(R.id.btn3and6);

        btn1and4.setOnClickListener(this);
        btn2and5.setOnClickListener(this);
        btn3and6.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        if(view == btn1and4)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView4, Fragment1and4.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("name") // Name cant be null
                    .commit();
        }

        else if(view == btn2and5)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView4, Fragment2and5.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("name") // Name cant be null
                    .commit();
        }

        else if(view == btn3and6)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView4, Fragment3and6.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("name") // Name cant be null
                    .commit();
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//כפתור חזור
        int id = item.getItemId();
        if(id == android.R.id.home)
        {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}










