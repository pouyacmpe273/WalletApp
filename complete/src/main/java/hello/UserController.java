package hello;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicLong;


/*
Working: User:create, view, update
 */

@RequestMapping("api/v1/users")
@RestController
public class UserController {

    private final AtomicLong user_counter = new AtomicLong();
    private final AtomicLong card_counter = new AtomicLong();
    private final WalletApp myWallet = new WalletApp();

    @RequestMapping(method = RequestMethod.POST)
    public User createUsers(@Valid @RequestBody User user) {
        user.setUser_id("u-" + user_counter.incrementAndGet());
        user.setCreated_at(new SimpleDateFormat("yy-MM-dd - HH:mm").format(Calendar.getInstance().getTime()));
        myWallet.addUser(user);
        return user;
    }

    @RequestMapping (value = "/{id}",   method = RequestMethod.GET )
    public User getUser(@PathVariable String id) {
        return myWallet.getUserById(id);
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        user.setUser_id(id);
        user.setCreated_at(myWallet.getUserById(id).getCreated_at());
//        myWallet.userMap.remove(id);
        return myWallet.updateWallet(user);
    }

    @RequestMapping (value = "/{user_id}/idcards", method = RequestMethod.POST)
    public IdCard createIdCard(@RequestBody IdCard idCard, @PathVariable String user_id) {

        idCard.setCard_id("c-" + card_counter.incrementAndGet());
        return myWallet.addCardToUser(user_id, idCard);
    }

    @RequestMapping (value = "/{user_id}/idcards", method = RequestMethod.GET)
    public java.util.Collection<IdCard> getAllIDCards(@PathVariable String user_id) {
       return myWallet.getCardList(user_id);
    }
//
//    @RequestMapping (value = "/users/{user_id}/idcards/{card_id}", method = RequestMethod.DELETE)
//    public IdCards deleteCard(@PathVariable String user_id, String card_id) {
//        return new IdCards(Long.parseLong(user_id), Long.parseLong(card_id));
//    }



}
