package hello;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by pjafaria on 9/24/2014.
 */
public class Users {


    private final long id;
    private final String email;
    private final String password;

    public Users(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }


    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() { return password;}

    public String getCreated_at () { return new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());}


}
