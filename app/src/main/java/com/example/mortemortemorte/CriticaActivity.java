package com.example.mortemortemorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CriticaActivity extends AppCompatActivity implements View.OnClickListener{

    Button read, write;
    EditText userInput;
    TextView fileContent;

    private String filename = "Critica.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_critica);

        Button btnmenuinicio9 = (Button)findViewById(R.id.btnmenuinicio9);
        btnmenuinicio9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(CriticaActivity.this, MenuActivity.class));
            }
        });

        read = findViewById(R.id.btnler);
        write = findViewById(R.id.btnsalvar);
        userInput = findViewById(R.id.editcritica);
        fileContent = findViewById(R.id.textcritica);

        read.setOnClickListener(this);
        write.setOnClickListener(this);
    }

    public void printMessage(String m) {
        Toast.makeText(this, m, Toast.LENGTH_LONG).show();
    }

    public void onClick(View view) {
        Button b = (Button) view;
        String b_text = b.getText().toString();

        switch (b_text.toLowerCase()) {
            case "salvar": {
                writeData();
                break;
            }
            case "ler": {
                readData();
                break;
            }
        }
    }

    private void writeData() {

        try {
            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
            String data = userInput.getText().toString();
            fos.write(data.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userInput.setText("");
        printMessage("Salvamento no arquivo " + filename + " completo...");
    }

    private void readData() {
        try {
            FileInputStream fin = openFileInput(filename);
            int a;
            StringBuilder temp = new StringBuilder();
            while ((a = fin.read()) != -1) {
                temp.append((char) a);
            }

            // setting text from the file.
            fileContent.setText(temp.toString());
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printMessage("Leitura do arquivo " + filename + " completa..");
    }
}