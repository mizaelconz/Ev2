package com.example.misaelislas.act3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {

   private TextView mCurp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        mCurp = (TextView) findViewById(R.id.curp_generado);

      recibirDatos();
    }
    public void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        String curp = extras.getString("Ccurp");


        mCurp.setText(curp);
    }
}
