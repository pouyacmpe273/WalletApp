package hello;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by pjafaria on 9/24/2014.
 */
public class Users {


    private static long id;
    private static   String email;
    private static   String password;

//    private final Map<Integer k, Object v > = new MultiValueMap<Integer k, Object v>;
    private static   Map<Long, List<String>> map = new HashMap<Long, List<String>>();
    private List<String> values = new ArrayList<String>();
    private List<String> tempValues = new ArrayList<String>();




    public Users(long id, String email, String password, String restMethod) {
        this.id = id;
        this.email = email;
        this.password = password;
        values.add(email);
        values.add(password);
        if ( restMethod == "post" ) {
            map.put(id, values);
        }
        else {
            map.get(id).clear();
            map.put(id, values);
        }
    }

    public Users (long id) {

        tempValues = map.get(id);
        this.id = id;
        this.email = tempValues.get(0);
        this.password = tempValues.get(1);

    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() { return password;}

    public String getCreated_at () { return new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());}

    public static int getMapSize() {
        return map.size();
    }


}
