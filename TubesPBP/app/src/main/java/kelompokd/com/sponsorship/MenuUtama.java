package kelompokd.com.sponsorship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuUtama extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private ImageView Out;
    private ImageView Profil;
    private ImageView Perusahaan;
    private ImageView Event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        mAuth=FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(MenuUtama.this, Login.class));
        }

        FirebaseUser user = mAuth.getCurrentUser();

        Out=(ImageView) findViewById(R.id.Out);
        Profil=(ImageView) findViewById(R.id.Profil);
        Perusahaan=(ImageView) findViewById(R.id.Perusahaan);
        Event=(ImageView) findViewById(R.id.Event);

        Out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MenuUtama.this,Keluar.class);
                startActivity(intent);
            }
        });

        Perusahaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuUtama.this,MenuPerusahaan.class);
                startActivity(intent);
            }
        });

        Profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuUtama.this,PilihProfil.class);
                startActivity(intent);
            }
        });

        Event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuUtama.this,MenuEvent.class);
                startActivity(intent);
            }
        });
    }
}
