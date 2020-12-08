package com.example.springplayground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
public class MathController {


    @GetMapping("/math/pi")
    public String getPiValue(){
        return "3.141592653589793";
    }


    @GetMapping("/math/calculate")
    public String calculate(Calculate calc){
        //if (calc.getOperation() == null) return "IS EMPTY";
        int xInt = 0;
        int yInt = 0;
        int val = 0;


        try {
             xInt = Integer.parseInt(calc.getX());
             yInt = Integer.parseInt(calc.getY());

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        switch (calc.getOperation()){

            default:
                throw new IllegalStateException("Unexpected value: " + calc.getOperation());

                case "subtract":
                    val = xInt - yInt;
                    return String.valueOf(xInt) +" - " +  String.valueOf(yInt) + " = " + String.valueOf(val);

                case "add":
                    val = xInt + yInt;
                    return String.valueOf(xInt) +" + " +  String.valueOf(yInt) + " = " + String.valueOf(val);

                case "multiply":
                    val = xInt * yInt;
                    return String.valueOf(xInt) +" * " +  String.valueOf(yInt) + " = " + String.valueOf(val);


                case "divide":
                    val = xInt / yInt;
                    return String.valueOf(xInt) +" / " +  String.valueOf(yInt) + " = " + String.valueOf(val);

        }

    }
    @GetMapping("/math/calculate")
    public String calculate(Sum sum){
        int[] numbers = sum.getNumbers();
        int total = 0;
        ArrayList<String> display = new ArrayList<>();
        for (int number : numbers) {
            total += number;
            display.add(Integer.toString(number) + " + ");
        }
        display.remove(display.get(display.size()-1));


        return "NOT WORKING YET";
    }
}
