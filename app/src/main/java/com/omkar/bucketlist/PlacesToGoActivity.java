package com.omkar.bucketlist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class PlacesToGoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_places_to_go);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recyclerview_places_to_go), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setUpList();
    }

    private void setUpList() {
        BucketListEntry[] placesToGo = {
                new BucketListEntry("Explore Varanasi Ghats","Walk along the sacred Ganges River and experience the spiritual vibe",R.drawable.varanasi,5),
                new BucketListEntry("Pilgrimage to Badrinath","Visit the sacred temple of Lord Vishnu and seek blessings",R.drawable.badrinath,5),
                new BucketListEntry("Darshan at Jagannath Temple","Witness the majestic Rath Yatra and experience the divine energy",R.drawable.jagannathpuri,5),
                new BucketListEntry("Discover the Birthplace of Lord Rama","Visit the sacred city of Ayodhya and explore its ancient heritage",R.drawable.ayodhya_temple,5),
                new BucketListEntry("Experience the Vibrant Culture of Delhi","Explore the historic monuments, savor the street food, and soak in the city's energetic atmosphere",R.drawable.india_gate_delhi,5)
        };

        RecyclerView listView = findViewById(R.id.recyclerview_places_to_go);
        BucketListEntryAdapter adapter = new BucketListEntryAdapter(placesToGo);
        listView.setAdapter(adapter);
    }
}