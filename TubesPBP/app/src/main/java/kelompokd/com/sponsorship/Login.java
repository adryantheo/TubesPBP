package kelompokd.com.sponsorship;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button btnLogin;
    private Button btnLupapass;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        //username=(EditText) findViewById(R.id.username);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password) ;
        btnLupapass=(Button) findViewById(R.id.btnLupaPass);
        btnLogin=(Button) findViewById(R.id.btnLogin);
        //final String Username = username.getText().toString().trim();


        if(mAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(),MenuUtama.class));
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               user_login();



                //Intent intent=new Intent(Login.this,MenuUtama.class);
                //startActivity(intent);
            }
        });


        btnLupapass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,LupaPassword.class);
                startActivity(intent);
            }
        });
    }

    private void user_login(){
        final String Email = email.getText().toString().trim();
        final String Password = password.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();;
                            startActivity(new Intent(getApplicationContext(), MenuUtama.class));
                        }else{
                            Toast.makeText(Login.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
