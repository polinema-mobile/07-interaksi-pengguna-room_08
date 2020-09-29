package alwy.abdullah.interaksipenggunaroom_08_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SimpanData extends AppCompatActivity {
    TextView txtNama, txtNomerInduk, txtTanggalLahir, txtJenisKelamin, txtJurusan;
    String nama, nomerInduk,tanggalLahir, jenisKelamin, jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpan_data);

        txtNama = findViewById(R.id.tvNama);
        txtNomerInduk = findViewById(R.id.tvNomerInduk);
        txtTanggalLahir = findViewById(R.id.tvTanggalLahir);
        txtJenisKelamin = findViewById(R.id.tvJenisKelamin);
        txtJurusan = findViewById(R.id.tvJurusan);

        Intent intent = getIntent();
        txtNama.setText(intent.getExtras().getString("nama"));
        txtNomerInduk.setText(intent.getExtras().getString("nomerInduk"));
        txtTanggalLahir.setText(intent.getExtras().getString("tanggalLahir"));
        txtJenisKelamin.setText(intent.getExtras().getString("jenisKelamin"));
        txtJurusan.setText(intent.getExtras().getString("jurusan"));
    }
}