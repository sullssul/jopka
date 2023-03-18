package ru.bash.jopka.Controller.base.support;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;


@Schema(description = "структура объекта",
        example = "{\n" +
                "    \"code\": \"OK\",\n" +
                "    \"messageUser\": \"Выполнено успешно\"\n" +
                "}")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ResultDto {

    @Schema(maxLength = 520, example = "OK", pattern = "^(.*){520}$", description = "Символьный код результата обработки запроса")
    private String code;
    @Schema(maxLength = 520, example = "OK", pattern = "^(.*){520}$", description = "Текст с информацией об отработке запроса")
    private String messageUser;
    @Schema(maxLength = 520, example = "OK", pattern = "^(.*){520}$", description = "Детальное описание ответа")
    private String description;
    @Schema(maxLength = 520, example = "OK", pattern = "^(.*){520}$", description = "Система вернувшая ответ")
    private String messageSystem;

    public ResultDto(String code, String messageUser)
    {
//        if (!Constants.OK.equalsIgnoreCase(code))
//            throw new Exception(code, HttpStatus.BAD_REQUEST, messageUser, null);//todo
        this.code = code;
        this.messageUser = prepareString(messageUser);
    }

    public ResultDto(String code, String messageUser, String description)
    {
        this.code = code;
        this.messageUser = prepareString(messageUser);
        this.description = prepareString(description);
    }

    public ResultDto(String code, String messageUser, String description, String messageSystem)
    {
        this.code = code;
        this.messageUser = prepareString(messageUser);
        this.description = prepareString(description);
        this.messageSystem = prepareString(messageSystem);
    }

    private String prepareString(String value){
        if (StringUtils.hasText(value) && value.length() > 250){
            return value.substring(0, 249);
        }
        return value;
    }

}
