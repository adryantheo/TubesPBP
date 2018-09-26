package kelompokd.com.sponsorship;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.List;


public class RecycleAdapter {

    private Context context;
    private List<JSONObject> result;
/*
    private RecycleAdapter(Context context, List<JSONObject> result) {
        this.context = context;
        this.result = result;
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_recycle_adapter, viewGroup, false);
        final MyViewHolder holder=new MyViewHolder(v);

        return holder;
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        JSONObject user = result.get(i);
        myViewHolder.mUsername.setText(user.getUsername());
        myViewHolder.mEmail.setText(user.getEmail());
    }

    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mUsername;
        private TextView mEmail;

        public MyViewHolder(View itemView){
            super(itemView);
            mUsername = itemView.findViewById(R.id.mUsername);
            mEmail = itemView.findViewById(R.id.mEmail);
        }

        public void onClick(View view) {
            Toast.makeText(context,"Hey You Clicked On Me", Toast.LENGTH_SHORT).show();
        }
    }
    */

}
