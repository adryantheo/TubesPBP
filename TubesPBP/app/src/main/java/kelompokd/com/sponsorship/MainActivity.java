package kelompokd.com.sponsorship;

import android.app.ProgressDialog;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth.AuthStateListener mAuthListener;

   private EditText mUsername;
    private EditText mEmail;
    private EditText mPassword;
    private EditText cpassword;

    private Button btnSingUp;
    private Button btnLogin;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private ProgressDialog mDialog;
    private static final String TAG_SUCCESS="success";
    private static final String TAG_MESSAGE="Message";
    private String url = "https://pbpdatabase.000webhostapp.com/tambah.php";



    String Username, Email, Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        JsonParser jsonParser = new JsonParser();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user=database.getReference("User");
        mUsername=(EditText) findViewById(R.id.username);
        mEmail=(EditText) findViewById(R.id.emailU);
        mPassword=(EditText) findViewById(R.id.password);
        cpassword=(EditText) findViewById(R.id.cpassword);

        btnSingUp=(Button) findViewById(R.id.btnSignUp);
        btnLogin=(Button) findViewById((R.id.btnLogin));


        if(mAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(),MenuUtama.class));
    }

        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRegister();

            }
        });




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });



    }

    private void onClickRegister(){
        final ProgressDialog mDialog = new ProgressDialog(MainActivity.this);
        mDialog.setMessage("Please Wating...");
        mDialog.show();

/*
        Gson gson = new GsonBuilder().setDateFormat("YYYY-MM-DD").create();
        Retrofit.Builder builder = new Retrofit
                .Builder()
                .baseUrl("https://pbpdatabase.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create(gson));

        Retrofit retrofit = builder.build();
        UserApi userApi = retrofit.create(UserApi.class);
        userApi.regUser(mUsername.getText().toString(),mEmail.getText().toString(),mPassword.getText().toString());
*/

        //Call<JSONObject> UserCall= userApi.regUser(mUsername.getText().toString(),mEmail.getText().toString(),mPassword.getText().toString());










                /*

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(username.getText().toString()).exists()){
                            mDialog.dismiss();
                            Toast.makeText(MainActivity.this, "Username sudah digunakaan", Toast.LENGTH_SHORT).show();
                        }else{
                            mDialog.dismiss();
                            Toast.makeText(MainActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                            User user = new User(username.getText().toString(),mEmail.getText().toString(), password.getText().toString());
                            table_user.child(username.getText().toString()).setValue(user);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                */





        // Intent intent=new Intent(MainActivity.this,PendaftaranBerhasil.class);
        //startActivity(intent);

        register_user();
    }

    @Override
    public void onClick(View v) {
        if(v==btnSingUp){
            register_user();
        }else if(v==btnLogin){
            startActivity(new Intent(MainActivity.this, Login.class));
        }
    }

    private void register_user(){

        Username = mUsername.getText().toString();
        Email = mEmail.getText().toString();
        Password = mPassword.getText().toString();

        if(TextUtils.isEmpty(Email)){
            Toast.makeText(this,"Masukkan Email",Toast.LENGTH_LONG).show();
            return;
        } else if(TextUtils.isEmpty(Password)){
            Toast.makeText(this,"Masukkan Password",Toast.LENGTH_LONG).show();
        } else if(Password.length()<6){
            Toast.makeText(this,"Password Terlalu Pendek",Toast.LENGTH_LONG).show();
        }

       // mDialog.setMessage("Harap Tunggu...");
      //  mDialog.setCanceledOnTouchOutside(false);
      //  mDialog.show();


        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(Username,Email,Password);
                            mDatabase.getDatabase().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(MainActivity.this, "Sukses",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            sendEmailVerification();
//                            mDialog.dismiss();
                            OnAuth(task.getResult().getUser());
                            mAuth.signOut();
                            //finish();
                          // Log.d("mAuth", "onComplete" +task.getException().getMessage());
                            startActivity(new Intent(getApplicationContext(),Login.class));
                        }else{
                            Toast.makeText(MainActivity.this,"Registerasi Gagal",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    };

    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }

        };
    }

    private void sendEmailVerification(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    Toast.makeText(MainActivity.this,"Cek Email ",Toast.LENGTH_SHORT).show();
                    FirebaseAuth.getInstance().signOut();
                }
            });
        }
    }

    private void OnAuth(FirebaseUser user){
        createAnewUser(user.getUid());
    }

    private void createAnewUser(String uid){
        User user = BuildNewUser();
//        mDatabase.child(uid).setValue(user);
    }

    private User BuildNewUser(){
        return new User(
                getUsername(),
                getEmail(),
                getPassword()
                );
    }

    public String getUsername(){
        return Username;
    }

    public String getEmail(){
        return Email;
    }

    public String getPassword(){
        return Password;
    }


}
