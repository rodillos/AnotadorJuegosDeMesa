package com.rodrigobc.anotadordejuegosdemesa;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class anotadorTruco extends AppCompatActivity {

    ArrayList<ImageView> negrasEllos, buenasEllos, negrasNosotros, buenasNosotros;

    //filas de imagenes
    LinearLayout ellosPrimerTercio, ellosSegundoTercio, ellosTercerTercio, nosotrosPrimerTercio,
        nosotrosSegundoTercio, nosotrosTererTercio;

    //negrasEllos
    ImageView negrasUnoE, negrasDosE, negrasTresE, negrasCuatroE, negrasCincoE, negrasSeisE,
        negrasSieteE, negrasOchoE, negrasNueveE, negrasDiezE, negrasOnceE, negrasDoceE,
        negrasTreceE, negrasCatorceE, negrasQuinceE;

    //rojasEllos
    ImageView buenasUnoE, buenasDosE, buenasTresE, buenasCuatroE, buenasCincoE, buenasSeisE,
            buenasSieteE, buenasOchoE, buenasNueveE, buenasDiezE, buenasOnceE, buenasDoceE,
            buenasTreceE, buenasCatorceE, buenasQuinceE;

    //negrasNosotros
    ImageView negrasUnoN, negrasDosN, negrasTresN, negrasCuatroN, negrasCincoN, negrasSeisN,
            negrasSieteN, negrasOchoN, negrasNueveN, negrasDiezN, negrasOnceN, negrasDoceN,
            negrasTreceN, negrasCatorceN, negrasQuinceN;

    //rojasNosotros
    ImageView buenasUnoN, buenasDosN, buenasTresN, buenasCuatroN, buenasCincoN, buenasSeisN,
            buenasSieteN, buenasOchoN, buenasNueveN, buenasDiezN, buenasOnceN, buenasDoceN,
            buenasTreceN, buenasCatorceN, buenasQuinceN;

    Integer contadorNosotros = 0,
            contadorEllos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotador_truco);
        asignarIDs();
        onClick();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sumarNosotros:
                sumarNosotros();
                break;
            case R.id.restarNosotros:
                restarNosotros();
                break;
            case R.id.sumarEllos:
                sumarEllos();
                break;
            case R.id.restarEllos:
                restarEllos();
                break;
        }
    }

    //TODO: al alcanzar x % 5 = 1 mostrar/ocultar la proxima linea correspondiente

    public void sumarNosotros() {
        if(contadorNosotros+1 <= 30) {
            ocultarNosotros(contadorNosotros);
            contadorNosotros++;
            mostrarNosotros(contadorNosotros);
        }else{
            ganadorNosotros();
        }
    }

    public void restarNosotros() {
        if(contadorNosotros -1 >= 0) {
            ocultarNosotros(contadorNosotros);
            contadorNosotros--;
            mostrarNosotros(contadorNosotros);
        }else{
            minimoAlcanzado();
        }
     }

    public void sumarEllos() {
        if(contadorEllos + 1 <= 30) {
            ocultarEllos(contadorEllos);
            contadorEllos++;
            mostrarEllos(contadorEllos);
        } else {
            ganadorEllos();
        }
    }

    public void restarEllos() {
        if(contadorEllos -1 >= 0){
            ocultarEllos(contadorEllos);
            contadorEllos--;
            mostrarEllos(contadorEllos);
        }else{
            minimoAlcanzado();
        }
    }

    public void asignarIDs(){
        //Asigación de tercios
        ellosPrimerTercio = (LinearLayout) findViewById(R.id.ellosPrimerTercio);
        ellosSegundoTercio = (LinearLayout) findViewById(R.id.ellosSegundoTercio);
        ellosTercerTercio = (LinearLayout) findViewById(R.id.ellosTercerTercio);
        nosotrosPrimerTercio = (LinearLayout) findViewById(R.id.nosotrosPrimerTercio);
        nosotrosSegundoTercio =(LinearLayout) findViewById(R.id.nosotrosSegundoTercio);
        nosotrosTererTercio = (LinearLayout) findViewById(R.id.nosotrosTercerTercio);

        //Asignacion de Ellos Negras
        negrasUnoE = (ImageView) findViewById(R.id.negrasUnoE);
        negrasEllos.add(negrasUnoE);
        negrasDosE = (ImageView) findViewById(R.id.negrasDosUnoE);
        negrasEllos.add(negrasDosE);
        negrasTresE = (ImageView) findViewById(R.id.negrasTresUnoE);
        negrasEllos.add(negrasTresE);
        negrasCuatroE = (ImageView) findViewById(R.id.negrasCuatroUnoE);
        negrasEllos.add(negrasCuatroE);
        negrasCincoE = (ImageView) findViewById(R.id.negrasCincoUnoE);
        negrasEllos.add(negrasCincoE);
        negrasSeisE = (ImageView) findViewById(R.id.negrasUnoDosE);
        negrasEllos.add(negrasSeisE);
        negrasSieteE  = (ImageView) findViewById(R.id.negrasDosDosE);
        negrasEllos.add(negrasSieteE);
        negrasOchoE = (ImageView) findViewById(R.id.negrasTresDosE);
        negrasEllos.add(negrasOchoE);
        negrasNueveE = (ImageView) findViewById(R.id.negrasCuatroDosE);
        negrasEllos.add(negrasNueveE);
        negrasDiezE = (ImageView) findViewById(R.id.negrasCincoDosE);
        negrasEllos.add(negrasDiezE);
        negrasOnceE = (ImageView) findViewById(R.id.negrasTresE);
        negrasEllos.add(negrasOnceE);
        negrasDoceE = (ImageView) findViewById(R.id.negrasDosTresE);
        negrasEllos.add(negrasDoceE);
        negrasTreceE = (ImageView) findViewById(R.id.negrasTresTresE);
        negrasEllos.add(negrasTreceE);
        negrasCatorceE = (ImageView) findViewById(R.id.negrasCuatroTresE);
        negrasEllos.add(negrasCatorceE);
        negrasQuinceE = (ImageView) findViewById(R.id.negrasCincoTresE);
        negrasEllos.add(negrasQuinceE);

        //Asignacion de Nosotros Negras
        negrasUnoN = (ImageView) findViewById(R.id.negrasUnoN);
        negrasNosotros.add(negrasUnoN);
        negrasDosN = (ImageView) findViewById(R.id.negrasDosUnoN);
        negrasNosotros.add(negrasDosN);
        negrasTresN = (ImageView) findViewById(R.id.negrasTresUnoN);
        negrasNosotros.add(negrasTresN);
        negrasCuatroN = (ImageView) findViewById(R.id.negrasCuatroUnoN);
        negrasNosotros.add(negrasCuatroN);
        negrasCincoN = (ImageView) findViewById(R.id.negrasCincoUnoN);
        negrasNosotros.add(negrasCincoN);
        negrasSeisN = (ImageView) findViewById(R.id.negrasUnoDosN);
        negrasNosotros.add(negrasSeisN);
        negrasSieteN  = (ImageView) findViewById(R.id.negrasDosDosN);
        negrasNosotros.add(negrasSieteN);
        negrasOchoN = (ImageView) findViewById(R.id.negrasTresDosN);
        negrasNosotros.add(negrasOchoN);
        negrasNueveN = (ImageView) findViewById(R.id.negrasCuatroDosN);
        negrasNosotros.add(negrasNueveN);
        negrasDiezN = (ImageView) findViewById(R.id.negrasCincoDosN);
        negrasNosotros.add(negrasDiezN);
        negrasOnceN = (ImageView) findViewById(R.id.negrasTresN);
        negrasNosotros.add(negrasOnceN);
        negrasDoceN = (ImageView) findViewById(R.id.negrasDosTresN);
        negrasNosotros.add(negrasDoceN);
        negrasTreceN = (ImageView) findViewById(R.id.negrasTresTresN);
        negrasNosotros.add(negrasTreceN);
        negrasCatorceN = (ImageView) findViewById(R.id.negrasCuatroTresN);
        negrasNosotros.add(negrasCatorceN);
        negrasQuinceN = (ImageView) findViewById(R.id.negrasCincoTresN);
        negrasNosotros.add(negrasQuinceN);

        //Asignacion de Ellos Buenas
        buenasUnoE = (ImageView) findViewById(R.id.buenasUnoE);
        buenasEllos.add(buenasUnoE);
        buenasDosE = (ImageView) findViewById(R.id.buenasDosUnoE);
        buenasEllos.add(buenasDosE);
        buenasTresE = (ImageView) findViewById(R.id.buenasTresUnoE);
        buenasEllos.add(buenasTresE);
        buenasCuatroE = (ImageView) findViewById(R.id.buenasCuatroUnoE);
        buenasEllos.add(buenasCuatroE);
        buenasCincoE = (ImageView) findViewById(R.id.buenasCincoUnoE);
        buenasEllos.add(buenasCincoE);
        buenasSeisE = (ImageView) findViewById(R.id.buenasUnoDosE);
        buenasEllos.add(buenasSeisE);
        buenasSieteE  = (ImageView) findViewById(R.id.buenasDosDosE);
        buenasEllos.add(buenasSieteE);
        buenasOchoE = (ImageView) findViewById(R.id.buenasTresDosE);
        buenasEllos.add(buenasOchoE);
        buenasNueveE = (ImageView) findViewById(R.id.buenasCuatroDosE);
        buenasEllos.add(buenasNueveE);
        buenasDiezE = (ImageView) findViewById(R.id.buenasCincoDosE);
        buenasEllos.add(buenasDiezE);
        buenasOnceE = (ImageView) findViewById(R.id.buenasTresE);
        buenasEllos.add(buenasOnceE);
        buenasDoceE = (ImageView) findViewById(R.id.buenasDosTresE);
        buenasEllos.add(buenasDoceE);
        buenasTreceE = (ImageView) findViewById(R.id.buenasTresTresE);
        buenasEllos.add(buenasTreceE);
        buenasCatorceE = (ImageView) findViewById(R.id.buenasCuatroTresE);
        buenasEllos.add(buenasCatorceE);
        buenasQuinceE = (ImageView) findViewById(R.id.buenasCincoTresE);
        buenasEllos.add(buenasQuinceE);

        //Asignacion de Nosotros Buenas
        buenasUnoN = (ImageView) findViewById(R.id.buenasUnoN);
        buenasNosotros.add(buenasUnoN);
        buenasDosN = (ImageView) findViewById(R.id.buenasDosUnoN);
        buenasNosotros.add(buenasDosN);
        buenasTresN = (ImageView) findViewById(R.id.buenasTresUnoN);
        buenasNosotros.add(buenasTresN);
        buenasCuatroN = (ImageView) findViewById(R.id.buenasCuatroUnoN);
        buenasNosotros.add(buenasCuatroN);
        buenasCincoN = (ImageView) findViewById(R.id.buenasCincoUnoN);
        buenasNosotros.add(buenasCincoN);
        buenasSeisN = (ImageView) findViewById(R.id.buenasUnoDosN);
        buenasNosotros.add(buenasSeisN);
        buenasSieteN  = (ImageView) findViewById(R.id.buenasDosDosN);
        buenasNosotros.add(buenasSieteN);
        buenasOchoN = (ImageView) findViewById(R.id.buenasTresDosN);
        buenasNosotros.add(buenasOchoN);
        buenasNueveN = (ImageView) findViewById(R.id.buenasCuatroDosN);
        buenasNosotros.add(buenasNueveN);
        buenasDiezN = (ImageView) findViewById(R.id.buenasCincoDosN);
        buenasNosotros.add(buenasDiezN);
        buenasOnceN = (ImageView) findViewById(R.id.buenasTresN);
        buenasNosotros.add(buenasOnceN);
        buenasDoceN = (ImageView) findViewById(R.id.buenasDosTresN);
        buenasNosotros.add(buenasDoceN);
        buenasTreceN = (ImageView) findViewById(R.id.buenasTresTresN);
        buenasNosotros.add(buenasTreceN);
        buenasCatorceN = (ImageView) findViewById(R.id.buenasCuatroTresN);
        buenasNosotros.add(buenasCatorceN);
        buenasQuinceN = (ImageView) findViewById(R.id.buenasCincoTresN);
        buenasNosotros.add(buenasQuinceN);
    }

    private void ocultarNosotros(int cantidad){

        if(cantidad > 15){
            buenasNosotros.get(cantidad - 16).setVisibility(View.GONE);
        }else{
            negrasNosotros.get(cantidad - 1).setVisibility(View.GONE);
        }

    }

    private void mostrarNosotros(int cantidad){
        if(cantidad > 15){
            buenasNosotros.get(cantidad - 16).setVisibility(View.VISIBLE);
        }else{
            negrasNosotros.get(cantidad - 1).setVisibility(View.VISIBLE);
        }
    }

    private void mostrarEllos(int cantidad){
        if(cantidad > 15){
            buenasEllos.get(cantidad - 16).setVisibility(View.VISIBLE);
        }else{
            negrasEllos.get(cantidad - 1).setVisibility(View.VISIBLE);
        }
    }

    private void ocultarEllos(int cantidad){
        if(cantidad > 15){
            buenasEllos.get(cantidad - 16).setVisibility(View.GONE);
        }else{
            negrasEllos.get(cantidad - 1).setVisibility(View.GONE);
        }
    }

    private void minimoAlcanzado(){
        Context contexto = getApplicationContext();
        String mensaje = "Mas de 0 no se puede troesma";
        int duracion = Toast.LENGTH_SHORT;
        Toast.makeText(contexto, mensaje, duracion).show();
    }

    private void ganadorNosotros(){
        //TODO: definir acción a realizar, cambio de vista.
    }

    private void ganadorEllos(){
        //TODO: definir acción a realizar, cambio de vista, la misma que para nosotros.
    }
}