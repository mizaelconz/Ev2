package com.example.misaelislas.act3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class CurpActivity extends AppCompatActivity {

    Spinner estados;
    Spinner sexos;
    private EditText mNombre;
    private EditText mApellidoPaterno;
    private EditText mApellidoMaterno;
    private EditText mdia;
    private EditText mmes;
    private EditText mano;
    private RadioButton mHombre;
    private RadioButton mMujer;
    private Button mGenerar;
    private TextView txt_generado;
    private TextView txt_nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curp);
        mNombre = findViewById(R.id.txt_nom);
        mGenerar = findViewById(R.id.btn_generar);
        mApellidoPaterno = findViewById(R.id.txt_app);
        mApellidoMaterno = findViewById(R.id.txt_apm);
        mdia = findViewById(R.id.txt_dia);
        mmes = findViewById(R.id.txt_mes);
        mano = findViewById(R.id.txt_ano);
        txt_generado = findViewById(R.id.txt_generado);


        sexos=(Spinner)findViewById(R.id.txt_sexo);
        estados=(Spinner)findViewById(R.id.txt_entidad);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.estados, android.R.layout.simple_spinner_item);
        estados.setAdapter(adapter);

        ArrayAdapter<CharSequence>  adapters= ArrayAdapter.createFromResource(this, R.array.sexos, android.R.layout.simple_spinner_item);
        sexos.setAdapter(adapters);


        mGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ano = mano.getText().toString();
                String ANO = ano.substring(2,4);

                String mes = mmes.getText().toString();
                String MES = mes.substring(0,2);

                String sexo = sexos.getSelectedItem().toString();
                String SEXO = sexo.substring(0,1);

                String entidad = estados.getSelectedItem().toString();
                String ESTADOS = entidad.substring(0,2);

                String dia = mdia.getText().toString();
                String DIA = dia.substring(0,2);


                String apellidoma = mApellidoMaterno.getText().toString();
                String APELLIDO_MA = apellidoma.substring(0,1);

                String apellidopa = mApellidoPaterno.getText().toString();
                String APELLIDO_PA = apellidopa.substring(0,2);

                String nombre = mNombre.getText().toString();
                String NOMBRE = nombre.substring(0,1);


                        txt_generado.setText(APELLIDO_PA + APELLIDO_MA + NOMBRE + ANO + MES + DIA + SEXO + ESTADOS);

                String mGenerado = txt_generado.getText().toString();

                        Intent miIntent = new Intent(CurpActivity.this,activity2.class);
                        miIntent.putExtra("Ccurp",mGenerado);
                startActivity(miIntent);


            }   
        });

    }


}
