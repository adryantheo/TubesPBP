package kelompokd.com.sponsorship;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText email;
    EditText password;
    EditText cpassword;
    CheckBox role1;
    CheckBox role2;
    Button btnSingUp;
    Button btnLogin;
    FirebaseAuth mAuth;
    DatabaseReference mdatabase;
    String Username, Email, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText) findViewById(R.id.username);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        cpassword=(EditText) findViewById(R.id.cpassword);
        role1=(CheckBox) findViewById(R.id.role1);
        role2=(CheckBox) findViewById(R.id.role2);
        btnSingUp=(Button) findViewById(R.id.btnSignUp);
        btnLogin=(Button) findViewById((R.id.btnLogin));

        mdatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        mAuth = FirebaseAuth.getInstance();

        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==btnSingUp){
                    UserRegister();
                }
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
            }
        });
    }

    private void UserRegister(){
        Username = username.getText().toString().trim();
        Email = email.getText().toString().trim();
        Password = password.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()){
                   sendEmailVerification();
                   OnAuth(task.getResult().getUser());
                   mAuth.signOut();
               }else{
                   Toast.makeText(MainActivity.this, "Gagal Daftar",Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    private void sendEmailVerification(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(MainActivity.this,"Silahkan Cek Email Untuk Verifikasi",Toast.LENGTH_SHORT).show();
                        FirebaseAuth.getInstance().signOut();
                    }
                }
            });
        }
    }

    private void OnAuth(FirebaseUser user){
        createAnewUser(user.getUid());
    }

    private void createAnewUser(String uid){
        User user = BuildNewUser();
        mdatabase.child(uid).setValue(user);
    }

    private User BuildNewUser(){
        return new User(
                getDisplayName(),
                getUserEmail(),
                new Date().getTime()
        );
    }

    public String getDisplayName(){
        return Username;
    }

    public String getUserEmail(){
        return Email;
    }

}
