package ru.bash.jopka.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.bash.jopka.Controller.ResponseBuilder;
import ru.bash.jopka.Controller.base.res.BaseRes;
import ru.bash.jopka.Controller.base.support.ResultDto;
import ru.bash.jopka.Controller.register.dto.RegisterRequest;
import ru.bash.jopka.database.model.JpaUser;
import ru.bash.jopka.database.model.Organization;
import ru.bash.jopka.database.model.Role;
import ru.bash.jopka.database.repository.OrganizationRepository;
import ru.bash.jopka.database.repository.RoleRepository;
import ru.bash.jopka.database.repository.UserRepository;
import ru.bash.jopka.mapper.Mapper;
import ru.bash.jopka.service.UserService;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public static final String ROLE_USER = "ROLE_USER";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final OrganizationRepository organizationRepository;

    @Override
    public BaseRes registerUser(RegisterRequest request) {
        BaseRes response = new BaseRes();

        if (userRepository.findByUserName(request.getUserName()) != null) {
            ResultDto resultDto = new ResultDto();
            resultDto.setCode(HttpStatus.BAD_REQUEST.toString());
            resultDto.setMessageUser("Пользователь с именем " + request.getUserName() + " уже существует!");
            response.setResult(resultDto);
            return response;
        }

        JpaUser jpaUser = Mapper.toJpa(request);
        Optional<Role> roleOptional = roleRepository.findById(request.getRoleId());
        Organization organization = organizationRepository.getReferenceById(request.getOrganizationId());
        jpaUser.setOrganization(organization);
        if(roleOptional.isPresent()){
            jpaUser.setRoles(Collections.singleton(roleOptional.get()));
            userRepository.save(jpaUser);
            return ResponseBuilder.buildOkBaseRes();
        } else return ResponseBuilder.buildRoleNotFound();

    }
}
