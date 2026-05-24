package com.example.assignment2; import android.os.Bundle;
import android.view.View; import android.widget.Button; import android.widget.EditText; import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity; import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity { Button click;
    TextView welcome; EditText nameEt; @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); EdgeToEdge.enable(this); setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()); v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom); click = findViewById(R.id.btn);
            welcome = findViewById(R.id.wel); nameEt = findViewById(R.id.nameEt);
            click.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) { String name;
                name=nameEt.getText().toString(); welcome.setText(welcome.getText().toString()+" "+name);

                welcome.setAllCaps(true);
            }
            });
            return insets;
        });
    }
}
