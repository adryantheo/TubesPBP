package kelompokd.com.sponsorship;

public class User {
    private String Username;
    private String Email;
    private String Password;

    public String getUsername() {
        return Username;
    }

    public void  setUsername(String Username){this.Username=Username;}


    public String getEmail() {
        return Email;
    }

    public void  setEmail(String Email){this.Email=Email;}

    public String getPassword(){
        return Password;
    }

    public void  setPassword(String Password){this.Password=Password;}


    public User(String username,String email, String password){
        this.Username=username;
        this.Email=email;
        this.Password=password;


    }





}
