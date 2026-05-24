package com.example.assignment3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button add,sub,mul,div;
    Double res;
    EditText addEt1,subEt,divEt,mulEt,num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            add=findViewById(R.id.add);
            sub=findViewById(R.id.sub);
            mul=findViewById(R.id.mul);
            div=findViewById(R.id.div);
            num1=findViewById(R.id.firstnum);
            num2=findViewById(R.id.secondnum);
            addEt1=findViewById(R.id.addET);
            subEt=findViewById(R.id.subET);
            mulEt=findViewById(R.id.mulEt);
            divEt=findViewById(R.id.divET);

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Double a=Double.parseDouble(num1.getText().toString());
                    Double b=Double.parseDouble(num2.getText().toString());
                    Double sum=a+b;
                    addEt1.setText(sum.toString());
                }
            });

            sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Double a=Double.parseDouble(num1.getText().toString());
                    Double b=Double.parseDouble(num2.getText().toString());
                    Double sub=a-b;
                    subEt.setText(sub.toString());

                }
            });

            mul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Double a=Double.parseDouble(num1.getText().toString());
                    Double b=Double.parseDouble(num2.getText().toString());
                    Double mul=a*b;
                    mulEt.setText(mul.toString());
                }
            });

            div.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Double a=Double.parseDouble(num1.getText().toString());
                    Double b=Double.parseDouble(num2.getText().toString());
                    Double div=a/b;
                    divEt.setText(div.toString());

                }
            });
            return insets;
        });
    }
}