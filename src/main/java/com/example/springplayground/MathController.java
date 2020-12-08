package com.example.springplayground;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

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
//    @GetMapping("/math/calculate")
//    public String calculate(Sum sum){
//        int[] numbers = sum.getNumbers();
//        int total = 0;
//        ArrayList<String> display = new ArrayList<>();
//        for (int number : numbers) {
//            total += number;
//            display.add(Integer.toString(number) + " + ");
//        }
//        display.remove(display.get(display.size()-1));
//
//
//        return "NOT WORKING YET";
//    }
    @RequestMapping(value = "/math/volume/{length}/{width}/{height}", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH})
    public String getVolume(Volume vol){

        String length = Integer.toString(vol.getLength());
        String width = Integer.toString(vol.getWidth());
        String height = Integer.toString(vol.getHeight());
        String volume = Integer.toString(vol.getVolume());

        return "The volume of a "+ length +"x"+width + "x"+height +" rectangle is "+volume;

    }

    @PostMapping("/math/area")
    public String getArea(Area area){
        if (area.getType().equals("circle") && area.getHeight() == 0 && area.getWidth() == 0 && area.getRadius() > 0) {
            return "Area of a " + area.getType() + " with a radius of "+area.getRadius()+" is "+area.getCircleArea();
        }
        else if (area.getType().equals("rectangle") && area.getHeight() > 0 && area.getWidth() > 0 && area.getRadius() == 0) {
            return "Area of a "+area.getHeight()+"x"+area.getWidth()+" " + area.getType() + " is "+area.getRectArea();
        }
        return "Invalid";
    }


}
