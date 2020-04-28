package com.example.vitality201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Perfil extends AppCompatActivity {
    private Button btn2;
    TextView Tnombre,Tapellido,Tedad,Tpeso,Tdireccion,Tenfermedad,Temail;
    DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        btn2  =   findViewById(R.id.button15);

        Tnombre=(TextView) findViewById(R.id.nombreT);
        Tapellido=(TextView) findViewById(R.id.apellidoT);
        Tedad=(TextView) findViewById(R.id.edadT);
        Tpeso=(TextView) findViewById(R.id.pesoT);
        Tdireccion=(TextView) findViewById(R.id.direccionT);
        Tenfermedad=(TextView) findViewById(R.id.enfermedadT);
        Temail=(TextView) findViewById(R.id.emailT2);


        String Nombre=getIntent().getStringExtra("nombre");
        Tnombre.setText(Nombre);
        String Apellid=getIntent().getStringExtra("apellido");
        Tapellido.setText(Apellid);
        String Direccion=getIntent().getStringExtra("direccion");
        Tdireccion.setText(Direccion);
        String Enfermedad=getIntent().getStringExtra("enfermedad");
        Tenfermedad.setText(Enfermedad);
        String email=getIntent().getStringExtra("email");
        Temail.setText(email);
        int Edad=getIntent().getIntExtra("edad",1);
        Tedad.setText(Edad +" Años");
        int Peso= getIntent().getIntExtra("peso",1);
        Tpeso.setText(Peso +" Kg");


        mReference = FirebaseDatabase.getInstance().getReference();

        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Perfil.this, MainActivity.class));

            }
        });
    }
}
