package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    Button add_button;
    Button delete_button;
    EditText input_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cityList = findViewById(R.id.city_list);

        String []cities = {"Edmonton", "Calgary", "Vancouver", "Moscow", "Sydney", "Tokyo", "Berlin", "Paris", "Vienna", "Bejing", "Osaka", "Seattle", "New Delhi", "Washington", "Dallas", "Mexico City", "Cape Town", "London", "Cork", "Shanghai", "HongKong", "Taipei", "Venice", "Manila", "Toronto", "Detroit", "Phoenix", "Halifax", "Amsterdam", "Bangkok", "Hamburg", "Novosibirsk"};

        dataList =  new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        input_text = findViewById(R.id.input_text);
        add_button = findViewById(R.id.add_button);
        delete_button = findViewById(R.id.delete_button);

        //System.out.print(input_text.getText().toString());
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.add(input_text.getText().toString());
                cityAdapter.notifyDataSetChanged();
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.remove(input_text.getText().toString());
                cityAdapter.notifyDataSetChanged();
            }
        });
    }
}

