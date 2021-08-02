package com.example.mytask;

import android.app.DatePickerDialog;
import android.content.Intent;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytask.databinding.RegisterLayoutBinding;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity
{

    RegisterLayoutBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=RegisterLayoutBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUserToLoginActivity();
            }
        });


        binding.etDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Calendar calendar = Calendar.getInstance();
                DatePickerDialog dp = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String ejoindate = dayOfMonth+"-"+(month+1)+"-"+year;
                        binding.etDob.setText(ejoindate);
                    }
                }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                dp.show();
            }
        });


        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname=binding.etFirstName.getText().toString();
                String secondname=binding.etLastName.getText().toString();
                String email=binding.etEmail.getText().toString();
                String dob=binding.etDob.getText().toString();
                String password=binding.etPassword.getText().toString();

                User user = new User(firstname,secondname,email,password,dob);

                if(UserDao.saveUser(RegisterActivity.this,user))
                {


                    Toast.makeText(RegisterActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Data Not  Inserted Successfully", Toast.LENGTH_SHORT).show();

                }







            }
        });
    }

    private void sendUserToLoginActivity()
    {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
        finish();
    }
}
