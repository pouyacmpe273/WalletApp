package hello;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by pjafaria on 9/24/2014.
 */
@RequestMapping("/Users")
@RestController

public class UsersController {

    private final AtomicLong counter = new AtomicLong();
    @RequestMapping(method = RequestMethod.POST)
    public Users users(@RequestParam(value="email", required=false, defaultValue="myemail@email.com") String name,
                       @RequestParam(value="password", required=false, defaultValue="secretpass") String password) {
        return new Users(counter.incrementAndGet(),
                name, password);
    }

    @RequestMapping (value = "/{id}",   method = RequestMethod.GET )
    public Users usersTwo(@PathVariable String id) {
        long idLong = Long.parseLong(id);
        return new Users (idLong);
    }


}
