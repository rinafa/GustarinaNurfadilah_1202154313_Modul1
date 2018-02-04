package si3901.rinafdlh.gustarinanurfadilah_1202154313_modul1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rina on 2/4/2018.
 */

public class ResultActivity extends AppCompatActivity {
    TextView Tempat, Menu, Porsi, Harga;
    int abnormalHarga = 30000;
    int EatbusHarga = 50000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        Tempat = findViewById(R.id.Tempat);
        Menu = findViewById(R.id.Menu);
        Porsi = findViewById(R.id.Porsi);
        Harga = findViewById(R.id.Harga);

        String tempat = intent.getStringExtra("tempat");
        String menu = intent.getStringExtra("makanan");
        String porsi = intent.getStringExtra("jumlah");
        int uang = intent.getIntExtra("uangOsas",0);

        int jumlah = Integer.parseInt(porsi);

        Tempat.setText(tempat);
        Menu.setText(menu);
        Porsi.setText(porsi);

        int abHarga = abnormalHarga*jumlah;
        int eatHarga = EatbusHarga*jumlah;

        switch (tempat){
            case "Abnormal":
                Harga.setText(String.valueOf(abHarga));
                if (abHarga > uang){
                    Toast.makeText(this, "Jangan disini makan malamnya, uang tidak cukup", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Disini aja makan malamnya", Toast.LENGTH_LONG).show();
                }
                break;
            case "Eatbus":
                Harga.setText(String.valueOf(eatHarga));
                if (eatHarga > uang){
                    Toast.makeText(this, "Jangan disini makan malamnya, uang tidak cukup", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Disini aja makan malamnya", Toast.LENGTH_LONG).show();
                }
                break;
        }

    }
}
