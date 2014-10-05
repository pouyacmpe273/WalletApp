package hello;


import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * Created by pjafaria on 10/4/2014.
 */
public class IdCards {


    private static long id;
    private static long card_number;
    private static Date expiration_date;
    private static String card_name;

    //    private final Map<Integer k, Object v > = new MultiValueMap<Integer k, Object v>;
    private static MultiMap<Long, ArrayList<Object>> map = new MultiValueMap<Long, ArrayList<Object>>();
    private List<ArrayList<Object>> allCards = new ArrayList<ArrayList<Object>>();
    private ArrayList<Object> aSingleCard = new ArrayList<Object>();

    public IdCards(long id, String card_name, long card_number, Date expiration_date) {
        this.id = id;
        this.card_name = card_name;
        this.card_number = card_number;
        this.expiration_date = expiration_date;

        aSingleCard.add(card_name);
        aSingleCard.add(card_number);
        aSingleCard.add(expiration_date);
        map.put(id, aSingleCard);
    }

    public IdCards(long id) {
        this.id = id;
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

      public Object getMapValues() {

          return map.get(this.id);
      }

}
