package kelompokd.com.sponsorship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class UploadEvent extends AppCompatActivity {

    ImageView out;
    Button Upload;
    Button Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_event);

        out=(ImageView)findViewById(R.id.out);
        Upload=(Button)findViewById(R.id.Upload);
        Delete=(Button)findViewById(R.id.Delete);

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UploadEvent.this,MenuEvent.class);
                startActivity(intent);
            }
        });

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UploadEvent.this,MenuEvent.class);
                startActivity(intent);
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UploadEvent.this,MenuEvent.class);
                startActivity(intent);
            }
        });
    }
}
