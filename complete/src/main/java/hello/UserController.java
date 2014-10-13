package hello;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;



@RequestMapping("api/v1/users")
@RestController
public class UserController {

    private final AtomicLong user_counter = new AtomicLong();
    private final AtomicLong card_counter = new AtomicLong();
    private final WalletApp myWallet = new WalletApp();

    @RequestMapping(method = RequestMethod.POST)
    public User createUsers(@Valid @RequestBody User user) {
        user.setUser_id("u-" + user_counter.incrementAndGet());
        user.setCreated_at(new Date().toString());
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

    @RequestMapping (value = "/{id}/idcards", method = RequestMethod.POST)
    public IdCards createIdCard(@PathVariable String id,
                            @RequestParam (value = "card_name", required = false, defaultValue = "SJSU") String card_name,
                            @RequestParam (value = "card_number", required = false, defaultValue = "1234") String card_number,
                            @RequestParam (value = "expiration_date", required = false, defaultValue = "2001-11-12") String expiration_date) {
        long idLong = Long.parseLong(id);
        return new IdCards(idLong, card_counter.incrementAndGet(), card_name, Long.parseLong(card_number), expiration_date);
    }

//    @RequestMapping (value = "/{user_id}/idcards", method = RequestMethod.GET)
//    public IdCards getAllIDCards(@PathVariable String user_id) {
//       return new IdCards(Long.parseLong(user_id));
//    }
//
//    @RequestMapping (value = "/users/{user_id}/idcards/{card_id}", method = RequestMethod.DELETE)
//    public IdCards deleteCard(@PathVariable String user_id, String card_id) {
//        return new IdCards(Long.parseLong(user_id), Long.parseLong(card_id));
//    }



}
