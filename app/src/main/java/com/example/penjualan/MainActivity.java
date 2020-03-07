package com.example.penjualan;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtnamapelanggan, edtnamabarang, edtjumlahbeli, edtharga, edtuangbayar;
    private Button btnproses;
    private Button btnhapus;
    private Button btnexit;

    private TextView txtnamapelanggan;
    private TextView txtnamabarang;
    private TextView txtjumlahbeli;
    private TextView txtharga;
    private TextView txtuangbayar;
    private TextView txtbonus;
    private TextView txttotalbelanja;
    private TextView txtuangkembali;
    private TextView txtketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Autumn Shop");

        edtnamapelanggan = (EditText) findViewById(R.id.namapelanggan);
        edtnamabarang = (EditText) findViewById(R.id.nambarang);
        edtjumlahbeli = (EditText) findViewById(R.id.jumlahbeli);
        edtharga = (EditText) findViewById(R.id.harga);
        edtuangbayar = (EditText) findViewById(R.id.uangbayar);

        btnproses = (Button) findViewById(R.id.tombol1);
        btnhapus = (Button) findViewById(R.id.tombol2);
        btnexit = (Button) findViewById(R.id.tombol3);

        txtnamapelanggan = (TextView) findViewById(R.id.namapelanggan);
        txtnamabarang = (TextView) findViewById(R.id.nambarang);
        txtjumlahbeli = (TextView) findViewById(R.id.jumlahbeli);
        txtharga = (TextView) findViewById(R.id.harga);
        txtuangbayar = (TextView) findViewById(R.id.uangbayar);
        txtbonus = (TextView) findViewById(R.id.bonus);
        txttotalbelanja = (TextView) findViewById(R.id.totalbelanja);
        txtuangkembali = (TextView) findViewById(R.id.uangkembali);
        txtketerangan = (TextView) findViewById(R.id.keterangan);

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namapelanggan = edtnamapelanggan.getText().toString().trim();
                String namabarang = edtnamabarang.getText().toString().trim();
                String jumlahbeli = edtjumlahbeli.getText().toString().trim();
                String harga = edtharga.getText().toString().trim();
                String uangbayar = edtuangbayar.getText().toString().trim();

                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(uangbayar);
                double total = (jb * h);
                txttotalbelanja.setText("Total Belanja : "+total);

                if (total >= 200000){
                    txtbonus.setText("Bonus : Mouse");
                }else if (total >=500000){
                    txtbonus.setText("Bonus : Keyboard");
                }else if (total >= 400000){
                    txtbonus.setText("Bonus : Hardisk 64 Gb");
                }else {
                    txtbonus.setText("Bonus : Tidak Ada Bonus");
                }
                double uangkembalian = (ub - total);
                if (ub < total) {
                    txtketerangan.setText("Keterangan : Uang Bayar Kurang Rp "+(uangkembalian));
                    txtuangkembali.setText("Uang Kembali : RP 0");
                }else {
                    txtketerangan.setText("Keterangan : Tunggu Kembalian");
                    txtuangkembali.setText("Uang Kembali : "+uangkembalian);
                }


            }
        });
        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnamapelanggan.setText(" ");
                txtnamabarang.setText(" ");
                txttotalbelanja.setText("Total Belanja : Rp 0");
                txtharga.setText(" ");
                txtuangbayar.setText(" ");
                txtuangkembali.setText("Uang Kembali : Rp 0");
                txtbonus.setText("Bonus : - ");
                txtjumlahbeli.setText(" ");
                txtketerangan.setText("Keterangan : - ");

                Toast.makeText(getApplicationContext(),"Data Sudah Direset", Toast.LENGTH_LONG).show();


            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);

            }
        });


    }
}
