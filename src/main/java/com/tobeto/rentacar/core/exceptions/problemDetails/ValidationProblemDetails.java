package com.tobeto.rentacar.core.exceptions.problemDetails;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
public class ValidationProblemDetails extends ProblemDetails{
    private Map<String , String> errors ;
    public ValidationProblemDetails (){
        setTitle( "Validation Rule Violation" ) ;
        setDetail( "Validation Problem" ) ;
        setType( "http://mydomain.com/exceptions/validation" ) ;
        setStatus(HttpStatus.BAD_REQUEST.toString()) ;
    }


}
