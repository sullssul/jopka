package ru.bash.jopka.Controller;

import org.springframework.http.ResponseEntity;
import ru.bash.jopka.Controller.base.res.BaseRes;
import ru.bash.jopka.Controller.base.support.ResultDto;


public class ResponseBuilder {
    public static <T> ResponseEntity<T> build(T data) {
        return ResponseEntity.ok().body(data);
    }
    public static BaseRes buildOkBaseRes(){
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("OK");
        resultDto.setMessageUser("Пользователь успешно создан!");
        BaseRes res = new BaseRes();
        res.setResult(resultDto);
        return res;
    };

    public static BaseRes buildRoleNotFound(){
        return new BaseRes();//todo
    };
}
