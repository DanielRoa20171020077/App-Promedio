package com.example.danbr.promedio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double corte1=0;
        double corte2=0;
        double parcialF=0;
        double promedio;

        promedio=((corte1*0.35)+(corte2*0.35)+(parcialF*0.30));

    }
}
