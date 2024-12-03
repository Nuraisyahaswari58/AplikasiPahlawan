package com.example.aplikasipahlawan2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private final HashMap<String, String> pahlawanDescriptionMap = new HashMap<>();
    private final HashMap<String, Integer> pahlawanImageMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi data pahlawan
        initializePahlawanData();

        // Ambil ListView
        ListView lvData = findViewById(R.id.lvdatapahlawan);

        // Ambil daftar nama pahlawan
        ArrayList<String> daftarPahlawan = new ArrayList<>(pahlawanDescriptionMap.keySet());

        // Buat adapter dan hubungkan ke ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daftarPahlawan);
        lvData.setAdapter(adapter);

        // Set klik listener untuk item
        lvData.setOnItemClickListener((parent, view, position, id) -> {
            String selectedName = daftarPahlawan.get(position);

            // Kirim data pahlawan ke DetailActivity
            Intent intent = new Intent(MainActivity.this, DetailPahlawan.class);
            intent.putExtra("name", selectedName);
            intent.putExtra("description", pahlawanDescriptionMap.get(selectedName));
            intent.putExtra("imageResId", pahlawanImageMap.get(selectedName));
            startActivity(intent);
        });
    }

    // Inisialisasi data pahlawan
    private void initializePahlawanData() {
        pahlawanDescriptionMap.put("Soekarno", getString(R.string.desc_soekarno));
        pahlawanImageMap.put("Soekarno", R.drawable.soekarno);

        pahlawanDescriptionMap.put("Hatta", getString(R.string.desc_hatta));
        pahlawanImageMap.put("Hatta", R.drawable.hatta);

        pahlawanDescriptionMap.put("Sudirman", getString(R.string.desc_sudirman));
        pahlawanImageMap.put("Sudirman", R.drawable.sudirman);

        pahlawanDescriptionMap.put("Pattimura", getString(R.string.desc_pattimura));
        pahlawanImageMap.put("Pattimura", R.drawable.pattimura);

        pahlawanDescriptionMap.put("Imam Bonjol", getString(R.string.desc_imam_bonjol));
        pahlawanImageMap.put("Imam Bonjol", R.drawable.imambonjol);
    }

}
