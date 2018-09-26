package kelompokd.com.sponsorship;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.EventListener;

public class ProfilUser extends AppCompatActivity {

    TextView username;
    TextView emailU;
    TextView password;
    Button btnEditU;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    private String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_user);

        username=(TextView) findViewById(R.id.username);
        emailU=(TextView) findViewById(R.id.emailU);
        password=(TextView) findViewById(R.id.password);
        btnEditU=(Button) findViewById(R.id.btnEditU);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(ProfilUser.this, "Signed",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ProfilUser.this, "Belum Login",Toast.LENGTH_SHORT).show();
                }
            }

        };

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




/*
        mDatabase=FirebaseDatabase.getInstance();
       mRef=mDatabase.getReference("User").child(mAuth.getCurrentUser().getUid());

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot ds = null;
                String username1 = ds.getValue(User.class).getUsername();
                Toast.makeText(ProfilUser.this, username1, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

*/

        btnEditU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfilUser.this,EditProfilUser.class);
                startActivity(intent);
            }
        });
    }

    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(ds.child(userID).getValue(UserInfo.class).getUsername());
            userInfo.setEmail(ds.child(userID).getValue(UserInfo.class).getEmail());
            userInfo.setPassword(ds.child(userID).getValue(UserInfo.class).getPassword());

            username.setText(userInfo.getUsername());
            emailU.setText(userInfo.getEmail());
            password.setText(userInfo.getPassword());
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop(){
        super.onStop();
        if(mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
