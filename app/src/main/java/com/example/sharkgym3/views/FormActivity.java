package com.example.sharkgym3.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sharkgym3.Interfaces.FormInterface;
import com.example.sharkgym3.R;
import com.example.sharkgym3.presenters.FormPresenter;

public class FormActivity extends AppCompatActivity implements FormInterface.View {
    private FormInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        presenter=new FormPresenter(this);

        Button Agregar=findViewById(R.id.Agregar);

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.Start();
            }
        });

    }

    @Override
    public void addPerson() {
        finish();
    }
}