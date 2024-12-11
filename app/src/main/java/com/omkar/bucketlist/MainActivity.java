package com.omkar.bucketlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        setOnClickListeners();
    }

    private void setOnClickListeners() {
        CardView thingsToDoCard = findViewById(R.id.card_view_things_to_do);
        CardView placesToDoCard = findViewById(R.id.card_view_places_to_go);

        thingsToDoCard.setOnClickListener((View v) -> {
            Intent intent = new Intent(MainActivity.this, ThingsToDoActivity.class);
            startActivity(intent);
        });

        placesToDoCard.setOnClickListener((View v) -> {
            Intent intent = new Intent(MainActivity.this, PlacesToGoActivity.class);
            startActivity(intent);
        });
    }

}