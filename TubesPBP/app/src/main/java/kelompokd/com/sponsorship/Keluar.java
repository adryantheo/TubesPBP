package kelompokd.com.sponsorship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Keluar extends AppCompatActivity {

    Button btnYes;
    Button btnNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keluar);

        btnYes=(Button) findViewById(R.id.btnYes);
        btnNo=(Button) findViewById(R.id.btnNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Keluar.this,KeluarBerhasil.class);
                startActivity(intent);
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Keluar.this,MenuUtama.class);
                startActivity(intent);
            }
        });
    }
}
