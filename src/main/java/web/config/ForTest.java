package web.config;

import org.springframework.stereotype.Component;
import web.model.User;
import web.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class ForTest {

    private UserService userService;

    public ForTest(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void abc(){
        userService.save(new User("Petr","Petrov", "Petrov@mail.ru","456"));
        userService.save(new User("Semen", "Semenov", "Semenov@mail.ru", "4862"));
    }


}
