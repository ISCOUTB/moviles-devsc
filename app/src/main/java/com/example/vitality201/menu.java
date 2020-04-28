package com.example.vitality201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class menu extends AppCompatActivity {
    TextView TnombreyA;
    private Button btn2;
    TextView Tnombre,Tapellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn2  =   findViewById(R.id.button10);

        Tnombre=(TextView) findViewById(R.id.nombreT);
        Tapellido=(TextView) findViewById(R.id.apellidoT);

        String Nombre=getIntent().getStringExtra("nombre");
        String Apellid=getIntent().getStringExtra("apellido");
        TnombreyA=(TextView) findViewById(R.id.textView12);


        TnombreyA.setText(Nombre+" "+Apellid);
        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(menu.this, MainActivity.class));

            }
        });
    }
}
