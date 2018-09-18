package kelompokd.com.sponsorship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class PilihProfil extends AppCompatActivity {


    CheckBox role1;
    CheckBox role2;
    Button btnBatal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_profil);

        role1=(CheckBox) findViewById(R.id.role1);
        role2=(CheckBox) findViewById(R.id.role2);
        btnBatal=(Button) findViewById(R.id.btnBatal);

        role1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PilihProfil.this,ProfilUser.class);
                startActivity(intent);
            }
        });

        role2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PilihProfil.this,ProfilPerusahaan.class);
                startActivity(intent);
            }
        });

        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PilihProfil.this,MenuUtama.class);
                startActivity(intent);
            }
        });

    }
}
