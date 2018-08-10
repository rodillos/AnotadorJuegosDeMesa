package com.rodrigobc.anotadordejuegosdemesa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;


public class MarcadorEscoba extends AppCompatActivity {

    //ArrayList<String> historial;
    ArrayList<Button> botones;

    TextView puntajeYo = (TextView) findViewById(R.id.puntajeYo), puntajeEl = (TextView) findViewById(R.id.puntajeEl);
    Integer puntosYo = 0, puntosEl = 0;

    Button finalizarMano = (Button) findViewById(R.id.finalizarMano);
    Button orosYo = (Button) findViewById(R.id.orosYo);
    Button orosEl = (Button) findViewById(R.id.orosEl);
    Button setentaYo = (Button) findViewById(R.id.setentaYo);
    Button setentaEl = (Button) findViewById(R.id.setentaEl);
    Button escobaYo = (Button) findViewById(R.id.escobaYo);
    Button escobaEl = (Button) findViewById(R.id.escobaEl);
    Button sieteDeOroYo = (Button) findViewById(R.id.sieteDeOroYo);
    Button sieteDeOroEl = (Button) findViewById(R.id.sieteDeOroEl);
    Button cartasYo = (Button) findViewById(R.id.cartasYo);
    Button cartasEl = (Button) findViewById(R.id.cartasEl);

    //public static final int FINALIZAR = 0;
    public static final int OROSYO = 1;
    public static final int OROSEL = 2;
    public static final int SETENTAYO = 3;
    public static final int SETENTAEL = 4;
    public static final int ESCOBAYO = 5;
    public static final int ESCOBAEL = 6;
    public static final int SIETEYO = 7;
    public static final int SIETEEL = 8;
    public static final int CARTASYO = 9;
    public static final int CARTASEL = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcador_escoba);
        finalizarMano.setEnabled(false);
        agregarBotones();
        asignarIdPuntaje();
    }

    //inicializa los valores de los puntajes, al iniciar nada más
    private void asignarIdPuntaje() {
        setPuntosYo();
        setPuntosEl();
    }

    //agrega todos los botones a la lista 'botones'
    private void agregarBotones(){
        botones.add(finalizarMano);
        botones.add(orosYo);
        botones.add(orosEl);
        botones.add(setentaYo);
        botones.add(setentaEl);
        botones.add(escobaYo);
        botones.add(escobaEl);
        botones.add(sieteDeOroYo);
        botones.add(sieteDeOroEl);
        botones.add(cartasYo);
        botones.add(cartasEl);
    }

    //aumenta el puntaje para el lado 'Yo'
    private void setPuntosYo(){
        if (puntosYo > 0) {
            puntosYo++;
            puntajeYo.setText(puntosYo.toString());
        }else{
            puntajeYo.setText("0");
        }
    }

    //aumenta el puntaje para el lado 'El'
    private void setPuntosEl(){
        if (puntosEl > 0) {
            puntosEl++;
            puntajeEl.setText(puntosEl.toString());
        }else{
            puntajeEl.setText("0");
        }
    }

    /*
    recibe los 'enum' de los botones,y ejecuta la funcion para sumar un tanto de cada lado
        luego bloquea ambos botones.
     */
    private void setPuntos(int botonGanador, int botonPerdedor){
        if((botonGanador % 2) == 0){
            setPuntosEl();
        } else {
            setPuntosYo();
        }
        if(botonGanador != ESCOBAYO && botonGanador != ESCOBAEL)
        botones.get(botonGanador).setEnabled(false);
        botones.get(botonPerdedor).setEnabled(false);
    }

    //TODO: agregar a cada boton, su movimiento al array, y su lado (YO/EL) para cuando este desahacer se pueda implementar
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.finalizarMano:
                finalizarMano();
                break;
            case R.id.orosYo:
                setPuntos(OROSYO, OROSEL);
                break;
            case R.id.orosEl:
                setPuntos(OROSEL, OROSYO);
                break;
            case R.id.setentaYo:
                setPuntos(SETENTAYO, SETENTAEL);
                break;
            case R.id.setentaEl:
                setPuntos(SETENTAEL, SETENTAYO);
                break;
            case R.id.sieteDeOroYo:
                setPuntos(SIETEYO, SIETEEL);
                break;
            case R.id.sieteDeOroEl:
                setPuntos(SIETEEL, SIETEYO);
                break;
            case R.id.escobaYo:
                setPuntos(ESCOBAYO, ESCOBAEL);
                break;
            case R.id.escobaEl:
                setPuntos(ESCOBAEL, ESCOBAYO);
                break;
            case R.id.cartasYo:
                setPuntos(CARTASYO, CARTASEL);
                break;
            case R.id.cartasEl:
                setPuntos(CARTASEL, CARTASYO);
                break;
         /*
            case R.id.deshacer:
                break;
         */
        }
    }

    // desboquea todos los botones excepto finalizar que lo bloquea
    private void finalizarMano(){
        desbloquearTodos();
        finalizarMano.setEnabled(false);
        //grabarEnHistorial("finalizar");
    }
/*
    private void grabarEnHistorial(String accion){
        historial.add(accion);
    }
*/

//Desbloquea todos los botones para poder volver a usarlos, excepto finalizar
    private void desbloquearTodos(){
        for(int i =1; i < botones.size(); i++){
            botones.get(i).setEnabled(true);
        }
    }
}