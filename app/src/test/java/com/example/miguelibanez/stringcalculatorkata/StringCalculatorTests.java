package com.example.miguelibanez.stringcalculatorkata;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Created by miguelibanez on 13/11/17.
 *
 *
 */

public class StringCalculatorTests {


    @Test
    public void empty_string_returns_0(){
       StringCalculator stringCalculator = new StringCalculator();

        int sum = 0;
        try {
            sum = stringCalculator.sum("");
        } catch (NegativesNotAllowedException e) {
            e.printStackTrace();
        }

        assertEquals(sum,0);
    }

    @Test
    public void return_number_passed_as_param(){
        StringCalculator stringCalculator = new StringCalculator();

        int sum = 0;
        try {
            sum = stringCalculator.sum("1");
        } catch (NegativesNotAllowedException e) {
            e.printStackTrace();
        }

        assertEquals(sum,1);
    }

    @Test
    public void return_two_numbers_separated_with_comma(){
        StringCalculator stringCalculator = new StringCalculator();

        int sum = 0;
        try {
            sum = stringCalculator.sum("1,2");
        } catch (NegativesNotAllowedException e) {
            e.printStackTrace();
        }

        assertEquals(sum,3);
    }

    @Test
    public void return_n_numbers_separated_with_comma(){
        StringCalculator stringCalculator = new StringCalculator();

        int sum = 0;
        try {
            sum = stringCalculator.sum("1,2,3,4");
        } catch (NegativesNotAllowedException e) {
            e.printStackTrace();
        }

        assertEquals(sum,10);
    }

    @Test
    public void return_n_numbers_separated_with_comma_or_jump_line(){
        StringCalculator stringCalculator = new StringCalculator();
        int sum = 0;
        try {
            sum = stringCalculator.sum("1\n2,3,4");
        } catch (NegativesNotAllowedException e) {
            e.printStackTrace();
        }
        assertEquals(sum,10);
    }


    @Test
    public void return_error_message_when_negative_numbers(){
        String errorMessage = "";
        StringCalculator stringCalculator = new StringCalculator();

        try {
            int sum = stringCalculator.sum("1\n2,3,4,-1,-2");
        } catch (NegativesNotAllowedException e) {
           errorMessage = e.getMessage();
        }
        assertEquals(errorMessage,"-1-2");
    }

}
