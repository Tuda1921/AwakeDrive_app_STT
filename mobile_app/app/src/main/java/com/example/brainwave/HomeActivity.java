package com.example.brainwave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 99;

    CardView measuringCard;
    CardView focusingCard;
    CardView monitoringCard;
    CardView demoCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.BLUETOOTH_SCAN}, REQUEST_CODE);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_view);

        measuringCard = findViewById(R.id.measuringCard);
        focusingCard = findViewById(R.id.focusingCard);
        monitoringCard = findViewById(R.id.monitoringCard);
        demoCard = findViewById(R.id.demoCard);

        measuringCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, BluetoothAdapterActivity.class);
                startActivity(intent);
            }
        });

        focusingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AttentionActivity.class);
                startActivity(intent);
            }
        });

        monitoringCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ModelsActivity.class);
                startActivity(intent);
            }
        });

        demoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LabeledActivity.class);
                startActivity(intent);
            }
        });
    }
}