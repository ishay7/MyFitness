package com.example.myfitness;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AfterLogin extends AppCompatActivity {

    TextView tvBmi, tvIsHealthy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        tvBmi = findViewById(R.id.tvAfterLoginBMI);
        tvIsHealthy = findViewById(R.id.tvAfterLoginHealth);


        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("users/" + FirebaseAuth.getInstance().getUid());






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


        if(id == R.id.itemMenuBmiCalculator)
        {
            startActivity(new Intent(AfterLogin.this, BMICalculator.class));
        }
        else if(id == R.id.itemMenuProteinRemind)
        {
            startActivity(new Intent(AfterLogin.this, proteinAlarm.class));
        }
        else if (id == R.id.itemMenuWorkout)
        {
            startActivity(new Intent(AfterLogin.this, workout.class));

        } else if (id == R.id.logout)
        {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(AfterLogin.this, MainActivity.class));
            finish();
        }

        return true;
    }
}