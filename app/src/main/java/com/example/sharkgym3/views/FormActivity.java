package com.example.sharkgym3.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.sharkgym3.Interfaces.FormInterface;
import com.example.sharkgym3.Models.PersonEntity;
import com.example.sharkgym3.R;
import com.example.sharkgym3.presenters.FormPresenter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Calendar;

public class FormActivity extends AppCompatActivity implements FormInterface.View {
    Context myContext;
    Button buttonDate;
    Calendar calendar;
    DatePickerDialog datePickerDialog;
    int Year, Month, Day;
    private FormInterface.Presenter presenter;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private Button button;
    private Button button2;
    PersonEntity person;
    private TextInputLayout DNILayout;
    private TextInputEditText DNI0EditText;
    private TextInputLayout NameLayout;
    private TextInputEditText NameditText;
    private TextInputLayout SurnameLayout;
    private TextInputEditText SurnameeditText;
    private TextInputLayout ProblemLayout;
    private TextInputEditText ProblemeditText;
    private TextInputLayout DateLayout;
    private TextInputEditText editTextDate;
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        presenter = new FormPresenter(this);

        myContext=this;

        DNI0EditText = findViewById(R.id.dniTE);
        DNILayout = findViewById(R.id.textInputLayout7);
        NameLayout = (TextInputLayout) findViewById(R.id.Name_layout);
        NameditText = (TextInputEditText) findViewById(R.id.Name_TE);
        SurnameLayout = (TextInputLayout) findViewById(R.id.Surname_layout);
        SurnameeditText = (TextInputEditText) findViewById(R.id.Surname_TE);
        ProblemLayout = (TextInputLayout) findViewById(R.id.Problem_layout);
        ProblemeditText = (TextInputEditText) findViewById(R.id.Problem_TE);
        DateLayout = (TextInputLayout) findViewById(R.id.date_layout);
        editTextDate = (TextInputEditText) findViewById(R.id.FechaTE);
        Button Agregar = findViewById(R.id.Agregar);
        Button Eliminar = findViewById(R.id.delete);


        person =new PersonEntity();
        NameditText.setOnFocusChangeListener((new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {

                    if (NameditText.getText().toString().matches("")) {
                        NameLayout.setError(presenter.getError("Valid"));
                    } else if (!(person.setName(NameditText.getText().toString()))) {
                        NameLayout.setError(presenter.getError("NameError"));
                    } else {
                        NameLayout.setError(presenter.getError("Valid"));
                    }
                }
            }
        }));

        SurnameeditText.setOnFocusChangeListener(((view, hasFocus) -> {
            if (!hasFocus) {

                if (SurnameeditText.getText().toString().matches("")) {
                    SurnameLayout.setError(presenter.getError("Valid"));
                } else if (!(person.setSurname(SurnameeditText.getText().toString()))) {
                    SurnameLayout.setError(presenter.getError("SurnameError"));
                } else {
                    SurnameLayout.setError(presenter.getError("Valid"));
                }
            }
        }));
        DNI0EditText.setOnFocusChangeListener(((view, hasFocus) -> {
            if (!hasFocus) {

                if (DNI0EditText.getText().toString().matches("")) {
                    DateLayout.setError(presenter.getError("Valid"));
                } else if (!(person.setDNI(DNI0EditText.getText().toString()))) {
                    DateLayout.setError(presenter.getError("DNIError"));
                } else {
                    DateLayout.setError(presenter.getError("Valid"));
                }
            }
        }));
        editTextDate.setOnFocusChangeListener(((view, hasFocus) -> {
            if (!hasFocus) {

                if (editTextDate.getText().toString().matches("")) {
                    DateLayout.setError(presenter.getError("Valid"));
                } else if (!(person.setFecha(editTextDate.getText().toString()))) {
                    DateLayout.setError(presenter.getError("DateError"));
                } else {
                    DateLayout.setError(presenter.getError("Valid"));
                }
            }
        }));

        myContext = this;

        ArrayList<String> items = new ArrayList<String>();
        items.add("Hombre");
        items.add("Mujer");

        // Definición del Adaptador que contiene la lista de opciones
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        // Definición del Spinner
        spinner = (Spinner) findViewById(R.id.spinner2);
        spinner.setAdapter(adapter);

        // Definición de la acción del botón
        button = (Button) findViewById(R.id.anadirCategoria);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Recuperación de la vista del AlertDialog a partir del layout de la Actividad
                LayoutInflater layoutActivity = LayoutInflater.from(myContext);
                View viewAlertDialog = layoutActivity.inflate(R.layout.alert_dialog, null);

                // Definición del AlertDialog
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(myContext);

                // Asignación del AlertDialog a su vista
                alertDialog.setView(viewAlertDialog);

                // Recuperación del EditText del AlertDialog
                final EditText dialogInput = (EditText) viewAlertDialog.findViewById(R.id.dialogInput);

                // Configuración del AlertDialog
                alertDialog
                        .setCancelable(false)
                        // Botón Añadir
                        .setPositiveButton(getResources().getString(R.string.Add),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        adapter.add(dialogInput.getText().toString());
                                        spinner.setSelection(adapter.getPosition(dialogInput.getText().toString()));
                                    }
                                })
                        // Botón Cancelar
                        .setNegativeButton(getResources().getString(R.string.Cancel),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                })
                        .create()
                        .show();
            }
        });

        myContext = this;

        // Obtener la fecha actual
        calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);


        // Definir la acción del botón para abrir el calendario
        buttonDate = findViewById(R.id.Calendarioo);
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Definir el calendario con la fecha seleccionada por defecto
                datePickerDialog = new DatePickerDialog(myContext, new DatePickerDialog.OnDateSetListener() {
                    // Definir la acción al pulsar OK en el calendario
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        // Asignar la fecha a un campo de texto
                        editTextDate.setText(String.valueOf(day) + "/" + String.valueOf(month + 1) + "/" + String.valueOf(year));
                    }
                }, Year, Month, Day);
                // Mostrar el calendario
                datePickerDialog.show();
            }

        });

        id = getIntent().getStringExtra("id");
        System.out.println(id);
        if (id != null) {
            DNI0EditText.setText(id);
        } else {
            Eliminar.setEnabled(false);
        }

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonEntity p = new PersonEntity();
                if (!p.setName(NameditText.getText().toString())) {
                    NameLayout.setError(presenter.getError("NameError"));
                } else if (!p.setSurname(SurnameeditText.getText().toString())) {
                    SurnameLayout.setError(presenter.getError("SurnameError"));
                } else if (!p.setDNI(DNI0EditText.getText().toString())) {
                    DNILayout.setError(presenter.getError("DNIError"));
                } else if (!p.setFecha(editTextDate.getText().toString())) {
                    DateLayout.setError((presenter.getError("DateError")));
                } else {
                    presenter.Start();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_form, menu);
        return true;
    }


    @Override
    public void addPerson() {
        finish();
    }
}