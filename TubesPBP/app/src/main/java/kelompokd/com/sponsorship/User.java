package kelompokd.com.sponsorship;

public class User {
    String DisplayUsername;
    String Email;
    long createdAt;

    public User(){};
    public User(String displayUsername,String email,long createdAt){
        this.DisplayUsername=displayUsername;
        this.Email=email;
        this.createdAt=createdAt;
    }


    public String getUsername() {
        return DisplayUsername;
    }

    public String getEmail() {
        return Email;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}
