package kelompokd.com.sponsorship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfilUser extends AppCompatActivity {

    EditText username;
    EditText emailU;
    EditText password;
    Button btnEditU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_user);

        username=(EditText) findViewById(R.id.username);
        emailU=(EditText) findViewById(R.id.emailU);
        password=(EditText) findViewById(R.id.password);
        btnEditU=(Button) findViewById(R.id.btnEditU);

        btnEditU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfilUser.this,EditProfilUser.class);
                startActivity(intent);
            }
        });
    }
}
