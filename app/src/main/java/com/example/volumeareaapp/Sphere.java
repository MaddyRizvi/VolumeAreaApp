package com.example.volumeareaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sphere extends AppCompatActivity {

    EditText sphere_Radius;
    TextView sphere_Result;
    Button sphere_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sphere_Radius = findViewById(R.id.editText_sphere);
        sphere_Result = findViewById(R.id.textView_sphereResult);
        sphere_Button = findViewById(R.id.button_Sphere);

        sphere_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String s_radius = sphere_Radius.getText().toString();
                    int radius = Integer.parseInt(s_radius);
//                double volume = (4/3) + 3.14159 * (radius*radius*radius);
                    double volume = Double.parseDouble(String.format("%.2f", ((4 / 3) + 3.14159 * (radius * radius * radius))));
                    sphere_Result.setText("Volume:" + volume + "m^3");
            }
        });
    }
}