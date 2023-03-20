package ru.bash.jopka.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.bash.jopka.Controller.ResponseBuilder;
import ru.bash.jopka.Controller.base.res.BaseRes;
import ru.bash.jopka.Controller.base.support.ResultDto;
import ru.bash.jopka.Controller.register.dto.RegisterRequest;
import ru.bash.jopka.business.user.repository.jpa.JpaUser;
import ru.bash.jopka.database.model.Organization;
import ru.bash.jopka.database.model.Role;
import ru.bash.jopka.database.repository.OrganizationRepository;
import ru.bash.jopka.database.repository.RoleRepository;
import ru.bash.jopka.business.user.repository.jpa.JpaUserRepository;
import ru.bash.jopka.mapper.Mapper;
import ru.bash.jopka.service.UserService;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public static final String ROLE_USER = "ROLE_USER";
    private final JpaUserRepository userRepository;
    private final RoleRepository roleRepository;

    private final OrganizationRepository organizationRepository;

    @Override
    public BaseRes registerUser(RegisterRequest request) {
        BaseRes response = new BaseRes();

        if (userRepository.findByEmail(request.getEmail()) != null) {
            ResultDto resultDto = new ResultDto();
            resultDto.setCode(HttpStatus.BAD_REQUEST.toString());
            resultDto.setMessageUser("Пользователь с email " + request.getEmail() + " уже существует!");
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
