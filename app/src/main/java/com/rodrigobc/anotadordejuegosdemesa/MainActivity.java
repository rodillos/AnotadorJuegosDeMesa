package com.rodrigobc.anotadordejuegosdemesa;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void configurarTruco(View v){
        Intent intent = new Intent(this , anotadorTruco.class);
        startActivity(intent);
    }

    public void configurarChinchon(View v){
        Intent intent = new Intent(this, configurarChinchon.class);
        startActivity(intent);
    }

    public void configurarEscoba15(View v){
        Intent intent = new Intent(this , configurarEscoba15.class);
        startActivity(intent);
    }

    public void configurarChanchova(View v){
        DialogFragment dialogoChancho = new ConsultaJugadoresChancho();
        dialogoChancho.show(getSupportFragmentManager(), "dialogoJugadores");

        Intent intent = new Intent(this, configurarChancho.class);
        startActivity(intent);
    }

    public void configurarUno(View v){
        Intent intent = new Intent(this, configurarUno.class);
        startActivity(intent);
    }

    public void onClick(View v){
        switch(v.getId()) {
            case R.id.truco:
                Toast.makeText(getApplicationContext(),"Abriendo Configuraciones de Truco", Toast.LENGTH_SHORT).show();
                configurarTruco(v);
                break;
            case R.id.chinchon:
                Toast.makeText(getApplicationContext(),"Abriendo Configuraciones de Chin Chon", Toast.LENGTH_SHORT).show();
                configurarChinchon(v);
                break;
            case R.id.chanchova:
                Toast.makeText(getApplicationContext(),"Abriendo Configuraciones de Chancho Va!", Toast.LENGTH_SHORT).show();
                configurarChanchova(v);
                break;
            case R.id.escoba15:
                Toast.makeText(getApplicationContext(),"Abriendo Configuraciones de Escoba al 15!", Toast.LENGTH_SHORT).show();
                configurarEscoba15(v);
                break;
            case R.id.uno:
                Toast.makeText(getApplicationContext(),"Abriendo Configuraciones de Uno!", Toast.LENGTH_SHORT).show();
                configurarUno(v);
                break;



        }
    }
}
