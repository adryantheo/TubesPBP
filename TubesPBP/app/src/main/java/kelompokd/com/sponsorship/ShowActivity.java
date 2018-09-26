package kelompokd.com.sponsorship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowActivity extends AppCompatActivity {
    private List<JSONObject> mListUser = new ArrayList<>();
    private RecyclerView recyclerView;
    public RecycleAdapter recycleAdapter;
    private RecyclerView.LayoutManager layoutManager;
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recycleAdapter = new RecycleAdapter(this,mListUser);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recycleAdapter);
        setRecycleView();
    }

    public void setRecycleView(){
        Retrofit.Builder builder=new Retrofit
                .Builder()
                .baseUrl("https://pbpdatabase.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();
        UserApi apiClient=retrofit.create(UserApi.class);
        Call<JSONObject> studentDACall=apiClient.getUser();

        studentDACall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                recycleAdapter.notifyDataSetChanged();
                recycleAdapter=new RecycleAdapter(ShowActivity.this,response.body().getResult());
                recyclerView.setAdapter(recycleAdapter);
                Toast.makeText(ShowActivity.this,"Welcome",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {

            }
        });
    }
    */
}
