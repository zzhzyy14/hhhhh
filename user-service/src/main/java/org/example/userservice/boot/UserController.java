package org.example.userservice.boot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author 缪嘉成
 */
@RestController
public class UserController {

    private static final List<User> USERS = List.of(
            new User("JohnDoe", "john@example.com"),
            new User("JaneDoe", "jane@example.com"),
            new User("Alice", "alice@example.com"),
            new User("Bob", "bob@example.com")
            );

    @GetMapping("/user")
    public User getUser(@RequestParam String username) {
        return USERS.stream()
                .filter(user -> user.username().equals(username))
                .findFirst()
                .orElse(null);
}

   @GetMapping("/users")
   public List<User> getUsersSortedByName() {
       return USERS.stream()
               .sorted((u1,u2) -> u1.username().compareTo(u2.username())
       )
               .collect(Collectors.toList());
   }
}