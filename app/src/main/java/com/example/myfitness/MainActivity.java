package com.example.myfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etPassword, etEmail;
    Button btnLogin, btnRegister;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null)
            startActivity(new Intent(MainActivity.this, AfterLogin.class));
    }

    @Override
    public void onClick(View v) {
        if (v == btnLogin) {
            if (etEmail.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty())
                Toast.makeText(this, "Error, please write email and password", Toast.LENGTH_LONG).show();
            else {
                mAuth.signInWithEmailAndPassword(etEmail.getText().toString(), etPassword.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                    startActivity(new Intent(MainActivity.this, AfterLogin.class));
                                else
                                    Toast.makeText(MainActivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            }
        } else if (v == btnRegister) {
            if (etEmail.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty())
                Toast.makeText(this, "Error, please write email and password", Toast.LENGTH_LONG).show();
            else {
                mAuth.createUserWithEmailAndPassword(etEmail.getText().toString(), etPassword.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                    startActivity(new Intent(MainActivity.this, AfterLogin.class));
                                else
                                    Toast.makeText(MainActivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            }
        }
    }

}