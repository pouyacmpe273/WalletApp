package hello;

import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.concurrent.atomic.AtomicLong;


/**
 * Created by pjafaria on 9/24/2014.
 */
@RequestMapping("/Users")
@RestController

public class UsersController {

    private final AtomicLong counter = new AtomicLong();
    @RequestMapping(method = RequestMethod.POST)
    public Users users(@RequestParam(value="email", required=false, defaultValue="myemail@email.com") String email,
                       @RequestParam(value="password", required=false, defaultValue="secretpass") String password) {
        return new Users(counter.incrementAndGet(),
                email, password, "post");
    }

    @RequestMapping (value = "/{id}",   method = RequestMethod.GET )
    public Users getUser(@PathVariable String id) {
        long idLong = Long.parseLong(id);
        return new Users (idLong);
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.PUT)
    public Users updateUser(@PathVariable String id,
                            @RequestParam (value = "email", required = false, defaultValue = "myemail@gmail.com") String email,
                            @RequestParam (value = "password", required = false, defaultValue = "passwordYall") String password) {
        long idLong = Long.parseLong(id);
        return new Users(idLong, email, password, "put");
    }

    @RequestMapping (value = "/{id}/idcards", method = RequestMethod.POST)
    public IdCards createIdCard(@PathVariable String id,
                            @RequestParam (value = "card_name", required = false, defaultValue = "SJSU") String card_name,
                            @RequestParam (value = "card_number", required = false, defaultValue = "1234") String card_number,
                            @RequestParam (value = "expiration_date", required = false, defaultValue = "2001-11-12") String expiration_date) {
        long idLong = Long.parseLong(id);
        return new IdCards(idLong, card_name, Long.parseLong(card_number), Date.valueOf(expiration_date) );
    }

    @RequestMapping (value = "/{id}/idcards", method = RequestMethod.GET)
    public IdCards getAllIDCards(@PathVariable String id) {
       return new IdCards(Long.parseLong(id));
    }


}
