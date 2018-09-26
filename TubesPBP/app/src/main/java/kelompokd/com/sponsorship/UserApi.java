package kelompokd.com.sponsorship;

import android.widget.EditText;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import org.json.JSONObject;

public interface UserApi {

    @GET("tampil.php")
    Call<JSONObject> getUser();

    @GET("tampil_perusahaan.php")
    Call<JSONObject> getUserPerusahaan();

    @POST("tambah.php")
    @FormUrlEncoded
    Call<JSONObject> regUser(@Field("username") String username,
                         @Field("email") String email,
                         @Field("password") String password

    );


    @POST("tambah_perusahaan.php")
    @FormUrlEncoded
    Call<JSONObject> regUserPerusahaan(@Field("username") String username,
                         @Field("email") String email,
                         @Field("phone") String phone,
                         @Field("alamat") String alamat,
                         @Field("password") String password

    );


}