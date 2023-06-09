package com.example.task2_android;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
EditText first,secand;
Button add,close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = findViewById(R.id.First_Number);
        secand = findViewById(R.id.Secand_Number);
        add = findViewById(R.id.add1);
        close = findViewById(R.id.Close);

        add.setOnClickListener(view -> {
            if(!first.getText().toString().isEmpty()&&!secand.getText().toString().isEmpty()) {
                int n1 = Integer.parseInt(first.getText().toString());
                int n2 = Integer.parseInt(secand.getText().toString());
                int sum = n1 + n2;
                String su = Integer.toString(sum);
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("Sum =",su);
                startActivity(i);
                Toast.makeText(MainActivity.this, "The addition is Successful", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(MainActivity.this, "Enter the two numbers", Toast.LENGTH_SHORT).show();
            }

        });

        close.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.AlertDialoge);
            builder.setMessage(R.string.Closing);
            builder.setPositiveButton(R.string.Positivekey, (dialogInterface, i) -> MainActivity.this.finish());
            builder.setNegativeButton(R.string.Cancel, (dialogInterface, i) -> dialogInterface.cancel());
            builder.create().show();

        });
    }
}