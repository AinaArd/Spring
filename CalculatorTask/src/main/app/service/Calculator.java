package main.app.service;

import org.springframework.stereotype.Component;

@Component
public interface Calculator {
    double makeCalculation(Double firstDigit, String sign, Double secondDigit);
}
