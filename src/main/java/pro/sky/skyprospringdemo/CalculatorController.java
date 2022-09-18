package pro.sky.skyprospringdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    @GetMapping()
    public String calculate() {
        return "hello";
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam(name = "num1", required = false) Integer a,
                      @RequestParam(name = "num2", required = false) Integer b) {
        if(a == null || b == null) return "Один из параметров не введен!";
        int add = calculatorService.add(a, b);
        return String.valueOf(add);
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer a,
                        @RequestParam(name = "num2", required = false) Integer b) {
        if(a == null || b == null) return "Один из параметров не введен!";
        int minus = calculatorService.minus(a, b);
        return String.valueOf(minus);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer a,
                           @RequestParam(name = "num2", required = false) Integer b) {
        if(a == null || b == null) return "Один из параметров не введен!";
        int multiply = calculatorService.multiply(a, b);
        return String.valueOf(multiply);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer a,
                         @RequestParam(name = "num2", required = false) Integer b) {
        if(a == null || b == null) return "Один из параметров не введен!";
        if(b == 0) return "На ноль делить нельзя!";
        double divide = calculatorService.divide(a, b);
        return String.valueOf(divide);
    }
}
