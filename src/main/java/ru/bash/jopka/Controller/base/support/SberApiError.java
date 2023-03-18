package ru.bash.jopka.Controller.base.support;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "структура объекта",
        name = "sberapiError_type",
        example = "{\n" +
                "  \"httpCode\": \"401\",\n" +
                "  \"httpMessage\": \"Error\",\n" +
                "  \"moreInformation\": \"Error\"\n" +
                "}")
@Data
public class SberApiError {
    @Schema(maxLength = 3, example = "401", pattern = "^[0-9]{1,3}$", description = "Код ошибки", required = true)
    private String httpCode;
    @Schema(maxLength = 50, example = "Error", pattern = "^(.*)$", description = "Описание ошибки", required = true)
    private String httpMessage;
    @Schema(maxLength = 50, example = "Error", pattern = "^(.*)$", description = "Дополнительная информация", required = true)
    private String moreInformation;
}
