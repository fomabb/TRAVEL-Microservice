package com.iase24.travel_diary_youtube.controller;

import com.iase24.travel_diary_youtube.model.out.ErrorRestOut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/v1.0/test/")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Тестовые операции", description = "Получение результатов для проверки работоспособности")
public class TestController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Получить тестовый ответ")
    @ApiResponse(responseCode = "200", description = "Операция выполнена успешно")
    @ApiResponse(responseCode = "400", description = "Некоректный формат запроса",
            content = @Content(schema = @Schema(implementation = ErrorRestOut.class)))
    @ApiResponse(responseCode = "500", description = "Внутренняя сервера",
            content = @Content(schema = @Schema(implementation = ErrorRestOut.class))
    )
    public String getTestMessage() {
        return "Test message from service " + new Date();
    }
}
