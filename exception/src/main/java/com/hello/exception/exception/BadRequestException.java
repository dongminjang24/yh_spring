package com.hello.exception.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "error.bad")
//@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "잘못된 요청 오류")
public class BadRequestException extends RuntimeException {



}
