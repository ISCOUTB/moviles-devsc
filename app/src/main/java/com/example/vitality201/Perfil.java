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
        String Edad= getIntent().getStringExtra("edad");
        Tedad.setText(Edad);
        String Peso= getIntent().getStringExtra("peso");
        Tpeso.setText(Peso);




        mReference = FirebaseDatabase.getInstance().getReference();
        mReference.child("Usuarios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

/*
                if (dataSnapshot.exists()) {
                    String Dnombre = dataSnapshot.child("nombre").getValue().toString();

                    Tnombre.setText(Dnombre);
                    String Dapellido = dataSnapshot.child("apellido").getValue().toString();
                    Tapellido.setText(Dapellido);
                    String Ddireccion = dataSnapshot.child("direccion").getValue().toString();
                    Tdireccion.setText(Ddireccion);
                    String Demail = dataSnapshot.child("email").getValue().toString();
                    Temail.setText(Demail);
                    String Denfermedad = dataSnapshot.child("enfermedad").getValue().toString();
                    Tenfermedad.setText(Denfermedad);
                    int Dedad = Integer.parseInt(dataSnapshot.child("edad").getValue().toString());
                    Tedad.setText(Dedad);
                    int Dpeso = Integer.parseInt(dataSnapshot.child("peso").getValue().toString());
                    Tpeso.setText(Dpeso);

                }*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Perfil.this, menu.class));

            }
        });
    }
}
