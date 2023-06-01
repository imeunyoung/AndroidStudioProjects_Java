package com.example.mykiosk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderFinishActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_finish);

        Intent intent = getIntent();
        int orderNumber = intent.getIntExtra("orderNumber", 100);

        TextView orderNumberTextView = findViewById(R.id.ordernumber_textView);
        orderNumberTextView.setText(String.valueOf(orderNumber));

    }


}
