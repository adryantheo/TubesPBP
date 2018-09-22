package kelompokd.com.sponsorship;

public class User {
    private String DisplayUsername;
    private String Email;
    private String Password;


    public User(String username, String email, long time){};
    public User(String displayUsername,String email, String password){
        this.DisplayUsername=displayUsername;
        this.Email=email;
        this.Password=password;


    }


    public String getUsername() {
        return DisplayUsername;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword(){
        return Password;
    }


}
