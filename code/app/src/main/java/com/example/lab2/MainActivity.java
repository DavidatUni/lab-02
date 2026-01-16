package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    Button confirm_button;
    EditText input_text;
    String selected_city;

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
        confirm_button = findViewById(R.id.confirm_button);
        input_text.setVisibility(View.GONE);
        confirm_button.setVisibility(View.GONE);

        //System.out.print(input_text.getText().toString());
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_text.setVisibility(View.VISIBLE);
                confirm_button.setVisibility(View.VISIBLE);
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.remove(selected_city);
                cityAdapter.notifyDataSetChanged();
            }
        });

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.add(input_text.getText().toString());
                cityAdapter.notifyDataSetChanged();
                input_text.setVisibility(View.GONE);
                confirm_button.setVisibility(View.GONE);
            }
        });

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected_city = parent.getItemAtPosition(position).toString();
            }
        });
    }
}

