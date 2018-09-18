package kelompokd.com.sponsorship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfilPerusahaan extends AppCompatActivity {

    EditText username;
    EditText emailP;
    EditText noTelp;
    EditText password;
    EditText alamat;
    Button btnEditP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_perusahaan);

        username=(EditText) findViewById(R.id.username);
        emailP=(EditText) findViewById(R.id.emailU);
        password=(EditText) findViewById(R.id.password);
        noTelp=(EditText) findViewById(R.id.noTelp);
        alamat=(EditText) findViewById(R.id.alamat);
        btnEditP=(Button) findViewById(R.id.btnEditP);

        btnEditP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProfilPerusahaan.this,EditProfilPerusahaan.class);
                startActivity(intent);
            }
        });
    }
}
