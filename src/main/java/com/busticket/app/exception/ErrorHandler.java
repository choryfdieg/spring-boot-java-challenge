package com.busticket.app.exception;

import com.busticket.app.response.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(value = {"com.busticket.app.controller"})
@Validated
public class ErrorHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle BookingNotFound exception.
     * @param ex the BookingNotFoundException
     * @return a formatted Result Message
     */
    @ExceptionHandler(BookingNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected RestResponse<Object> handleBookingNotFoundException(final BookingNotFoundException ex) {

        final RestResponse<Object> response = new RestResponse<>();
        response.setFailure();
        response.setDescription(ex.getMessage());
        response.setCode(100);
        return response;

    }

    /**
     * Handle BookingSave exception.
     * @param ex the BookingSaveException
     * @return a formatted Result Message
     */
    @ExceptionHandler(BookingSaveException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected RestResponse<Object> handleBookingSaveException(final BookingSaveException ex) {

        final RestResponse<Object> response = new RestResponse<>();
        response.setFailure();
        response.setDescription(ex.getMessage());
        response.setCode(101);
        return response;

    }

    /**
     * Handle BookingDelete exception.
     * @param ex the BookingDeleteException
     * @return a formatted Result Message
     */
    @ExceptionHandler(BookingDeleteException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected RestResponse<Object> handleBookingDeleteException(final BookingDeleteException ex) {

        final RestResponse<Object> response = new RestResponse<>();
        response.setFailure();
        response.setDescription(ex.getMessage());
        response.setCode(103);
        return response;

    }

    /**
     * Handle IllegalArgument exception.
     * @param ex the IllegalArgumentException
     * @return a formatted Result Message
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected RestResponse<Object> handleBookingDeleteException(final IllegalArgumentException ex) {

        final RestResponse<Object> response = new RestResponse<>();
        response.setFailure();
        response.setDescription(ex.getMessage());
        response.setCode(104);
        return response;

    }

}