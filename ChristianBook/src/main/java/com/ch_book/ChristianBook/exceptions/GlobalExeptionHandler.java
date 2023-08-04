package com.ch_book.ChristianBook.exceptions;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExeptionHandler {

    public static final String SOMETHING_WENT_WRONG = "Something Went Wrong.";

    public static final String INVALID_DATA = "Invalid Data.";

    public static final String UNAUTHORIZED_ACCESS = "Unauthorized access.";

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus) {
        return new ResponseEntity<String>("{\"message\":\"" + responseMessage + "\"}", httpStatus);
    }
	
	
}
