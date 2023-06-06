package com.example.myfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class BMICalculator extends AppCompatActivity implements View.OnClickListener {

    Button btnBMISave;
    EditText etWeight, etHeight;
    TextView tvYourBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        etWeight = (EditText) findViewById(R.id.etYourWeight);
        etHeight = (EditText) findViewById(R.id.etYourHeight);
        btnBMISave = (Button) findViewById(R.id.btnBMISave);
        tvYourBmi = (TextView) findViewById(R.id.tvYourBMI);
        btnBMISave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnBMISave)
        {
            if(etHeight.getText().toString().isEmpty() || etWeight.getText().toString().isEmpty())
                Toast.makeText(this, "please fill all the fields", Toast.LENGTH_LONG).show();
            else
            {
                double weight = Double.valueOf(etWeight.getText().toString());
                double height = Double.valueOf(etHeight.getText().toString());

                double bmi = weight/(height*height);
                DecimalFormat decimalFormat = new DecimalFormat("#.#");
                String formattedValue = decimalFormat.format(bmi);

                tvYourBmi.setText("Your BMI is: " + formattedValue);

                boolean isHealthy = false;
                if(bmi >= 18.5 && bmi <= 25)
                    isHealthy = true;


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users/" + FirebaseAuth.getInstance().getUid());
                myRef.child("bmi").setValue(Integer.parseInt(tvYourBmi.getText().toString()));
                myRef.child("isHealthy").setValue(isHealthy);


                //"https://my-fitness-be477-default-rtdb.firebaseio.com/" //<- url of firebase
            }
        }
    }
}