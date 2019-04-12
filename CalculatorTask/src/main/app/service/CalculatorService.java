package main.app.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("calculator")
public class CalculatorService implements Calculator {
    @Override
    public double makeCalculation(Double firstDigit, String sign, Double secondDigit) {
        switch (sign) {
            case "+":
                return firstDigit + secondDigit;
            case "-":
                return firstDigit - secondDigit;
            case "*":
                return firstDigit * secondDigit;
            case "/":
                return firstDigit / secondDigit;
        }
        return 0;
    }
}
