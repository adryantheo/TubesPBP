package kelompokd.com.sponsorship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuEvent extends AppCompatActivity {

    ImageView out;
    ImageView Upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_event);

        out=(ImageView) findViewById(R.id.out);
        Upload=(ImageView) findViewById(R.id.Upload);

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuEvent.this,UploadEvent.class);
                startActivity(intent);
            }
        });

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuEvent.this,MenuUtama.class);
                startActivity(intent);
            }
        });
    }
}
