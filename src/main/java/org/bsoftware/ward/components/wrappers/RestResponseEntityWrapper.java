package org.bsoftware.ward.components.wrappers;

import org.bsoftware.ward.dto.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * RestResponseEntityWrapper provides Json headers automatically and controls dto response objects
 *
 * @author Rudolf Barbu
 * @version 1.0.0
 */
@Component
public class RestResponseEntityWrapper
{
    /**
     * Used as a bean, which already provides Json headers
     */
    private HttpHeaders httpHeaders;

    /**
     *  Wrapping Json headers, status and specified dto to ResponseEntity
     *
     * @param body object, which implements Dto interface
     * @param httpStatus object, which already provides Json headers
     * @return ResponseEntity object with Json headers and Dto
     */
    public <T extends Dto> ResponseEntity<?> wrap(T body, HttpStatus httpStatus)
    {
        return new ResponseEntity<>(body, httpHeaders, httpStatus);
    }

    /**
     * Used for autowiring necessary objects
     *
     * @param httpHeaders autowired HttpHeaders object
     */
    @Autowired
    public RestResponseEntityWrapper(HttpHeaders httpHeaders)
    {
        this.httpHeaders = httpHeaders;
    }
}