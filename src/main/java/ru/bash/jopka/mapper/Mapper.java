package ru.bash.jopka.mapper;


import ru.bash.jopka.Controller.register.dto.RegisterRequest;
import ru.bash.jopka.database.model.JpaUser;

public class Mapper {

    public static JpaUser toJpa(RegisterRequest request) {
        JpaUser jpaUser  = new JpaUser();
        jpaUser.setEmail(request.getEmail());
        jpaUser.setBirthday(request.getBirthday());
        jpaUser.setUserName(request.getUserName());
        jpaUser.setSecondName(request.getSecondName());
        jpaUser.setFirstName(request.getFirstName());
        jpaUser.setFatherName(request.getFatherName());
        jpaUser.setPhone(request.getPhone());
        jpaUser.setPassword(request.getPassword());
        return jpaUser;
    }
}
