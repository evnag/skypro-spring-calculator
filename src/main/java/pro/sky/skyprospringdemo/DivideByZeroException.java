package pro.sky.skyprospringdemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DivideByZeroException extends RuntimeException {
    public DivideByZeroException(String s) {
        super(s);
    }
}
