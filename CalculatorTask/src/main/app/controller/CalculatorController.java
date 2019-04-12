package main.app.controller;

import main.app.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(path = {"/calculator"})
public class CalculatorController {
    @Qualifier("calculatorService")
    @Autowired
    private Calculator calculator;

    @Autowired
    public CalculatorController(@Qualifier("calculator") Calculator calculator) {
        this.calculator = calculator;
    }

    @RequestMapping(method = RequestMethod.POST, params = {"first_digit", "sign", "second_digit"})
    public String calculate(ModelMap model, @RequestParam("first_digit") Double firstDigit,
                            @RequestParam("sign") String sign,
                            @RequestParam("second_digit") Double secondDigit) {
        double result = calculator.makeCalculation(firstDigit, sign, secondDigit);
        System.out.println(result);
        model.put("result", result);
        return showPage();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showPage(){
        return "calculator";
    }
}