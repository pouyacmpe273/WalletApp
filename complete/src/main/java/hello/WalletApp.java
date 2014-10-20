package hello;

import org.apache.commons.collections4.map.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pjafaria on 10/11/2014. true
 */
public class WalletApp {

//    private static List<IdCard> idCardsList = new ArrayList<IdCard>();


    public static Map<String, User> userMap = new HashMap<String, User>();
    public static MultiValueMap<String, IdCard> idCardMap = new MultiValueMap<String, IdCard>();

    public void addUser(User user) {
        userMap.put(user.getUser_id(), user);
    }

    public User updateWallet(User user) {
        User updatedUser = (User) userMap.put(user.getUser_id(), user);
        updatedUser = (User) userMap.get(user.getUser_id());
        return updatedUser;
    }

    public User getUserById(String user_id) {
        return userMap.get(user_id);
    }

    public IdCard addCardToUser(String user_id, IdCard idCard) {
        idCardMap.put(user_id, idCard);
        return idCard;
    }

    public java.util.Collection<IdCard> getCardList(String user_id) {
//        List<IdCard> allCards = new ArrayList<IdCard>();
        return  idCardMap.getCollection(user_id);
    }

}
