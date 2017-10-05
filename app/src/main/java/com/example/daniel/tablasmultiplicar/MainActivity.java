package com.example.daniel.tablasmultiplicar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.random;

public class MainActivity extends AppCompatActivity {
    public int a,b,aciertos;
    public TextView ver_op;
    public EditText respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.aciertos =0;
        ver_op = (TextView) findViewById(R.id.ver_op);
        respuesta = (EditText) findViewById(R.id.respuesta);
        crear_ejercicio();
    }

    public void crear_ejercicio(){
       this.a = (int) (Math.random()*12+1);
        this.b = (int) (Math.random()*12+1);

        this.ver_op.setText(getResources().getString(R.string.multiplicar)+String.valueOf(a)+" X "+String.valueOf(b)+"\n"+getResources().getString(R.string.aciertos)+String.valueOf(aciertos));

    }

    public void  verificar (View v){
        try{
            int resultado = a*b;
            int rta = Integer.valueOf(respuesta.getText().toString());
            if(resultado == rta ){
                aciertos +=1;
                if(aciertos <5 ){
                    this.crear_ejercicio();
                    Toast toast = Toast.makeText(this,R.string.acierto,Toast.LENGTH_LONG);
                    respuesta.setText("");
                    toast.show();
                }
                else{
                    ver_op.setText(R.string.fin);
                }

            }
            else{
            crear_ejercicio();

                Toast toast = Toast.makeText(this,getResources().getString(R.string.fallo)+String.valueOf(resultado) ,Toast.LENGTH_LONG);
                toast.show();
                respuesta.setText("");
            }
       }
      catch (Exception e){
          ver_op.setText(R.string.error);
          crear_ejercicio();
      }

    }
    public void acerca_de(View view){
        Intent i = new Intent(this, AcercaDe.class );
        startActivity(i);

    }
}
