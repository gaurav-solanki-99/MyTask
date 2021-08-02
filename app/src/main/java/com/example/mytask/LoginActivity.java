package com.example.mytask;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytask.databinding.LoginLayoutBinding;

public class LoginActivity extends AppCompatActivity
{

    LoginLayoutBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=LoginLayoutBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUsertoRegisterActivity();
            }
        });


        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.etEmail.getText().toString();
                String password=binding.etPassword.getText().toString();
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);
                System.out.println("Button clic"+email+password);

                if(UserDao.authenticateUser(LoginActivity.this,user))
                {
                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    sendUserToMainActivity(user);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Please Check Email and Password ", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void sendUserToMainActivity(User user) {

        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        intent.putExtra("User",user);
        startActivity(intent);
    }

    private void sendUsertoRegisterActivity()
    {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        finish();
    }
}
