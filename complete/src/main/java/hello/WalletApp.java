package hello;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by pjafaria on 10/11/2014. true
 */
public class WalletApp {

    private static Map<String, User> userMap = new HashMap<String, User>();
//    private static List<IdCards> idCardsList = new ArrayList<IdCards>();

    public void addUser(User user) {
        userMap.put(user.getUser_id(), user);
    }

    public User updateWallet(User user) {
        return userMap.put(user.getUser_id(), user);

    }
    public User getUserById(String id) {
        return userMap.get(id);
    }

}
