package kelompokd.com.sponsorship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuPerusahaan extends AppCompatActivity {

    ImageView out;
    ImageView Home;
    ImageView Upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_perusahaan);

        out=(ImageView) findViewById(R.id.out);
        Home=(ImageView) findViewById(R.id.Home);
        Upload=(ImageView) findViewById(R.id.Upload);

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuPerusahaan.this,MenuUtama.class);
                startActivity(intent);
            }
        });

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuPerusahaan.this,UploadPerusahaan.class);
                startActivity(intent);
            }
        });
    }
}
