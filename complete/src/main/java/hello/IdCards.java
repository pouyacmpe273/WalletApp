package hello;


import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.util.*;

public class IdCards {


    private static long user_id;
    private static long card_id;
    private static long card_number;
    private static Date expiration_date;
    private static String card_name;


    private ArrayList<Object> aSingleCard = new ArrayList<Object>();
    private Map<Long, ArrayList<Object>> oneCard = new HashMap<Long, ArrayList<Object>>();
    private static MultiMap<Long, Map<Long, ArrayList<Object>>> allCards = new MultiValueMap<Long, Map<Long, ArrayList<Object>>>();

//    private final Map<Integer k, Object v > = new MultiValueMap<Integer k, Object v>;
//    private static MultiMap<Long, ArrayList<Object>> map = new MultiValueMap<Long, ArrayList<Object>>();
//    private List<ArrayList<Object>> allCards = new ArrayList<ArrayList<Object>>();

    public IdCards(long user_id, long card_id, String card_name, long card_number, Date expiration_date) {
        this.user_id = user_id;
        this.card_id = card_id;
        this.card_name = card_name;
        this.card_number = card_number;
        this.expiration_date = expiration_date;
        this.user_id = user_id;

        aSingleCard.add(this.card_name);
        aSingleCard.add(this.card_number);
        aSingleCard.add(this.expiration_date);
        oneCard.put(this.card_id, aSingleCard);
        allCards.put(this.user_id, oneCard);

//      oneCard.put(id, card_name);
//      oneCard.put(id, card_number);
//      oneCard.put(id, expiration_date);

    }

    public IdCards(long user_id) {
        this.user_id = user_id;
    }

    public IdCards(long user_id, long card_id) {
        this.user_id = user_id;
        this.card_id = card_id;
    }

    public Object getAllCards() { return allCards.get(this.user_id); }

    public Object deleteCard() {

    }


//    public String getCard_name() {
//        return card_name;
//    }
//
//    public long getCard_number() {
//        return card_number;
//    }
//
//    public Date getExpiration_date() {
//
//        return expiration_date;
//    }
//    public int getMapLength() {
//        return map.size();
//    }

//      public Object getMapValues() {
//
//          return map.get(this.id);
//      }

}
