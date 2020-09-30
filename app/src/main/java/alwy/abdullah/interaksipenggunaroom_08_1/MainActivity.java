package alwy.abdullah.interaksipenggunaroom_08_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] arrayJurusan = {"Akuntansi", "Mesin", "Teknik Elektrik", "Teknik Kimia", "Teknik Informatika"};
    String tempJenisKelamin;
    String nama, nomerInduk, jenisKelamin, tanggalLahir, jurusan;
    Spinner spinner;
    Button simpan;
    EditText edtNama, edtNomorInduk, edtTanggal;
    RadioGroup rdJenisKelamin;
    RadioButton laki, perempuan;

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNama = findViewById(R.id.editText_nama);
        edtNomorInduk = findViewById(R.id.editText_nomorInduk);
        rdJenisKelamin = findViewById(R.id.radioGroup2);
        laki = findViewById(R.id.radioButtonLaki);
        perempuan = findViewById(R.id.radioButtonPerempuan);
        simpan = findViewById(R.id.btnSimpan);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, arrayJurusan);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        edtTanggal = findViewById(R.id.editText_Tanggal);
        edtTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edtNama.getText().toString();
                nomerInduk = edtNomorInduk.getText().toString();
                tanggalLahir = edtTanggal.getText().toString();
                jenisKelamin = tempJenisKelamin;
                jurusan = spinner.getSelectedItem().toString();

                Data data = new Data(nama, nomerInduk, tanggalLahir, jenisKelamin, jurusan);

                Intent intent = new Intent(MainActivity.this, SimpanData.class);
//                intent.putExtra("nama", nama);
//                intent.putExtra("nomerInduk", nomerInduk);
//                intent.putExtra("tanggalLahir", tanggalLahir);
//                intent.putExtra("jenisKelamin", jenisKelamin);
//                intent.putExtra("jurusan", jurusan);
                intent.putExtra("DATA", data);
                startActivity(intent);
            }
        });

        rdJenisKelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioButtonLaki:
                        tempJenisKelamin = "Laki-Laki";
                        break;
                    case R.id.radioButtonPerempuan:
                        tempJenisKelamin = "Perempuan";
                        break;
                }
            }
        });
    }

    private void showDateDialog() {
        //Get tanggal Sekarang
        final Calendar calendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                edtTanggal.setText(dateFormatter.format(newDate.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), "Selected User: "+ arrayJurusan[i] ,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}