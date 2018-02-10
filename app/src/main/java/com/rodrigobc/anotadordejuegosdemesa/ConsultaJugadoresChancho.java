package com.rodrigobc.anotadordejuegosdemesa;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by rodrigo.boto.so on 9/2/2018.
 *
 * https://www.youtube.com/watch?v=SiJvwBkI2Lg&t=133s
 */

public class ConsultaJugadoresChancho extends android.support.v4.app.DialogFragment{

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Cantidad de Jugadores")
                .setMessage("Ingrese la Cantidad de Jugadores")
                .setPositiveButton("Jugar!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Volver", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();
    }

}
