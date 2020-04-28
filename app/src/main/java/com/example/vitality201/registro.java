package com.example.vitality201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class registro extends AppCompatActivity {
    FirebaseAuth mAu;
    DatabaseReference mReference;
    Button mButtonSEnviar;
    EditText Enombre,Eapellido,Eenfermedad,Epeso,Eedad,Edireccion,Eemail,Epass;
    private String nombre;
    private String apellido;
    private String enfermedad;
    public int peso;
    public int edad;
    private String direccion;
    private  String email;
    private  String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mButtonSEnviar = findViewById(R.id.btnEnviar);
        Enombre=findViewById(R.id.etNombre);
        Eapellido=findViewById(R.id.etApellido);
        Epeso=findViewById(R.id.etPeso);
        Eedad=findViewById(R.id.etEdad);
        Edireccion=findViewById(R.id.etDireccion);
        Eemail=findViewById(R.id.etEmail);
        Epass=findViewById(R.id.etPass);
        Eenfermedad=findViewById(R.id.etEnfermedad);
        mAu = FirebaseAuth.getInstance();
        mReference = FirebaseDatabase.getInstance().getReference();

        mButtonSEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = Enombre.getText().toString();
                email = Eemail.getText().toString();
                pass = Epass.getText().toString();
                apellido = Eapellido.getText().toString();
                peso = Integer.parseInt(Epeso.getText().toString());
                edad = Integer.parseInt(Eedad.getText().toString());
                direccion = Edireccion.getText().toString();
                enfermedad=Eenfermedad.getText().toString();



                if(!nombre.isEmpty() && !email.isEmpty() && !pass.isEmpty()){
                    if(pass.length()>=6){

                        registerUser();
                    }else{
                        Toast.makeText(registro.this, "El Password debe tenes al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }
                    registerUser();
                }else{
                    Toast.makeText(registro.this, "Debe Completar Los campos", Toast.LENGTH_SHORT).show();
                }




            }
        });


    }

    private void registerUser(){
        mAu.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String, Object> map=new HashMap<>();
                    map.put("nombre",nombre);
                    map.put("email",email);
                    map.put("password",pass);
                    map.put("apellido",apellido);
                    map.put("enfermedad",enfermedad);
                    map.put("peso",peso);
                    map.put("edad",edad);
                    map.put("direccion",direccion);


                    String id = mAu.getCurrentUser().getUid();
                    mReference.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                Intent i =new Intent(registro.this, Perfil.class);
                                i.putExtra("nombre",Enombre.getText().toString());
                                i.putExtra("email",Eemail.getText().toString());
                                i.putExtra("apellido",Eapellido.getText().toString());
                                i.putExtra("enfermedad",Eenfermedad.getText().toString());
                                i.putExtra("peso",Integer.parseInt(Epeso.getText().toString()));
                                i.putExtra("edad",Integer.parseInt(Eedad.getText().toString()));
                                i.putExtra("direccion",Edireccion.getText().toString());
                                startActivity(i);
                                finish();
                            }else{
                                Toast.makeText(registro.this, "Ha ocurrido un error!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }}