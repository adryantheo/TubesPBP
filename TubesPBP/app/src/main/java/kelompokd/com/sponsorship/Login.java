package kelompokd.com.sponsorship;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText username;
    EditText password;
    Button btnLogin;
    Button btnLupapass;
    String Username;
    String Password;
    FirebaseUser mUser;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    public static final String TAG="LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password) ;
        btnLupapass=(Button) findViewById(R.id.btnLupaPass);
        btnLogin=(Button) findViewById(R.id.btnLogin);
        mAuth = FirebaseAuth.getInstance();
        mUser = FirebaseAuth.getInstance().getCurrentUser();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = username.getText().toString();
                final String Passowrd = password.getText().toString();

                mAuth.signInWithEmailAndPassword(Username,Passowrd )
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                               if(!task.isSuccessful()){
                                   Toast.makeText(Login.this,"Ada Error", Toast.LENGTH_LONG).show();
                               }else{
                                   Intent intent=new Intent(Login.this,MenuUtama.class);
                                   startActivity(intent);
                               }
                            }
                        });


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
}
