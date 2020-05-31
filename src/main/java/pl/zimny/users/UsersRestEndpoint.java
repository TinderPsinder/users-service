package pl.zimny.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.zimny.model.Profile;
import pl.zimny.service.UsersService;

@RestController
public class UsersRestEndpoint {

    private UsersService usersService;

    // test endpoint
    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello from users service";
    }

    @PostMapping(path = "/register")
    public HttpStatus registerUser() {
        return usersService.registerUser();
    }

    @GetMapping(path ="/profile/{userId}")
   public Profile getUserProfile(@PathVariable Long userId){
        return usersService.getUserProfile(userId);
    }

    @PostMapping(path = "/report")
    public HttpStatus reportUser() {
        return usersService.reportUser();
    }

    // only for admins
    @PostMapping(path = "/mischief")
    public HttpStatus confirmMischief() {
        return usersService.confirmMischief();
    }
}
