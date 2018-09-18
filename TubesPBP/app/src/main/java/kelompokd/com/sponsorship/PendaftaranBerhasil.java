package kelompokd.com.sponsorship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PendaftaranBerhasil extends AppCompatActivity {

    Button btnlogin;
    ImageView Berhasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_berhasil);
        btnlogin=(Button) findViewById(R.id.btnLogin);
        Berhasil=(ImageView) findViewById(R.id.Berhasil);

        Berhasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PendaftaranBerhasil.this,Login.class);
                startActivity(intent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PendaftaranBerhasil.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
