package com.example.InteractiveCalculator;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
@CrossOrigin(origins = "*")
public class CalculatorController {

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam String operation,
            @RequestParam double a,
            @RequestParam(required = false) Double b
    ) {
        switch(operation) {
            case "add":
                return String.valueOf(a + b);
            case "subtract":
                return String.valueOf(a - b);
            case "multiply":
                return String.valueOf(a * b);
            case "divide":
                if (b == 0) return "Error: Division by zero";
                return String.valueOf(a / b);
            case "mod":
                if (b == 0) return "Error: Modulo by zero";
                return String.valueOf(a % b);
            case "factorial":
                if (a < 0 || a != Math.floor(a)) return "Error: Invalid input for factorial";
                return String.valueOf(factorial((int) a));
            default:
                return "Error: Unknown operation";
        }
    }

    private long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }
}
