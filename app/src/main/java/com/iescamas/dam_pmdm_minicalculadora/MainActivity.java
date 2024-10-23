package com.iescamas.dam_pmdm_minicalculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String str_numero,str_numeroAnterior;
    String operacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bnt_selec1).setOnClickListener(this::mostrarNumero);
        findViewById(R.id.btn_selec2).setOnClickListener(this::mostrarNumero);
        findViewById(R.id.btn_selec3).setOnClickListener(this::mostrarNumero);
        findViewById(R.id.bnt_selec4).setOnClickListener(this::mostrarNumero);
        findViewById(R.id.btn_selec5).setOnClickListener(this::mostrarNumero);
        findViewById(R.id.btn_selec6).setOnClickListener(this::mostrarNumero);
        findViewById(R.id.bnt_selec7).setOnClickListener(this::mostrarNumero);
        findViewById(R.id.btn_selec8).setOnClickListener(this::mostrarNumero);
        findViewById(R.id.bnt_selec9).setOnClickListener(this::mostrarNumero);
        findViewById(R.id.bnt_selec10).setOnClickListener(this::mostrarNumero);
        findViewById(R.id.btn_selec11).setOnClickListener(this::mostrarNumero);
        findViewById(R.id.btn_op1).setOnClickListener(this::operaciones);
        findViewById(R.id.btn_op2).setOnClickListener(this::operaciones);
        findViewById(R.id.btn_op3).setOnClickListener(this::operaciones);
        findViewById(R.id.btn_op4).setOnClickListener(this::operaciones);
        findViewById(R.id.btn_op5).setOnClickListener(v->signo());
        findViewById(R.id.btn_op6).setOnClickListener(v->calculaRaiz());
        findViewById(R.id.btn_op7).setOnClickListener(v->calculaInverso());
        findViewById(R.id.btn_resultado).setOnClickListener(v->resultado(operacion));
        findViewById(R.id.btn_clean).setOnClickListener(view -> clean());
    }
    private void calculaRaiz(){
        str_numero = ((TextView)findViewById(R.id.lbl_numeros)).getText().toString();
        ((TextView)findViewById(R.id.lbl_numeros)).setText(String.valueOf(Math.sqrt(Double.parseDouble(str_numero))));
        str_numero = (String) getText(R.string.btn_selec10);
    }
    private void calculaInverso(){
        str_numero = ((TextView)findViewById(R.id.lbl_numeros)).getText().toString();
        ((TextView)findViewById(R.id.lbl_numeros)).setText(String.valueOf(1/(Double.parseDouble(str_numero))));
        str_numero = (String) getText(R.string.btn_selec10);
    }
    private void mostrarNumero(View view) {
        Button btn = (Button) view;
        String nuevoNumero = btn.getText().toString();

        //Comprueba si esta vacia la variable numero
        if (str_numero==null){
            //Si se pulsa el punto estando vacio se muestra '0.'
            if(nuevoNumero.equals(getString(R.string.btn_selec11))) {
                str_numero = getString(R.string.btn_selec10) + nuevoNumero;
            }
            //Si se pulsa cualquier otro botón se muestra el numero pulsado
            else{
                str_numero = nuevoNumero;
            }

        }//Comprueba si no esta vacia la variable numero
        else{
            //Si se pulsa cero despues de str_numero con algún numero
            if (nuevoNumero.equals(getString(R.string.btn_selec10))){
                //si el numero que se encuentra es '0.' añade
                if (str_numero.startsWith(((getString(R.string.btn_selec10))+getString(R.string.btn_selec11)))){
                    str_numero +=nuevoNumero;
                //si no empieza por 0 añade
                } else if (!str_numero.startsWith(getString(R.string.btn_selec10))) {
                    str_numero+=nuevoNumero;
                }
                //si es una coma
            } else if (nuevoNumero.equals((getString(R.string.btn_selec11)))) {
                    //Si no contiene una coma se añade la coma
                    if (!str_numero.contains(getString(R.string.btn_selec11))){
                        str_numero+=nuevoNumero;
                    }
            }
            else{
                //Si empieza por cero y no tiene una coma se iguala al numero introducido
                if(str_numero.startsWith(getString(R.string.btn_selec10)) && !str_numero.contains(getString(R.string.btn_selec11)))
                    str_numero=nuevoNumero;
                //Si no se añade
                else{
                    str_numero+=nuevoNumero;
                }
            }

        }
        ((TextView)findViewById(R.id.lbl_numeros)).setText(str_numero);
    }
    private void resultado(String operando){
        str_numero = ((TextView)findViewById(R.id.lbl_numeros)).getText().toString();
        double resultado = 0;
        switch (operando){
            case "+": resultado = Double.parseDouble(str_numeroAnterior)+ Double.parseDouble(str_numero);break;
            case "-": resultado = Double.parseDouble(str_numeroAnterior)- Double.parseDouble(str_numero);break;
            case "x": resultado = Double.parseDouble(str_numeroAnterior)* Double.parseDouble(str_numero);break;
            case "/": resultado = Double.parseDouble(str_numeroAnterior)/ Double.parseDouble(str_numero);break;
        }
        str_numero = (String) getText(R.string.btn_selec10);
        ((TextView)findViewById(R.id.lbl_numeros)).setText(String.valueOf(resultado));
    }
    private void signo(){
        str_numero = ((TextView)findViewById(R.id.lbl_numeros)).getText().toString();
        double numSig = Double.parseDouble(str_numero);
        numSig*=-1;
        ((TextView)findViewById(R.id.lbl_numeros)).setText(String.valueOf(numSig));

    }
    private void operaciones(View v){
        Button b = (Button)v;
        str_numeroAnterior = ((TextView)findViewById(R.id.lbl_numeros)).getText().toString();
        str_numero="";
        operacion = b.getText().toString();
    }
    private void clean(){
        str_numero = (String) getText(R.string.btn_selec10);
        str_numeroAnterior = (String) getText(R.string.btn_selec10);
        operacion="";
        ((TextView)findViewById(R.id.lbl_numeros)).setText(getText(R.string.btn_selec10));

    }

}