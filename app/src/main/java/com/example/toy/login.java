package com.example.toy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity {

    EditText emailR, pwd;
    Button login;
    CardView newacc;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

            emailR = findViewById(R.id.email1);
            login= findViewById(R.id.login);
            pwd = findViewById(R.id.pwd1);
            newacc = findViewById(R.id.newacc);

            mAuth = FirebaseAuth.getInstance();
            database = FirebaseDatabase.getInstance();
            progressDialog = new ProgressDialog(com.example.toy.login.this);
            progressDialog.setTitle("Your Account");
            progressDialog.setMessage("Working...");

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email = emailR.getText().toString();
                    String password = pwd.getText().toString();

                    mAuth = FirebaseAuth.getInstance();
                    progressDialog.show();
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(com.example.toy.login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressDialog.dismiss();
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(com.example.toy.login.this, Home.class);
//                                   intent.putExtra("email",mAuth.getCurrentUser().getEmail());
//                                   intent.putExtra("uid",mAuth.getCurrentUser().getUid());
                                        startActivity(intent);

                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), "Invalid Id/Password", Toast.LENGTH_LONG).show();

                                    }
                                }
                            });
                }

                ;


            });


            newacc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(com.example.toy.login.this, signup.class);
                    startActivity(intent);

                }


            });
    }
}
