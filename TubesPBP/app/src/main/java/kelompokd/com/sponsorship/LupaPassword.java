package kelompokd.com.sponsorship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class LupaPassword extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private EditText cpassword;
    private Button btnSave;
    private Button btnBatal;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);
        email=(EditText) findViewById(R.id.emailU);
        password=(EditText) findViewById(R.id.password);
        cpassword=(EditText) findViewById(R.id.cpassword);
        btnBatal=(Button) findViewById(R.id.btnBatal);
        btnSave=(Button) findViewById(R.id.btnSave);
        mAuth = FirebaseAuth.getInstance();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent= new Intent(LupaPassword.this,BerhasilGantiPass.class);
                startActivity(intent);
            }
        });

        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LupaPassword.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
