package com.example.login;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void lanzarmensaje(View view){
        EditText edittext = findViewById(R.id.txt_nombres);
        EditText edittext1 = findViewById(R.id.txt_apellidos);
        Toast.makeText(this, "Bienvenido "+edittext.getText().toString() +" "+edittext1.getText().toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,SegundaActividad.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        };


    }

