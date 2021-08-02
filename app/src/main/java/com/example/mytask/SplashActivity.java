package com.example.mytask;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytask.databinding.SplashllBinding;

public class SplashActivity  extends AppCompatActivity
{
    SplashllBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=SplashllBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        new MainSplash().start();


    }
    class MainSplash extends Thread
    {
        @Override
        public void run() {
            super.run();

            try {
                Thread.sleep(4000);

                checkEmployeeLogin();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void checkEmployeeLogin() {
        startActivity(new Intent(SplashActivity.this,LoginActivity.class));
        finish();
    }


}
