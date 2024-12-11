package com.omkar.bucketlist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ThingsToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_things_to_do);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recyclerview_things_to_do), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setUpList();
    }

    private void setUpList() {
        BucketListEntry[] thingsToDo = {
                new BucketListEntry("Hiking Adventure", "Explore nature and challenge yourself with a hike.", R.drawable.hiking, 5),
                new BucketListEntry("Scuba Diving Escapade", "Discover the underwater world and experience the thrill of scuba diving.", R.drawable.scuba_diving, 4.5f),
                new BucketListEntry("Witnessing Northern Lights", "Marvel at the breathtaking display of the Northern Lights in the night sky.", R.drawable.northern_lights, 3.5f),
                new BucketListEntry("Road Trip Across the Country", "Embark on a journey of a lifetime and explore new places with friends and family.", R.drawable.road_trip, 5),
                new BucketListEntry("Skydiving Thrill", "Experience the rush of free falling from 10,000 feet and take in the stunning views.", R.drawable.skydive, 4)
        };

        RecyclerView listView = findViewById(R.id.recyclerview_things_to_do);
        BucketListEntryAdapter adapter = new BucketListEntryAdapter(thingsToDo);
        listView.setAdapter(adapter);
    }
}