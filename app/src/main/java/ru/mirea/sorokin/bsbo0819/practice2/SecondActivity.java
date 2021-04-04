package ru.mirea.sorokin.bsbo0819.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = findViewById(R.id.textView);
        Bundle arg = getIntent().getExtras();
        if(arg!=null) {
            String text = (String) getIntent().getSerializableExtra("key");
            textView.setText(text);
        }
    }
}