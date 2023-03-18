package ru.bash.jopka.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bash.jopka.Controller.base.res.BaseRes;
import ru.bash.jopka.Controller.register.dto.RegisterRequest;
import ru.bash.jopka.service.UserService;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    public static final String APPLICATION_JSON_VALUE = "application/json;charset=UTF-8";
    private final UserService userService;
   @PostMapping(value = "/register" )
    public ResponseEntity<BaseRes> registerUser(@RequestBody RegisterRequest request){
        return ResponseBuilder.build(userService.registerUser(request));
    }

}
