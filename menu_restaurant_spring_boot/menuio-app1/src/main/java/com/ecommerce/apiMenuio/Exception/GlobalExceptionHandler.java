/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.Exception;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author ateubohk
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GlobalExceptionHandler extends RuntimeException {
     private String message;

    public GlobalExceptionHandler(String message) {
        this.message = message;
    }
            
      public String getMessage() {
                return message;
            }
            public void setMessage(String message) {
                this.message = message;
            }
    
}
