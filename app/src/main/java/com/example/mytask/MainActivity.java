package com.example.mytask;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.mytask.databinding.ActivityMainBinding;
import com.example.mytask.databinding.AddArtistLlBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddArtistLlBinding binding1=AddArtistLlBinding.inflate(LayoutInflater.from(MainActivity.this));
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                ab.setView(binding1.getRoot());
                binding1.btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String artistname= binding1.etartistname.getText().toString();
                        String artisttype=binding1.etType.getText().toString();
                        String artistaward=binding1.etAward.getText().toString();

                        Artist artist = new Artist(artistname,artisttype,artistaward);

                        if(ArtistDao.save(MainActivity.this,artist))
                        {
                            Toast.makeText(MainActivity.this, "Successfully save", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Not Save", Toast.LENGTH_SHORT).show();

                        }


                    }
                });
                ab.show();
            }
        });
    }
}