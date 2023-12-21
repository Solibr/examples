package part1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

@Controller
public class Calculator {

    private Map<String, BiFunction<Double, Double, Double>> actions = initActions();

    @GetMapping("/calc")
    public String calc(Model model,
                       @RequestParam("a") double a,
                       @RequestParam("b") double b,
                       @RequestParam("action") String action) {

        double result;
        try {
            result = doCalculation(a, b, action);
        } catch (IllegalArgumentException e) {
            result = 0;
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("result", result);
        return "calculator";
    }

    public double doCalculation(double a, double b, String action) throws IllegalArgumentException {
        try {
            if (action.equals("division") && b == 0)
                throw new IllegalArgumentException("division by zero");
            return actions.get(action).apply(a, b);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("no such action");
        }

    }

    private Map<String, BiFunction<Double, Double, Double>> initActions() {
        Map<String, BiFunction<Double, Double, Double>> action = new HashMap<>();
        action.put("addition", Double::sum);
        action.put("subtraction", (x, y) -> x - y);
        action.put("multiplication", (x, y) -> x * y);
        action.put("division", (x, y) -> x / y);
        return action;
    }

}
