package sheridan.runze.assignment1.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleNoResourceFoundException(NoResourceFoundException ex) {

        ModelAndView mav = new ModelAndView("error-404");
        mav.addObject("method", ex.getHttpMethod());
        mav.addObject("path", ex.getResourcePath());

        log.error("404 Error: {}", ex.getResourcePath());
        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {

        ModelAndView mav = new ModelAndView("general-error");
        mav.addObject("exception", ex.getClass().getSimpleName());
        mav.addObject("message", ex.getMessage());

        log.error("Server Error", ex);
        return mav;
    }
}
