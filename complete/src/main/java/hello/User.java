package hello;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pjafaria on 9/24/2014. true
 */
public class User {

    private String user_id;
    private String email;
    private String password;
    private String created_at;

    private static List<IdCard> idCardsList = new ArrayList<IdCard>();
//    private static Map<Long, List<String>> map = new HashMap<Long, List<String>>();
//    private List<String> values = new ArrayList<String>();
//    private List<String> tempValues = new ArrayList<String>();

    public User(String user_id, String email, String password, String created_at) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
    }

    public User () {
    }

    public String getUser_id() { return user_id; }

    public String getEmail() {
        return email;
    }

    public String getPassword() { return password;}

    public String getCreated_at () { return created_at;}

    public void  setUser_id (String user_id) {
        this.user_id = user_id;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated_at (String created_at) {
        this.created_at = created_at;
    }


    /*      end of setters and getters     */

}
