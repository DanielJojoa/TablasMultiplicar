package com.example.daniel.tablasmultiplicar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AcercaDe extends AppCompatActivity {
    public String informacion ;
    public TextView mostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        informacion = "Aplicación de enseñanza a multiplicacion";
        mostrar = (TextView) findViewById(R.id.info);
        mostrar.setText(R.string.acercaDe);

    }
}
