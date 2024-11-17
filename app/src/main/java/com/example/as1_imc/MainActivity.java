package com.example.as1_imc;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText altura;
    private EditText peso;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        altura = findViewById(R.id.edit_altura);
        peso = findViewById(R.id.edit_peso);
        resultado = findViewById(R.id.text_diagnostico);
    }

    public void verificarIMC(View view){

        if (!altura.getText().toString().trim().isEmpty() && !peso.getText().toString().trim().isEmpty()) {

            float imc =  (Float.parseFloat(peso.getText().toString()) /
                    (Float.parseFloat(altura.getText().toString()) *
                            Float.parseFloat(altura.getText().toString())));

            if (imc < 18.5) {
                resultado.setText(R.string.abaixo_do_peso);
            } else if(imc >= 18.5 && imc < 24.9){
                resultado.setText(R.string.peso_normal);
            } else if(imc >= 25 && imc < 29.9){
                resultado.setText(R.string.sobrepeso);
            } else if(imc >= 30 && imc < 34.9){
                resultado.setText(R.string.obesidade_grau_1);
            } else if(imc >= 35 && imc < 39.9){
                resultado.setText(R.string.obesidade_grau_2);
            } else resultado.setText(R.string.obesidade_grau_3);

            DecimalFormat df = new DecimalFormat("0.00");

            exibirMensagem("Valor do IMC: " + df.format(imc) + " kg/m2");

        } else{
            exibirMensagem("Preencha os campos de Altura e Peso!");
        }

    }

    private void exibirMensagem (String mensagem) {
        Toast.makeText(getBaseContext(), mensagem, Toast.LENGTH_LONG).show();
    }
}