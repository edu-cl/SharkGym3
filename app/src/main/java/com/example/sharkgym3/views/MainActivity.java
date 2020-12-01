package com.example.sharkgym3.views;

import android.content.Intent;
import android.os.Bundle;

import com.example.sharkgym3.Interfaces.MainInterface;
import com.example.sharkgym3.R;
import com.example.sharkgym3.presenters.MainPresenter;
import com.example.sharkgym3.views.FormActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements MainInterface.View {
    private static final String TAG ="";
    private MainInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        presenter=new MainPresenter(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.OnClickAddPerson();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //if(id == R.id.action_search_list){
            //presenter.onClickSearchToolbar();
            //Aqui iria el presentador intenta hacerlo si quieres hacerlo de forma normal con esto
            //Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
            //startActivity(intent);
      // }

        if(id == R.id.Sobre_Nosotros){
            //presenter.onClickAboutToolbar();
            //Aqui iria el presentador intenta hacerlo si quieres hacerlo de forma normal con esto
            Intent intent = new Intent(getApplicationContext(), AboutMe.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void startFormActivity() {
        Intent intent = new Intent(getApplicationContext(), FormActivity.class);
        startActivity(intent);
    }
}