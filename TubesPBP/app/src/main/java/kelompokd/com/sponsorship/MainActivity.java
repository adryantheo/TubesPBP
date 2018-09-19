package kelompokd.com.sponsorship;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

   private EditText username;
    private EditText email;
    private EditText password;
    private EditText cpassword;
    private CheckBox role1;
    private CheckBox role2;
    private Button btnSingUp;
    private Button btnLogin;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    String Username, Email, Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        username=(EditText) findViewById(R.id.username);
        email=(EditText) findViewById(R.id.emailU);
        password=(EditText) findViewById(R.id.password);
        cpassword=(EditText) findViewById(R.id.cpassword);
        role1=(CheckBox) findViewById(R.id.role1);
        role2=(CheckBox) findViewById(R.id.role2);
        btnSingUp=(Button) findViewById(R.id.btnSignUp);
        btnLogin=(Button) findViewById((R.id.btnLogin));

        if(mAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(),MenuUtama.class));
        }

        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

           String Username = username.getText().toString().trim();
           String Email = email.getText().toString().trim();
           String Password = password.getText().toString().trim();

           register_user(Email, Password);

                Intent intent=new Intent(MainActivity.this,PendaftaranBerhasil.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
        role1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    role2.setChecked(false);
                }
            }
        });
        role2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    role1.setChecked(false);
                }
            };
        });
    }

    private void register_user(final String Email, String Password){

        if(TextUtils.isEmpty(Email)){
            Toast.makeText(this,"Masukkan Email",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(Password)){
            Toast.makeText(this,"Masukkan Password",Toast.LENGTH_LONG).show();
        }

        mAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                            Log.d("mAuth", "onComplete" +task.getException().getMessage());
                            startActivity(new Intent(getApplicationContext(),Login.class));
                        }else{
                            Toast.makeText(MainActivity.this,"Registerasi Gagal",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    };
}
