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

    String textos []={"Retirese de la carrera","¿Entraste por palanca?","Cosas mediocres y esto","Estudien vagos","Deje el vicio","Deje de capar clase","Tan cerca y tan lejos","Sigue intentando","Los casis no valen","Gracias por hacer tu tarea","¿Repitente?","¿Deberia felicitarte?","Tienes delirios de grandeza","¿Socializar no es lo tuyo verdad?","Profesor madre","¿Usaste rodilleras?","Gracias piernas sexys","¿Daniela Eres tu?"};
    int random;

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

                String cosa1 =numero1.getText().toString();
                String cosa2 =numero2.getText().toString();
                String cosa3 =numero3.getText().toString();
                String cosa4 =porcentaje1.getText().toString();
                String cosa5 =porcentaje2.getText().toString();
                String cosa6 =porcentaje3.getText().toString();

                if( numero1.length()!=0 && numero2.length()!=0 && numero3.length()!=0 && porcentaje1.length()!=0 && porcentaje2.length()!=0 && porcentaje3.length()!=0  && !".".equals(cosa1) && !".".equals(cosa2) && !".".equals(cosa3) && !".".equals(cosa4) && !".".equals(cosa5) && !".".equals(cosa6)){

                    corte1=Double.parseDouble(numero1.getText().toString())*10;
                    corte2=Double.parseDouble(numero2.getText().toString())*10;
                    parcialF=Double.parseDouble(numero3.getText().toString())*10;
                    p1=Double.parseDouble(porcentaje1.getText().toString())/100;
                    p2=Double.parseDouble(porcentaje2.getText().toString())/100;
                    p3=Double.parseDouble(porcentaje3.getText().toString())/100;

                } else {

                    Toast.makeText(MainActivity.this,
                            "Por favor ingrese bien los datos", Toast.LENGTH_LONG).show();

                }

                if(corte1>=0 && corte1<=50 && corte2>=0 && corte2<=50 && parcialF>=0 && parcialF<=50 && (p1+p2+p3)==1){

                    promedio=((corte1*p1)+(corte2*p2)+(parcialF*p3));
                    numero4.setText(String.format("%.2f", promedio/10));

                    if (promedio >= 29.4 && promedio < 29.5) {

                        mensaje.setText("LLORELO PAPÁ");

                    } else if (promedio >= 29.5 && promedio < 30) {

                        mensaje.setText("Esto se le llama felicidad");

                    } else {

                        if (promedio < 10) {

                            random = 0;

                        } else if (promedio >= 10 && promedio < 20) {

                            random = 3;

                        } else if (promedio >= 20 && promedio < 29.4) {

                            random = 6;

                        } else if (promedio >= 30 && promedio < 40) {

                            random = 9;

                        } else if (promedio >= 40 && promedio < 50) {

                            random = 12;

                        } else if (promedio == 50) {

                            random = 15;

                        }

                        random=(int)(3*Math.random())+random;

                        mensaje.setText(textos[random]);

                    }

                } else {

                    Toast.makeText(MainActivity.this,
                            "Por favor ingrese bien los datos", Toast.LENGTH_LONG).show();

                }

            }

        });

    }
}
