package com.example.sharkgym3.views;

import android.os.Bundle;

import com.example.sharkgym3.Interfaces.AboutInterface;
import com.example.sharkgym3.presenters.AboutPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.example.sharkgym3.R;

public class AboutMe extends AppCompatActivity implements AboutInterface.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AboutPresenter presenter = new AboutPresenter(this);

                setContentView(R.layout.activity_about_me);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Asignar la acción necesaria. En este caso "volver atrás"
                onBackPressed();
            }
        });
    }

    @Override
    public void closeAboutActivity() {
        finish();
    }
}