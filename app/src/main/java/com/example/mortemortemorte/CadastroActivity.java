package com.example.mortemortemorte;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btncadastro = findViewById(R.id.btncadastro);
        EditText username = findViewById(R.id.editextnome);
        EditText password = findViewById(R.id.edittextsenha);
        EditText repassword = findViewById(R.id.edittextconfsenha);
        Button btnjacad = findViewById(R.id.btnjacad);
        Button btnvoltarinicio1 = findViewById(R.id.btnvoltarinicio1);

        DatabaseHelper DB = new DatabaseHelper(this);

        btncadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(CadastroActivity.this, "Por favor preencha todos os campos.", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(CadastroActivity.this, "Usuário cadastrado com sucesso.", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), InicialActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(CadastroActivity.this, "Cadastro não foi bem sucedido.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(CadastroActivity.this, "O usuário já está cadastrado.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(CadastroActivity.this, "As senhas não coincidem.", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        btnjacad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CadastroActivity.this, LoginActivity.class));
            }
        });

        btnvoltarinicio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CadastroActivity.this, InicialActivity.class));
            }
        });
    }
}