package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.whatsapp.Models.User;

import com.example.whatsapp.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
ActivitySignUpBinding binding;
FirebaseAuth auth;
FirebaseDatabase firebaseDatabase;
ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        auth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        dialog=new ProgressDialog(SignUp.this);
        dialog.setTitle("Loading");
        dialog.setMessage("Creating Your Account");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        binding.create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                auth.createUserWithEmailAndPassword(binding.email.getText().toString(),binding.passWord.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        dialog.dismiss();
                        if (task.isSuccessful()){
                            User user=new User(binding.name.getText().toString(),binding.email.getText().toString(),binding.passWord.getText().toString());
                            String id=task.getResult().getUser().getUid();
                            firebaseDatabase.getReference().child("Users").child(id).setValue(user);
                            Toast.makeText(SignUp.this, "your account is created successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(SignUp.this,MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(SignUp.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this,SignIn.class);
                startActivity(intent);
            }
        });
//        if (auth.getUid()!=null){
//            Intent intent=new Intent(SignUp.this,MainActivity.class);
//            startActivity(intent);
//        }

    }
}