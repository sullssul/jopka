package ru.bash.jopka.Controller.base.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import ru.bash.jopka.Controller.base.support.ResultDto;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseRes {

    private ResultDto result;

}
