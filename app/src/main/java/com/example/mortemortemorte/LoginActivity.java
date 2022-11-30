package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DatabaseHelper DB = new DatabaseHelper(this);

        Button btnvoltarinicio2 = findViewById(R.id.btnvoltarinicio2);
        Button btnlogin = findViewById(R.id.btnlogin);
        Button btnsemcad = findViewById(R.id.btnsemcad);
        EditText username = findViewById(R.id.editusuario);
        EditText password = findViewById(R.id.editloginsenha);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Por favor preencha todos os campos.", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "Usuário logado.", Toast.LENGTH_LONG).show();
                        Intent intent  = new Intent(getApplicationContext(), InicialActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Usuário ou senha incorretos.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnsemcad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CadastroActivity.class));
            }
        });

        btnvoltarinicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, InicialActivity.class));
            }
        });
    }
}