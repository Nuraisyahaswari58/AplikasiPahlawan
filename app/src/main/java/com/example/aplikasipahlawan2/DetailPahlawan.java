package com.example.aplikasipahlawan2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasipahlawan2.R;

public class DetailPahlawan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pahlawan);

        // Ambil referensi ke View
        ImageView imageView = findViewById(R.id.imageView);
        TextView textViewNama = findViewById(R.id.textViewnama);
        TextView textViewDetail = findViewById(R.id.textViewdetail);

        // Ambil data dari Intent
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        int imageResId = getIntent().getIntExtra("imageResId", -1);

        // Set data ke View
        textViewNama.setText(name);
        textViewDetail.setText(description);
        imageView.setImageResource(imageResId);
    }
}
