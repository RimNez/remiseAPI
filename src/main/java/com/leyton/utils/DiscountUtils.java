package com.leyton.utils;

public class DiscountUtils {
    // function that takes an Integer(seniority) and returns a Double(discount) according to the value of the seniority
    public static Double calculateDiscount( Integer seniority) {
        double discount;

        if ( seniority < 3) { //if the seniority of the client  is lower than 3 years Then the discount would be 0%
            discount = 0.0;
        } else if ( seniority < 5) { // if the seniority is between 3 years and 5 years Then the discount would be 5%
            discount = 5.0;
        } else { // if the seniority is upper than 5 years Then the discount would be 10%
            discount = 10.0;
        }
        return discount;
    }
}


