package com.example.danbr.promedio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText numero1,numero2,numero3,numero4,mensaje,porcentaje1,porcentaje2,porcentaje3;
    private Button calcular;

    private double corte1=0;
    private double corte2=0;
    private double parcialF=0;
    private double p1,p2,p3;
    private double promedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1=(EditText) findViewById(R.id.numero1);
        numero2=(EditText) findViewById(R.id.numero2);
        numero3=(EditText) findViewById(R.id.numero3);
        numero4=(EditText) findViewById(R.id.numero4);
        mensaje=(EditText) findViewById(R.id.mensaje);

        porcentaje1=(EditText) findViewById(R.id.porcentaje1);
        porcentaje2=(EditText) findViewById(R.id.porcentaje2);
        porcentaje3=(EditText) findViewById(R.id.porcentaje3);

        calcular=(Button) findViewById(R.id.button);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                corte1=Double.parseDouble(numero1.getText().toString())*10;
                corte2=Double.parseDouble(numero2.getText().toString())*10;
                parcialF=Double.parseDouble(numero3.getText().toString())*10;

                p1=Double.parseDouble(porcentaje1.getText().toString())/100;
                p2=Double.parseDouble(porcentaje2.getText().toString())/100;
                p3=Double.parseDouble(porcentaje3.getText().toString())/100;

                promedio=((corte1*p1)+(corte2*p2)+(parcialF*p3));
                numero4.setText(String.format("%.2f", promedio/10));

                if((p1+p2+p3)==1) {

                    if (promedio < 10) {

                        mensaje.setText("Retirese de la carrera");

                    } else if (promedio >= 10 && promedio < 20) {

                        mensaje.setText("Estudien vagos");

                    } else if (promedio >= 20 && promedio < 29.4) {

                        mensaje.setText("Tan cerca y tan lejos");

                    } else if (promedio >= 29.4 && promedio < 29.5) {

                        mensaje.setText("LLORELO PAPÁ");

                    } else if (promedio >= 29.5 && promedio < 30) {

                        mensaje.setText("Esto se le llama felicidad");

                    } else if (promedio >= 30 && promedio < 40) {

                        mensaje.setText("Gracias por hacer tu tarea");

                    } else if (promedio >= 40 && promedio < 50) {

                        mensaje.setText("Tienes delirios de grandeza");

                    } else if (promedio == 50) {

                        mensaje.setText("¿Usaste rodilleras?");

                    }

                } else {

                    Toast.makeText(MainActivity.this,
                            "La suma de porcentajes debe ser 100% ", Toast.LENGTH_LONG).show();

                }

            }

        });

    }
}
