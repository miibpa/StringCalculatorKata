package com.example.miguelibanez.stringcalculatorkata;

/**
 *
 * Created by miguelibanez on 13/11/17.
 */

class StringCalculator {

    private static final  String FIND_COMMAS_JUMP_LINES = "[,\\n]";

    public int sum(String param) throws NegativesNotAllowedException {
        int sum = 0;
        if(param != null && !param.isEmpty()){
            if(param.contains("-")){
                throw new NegativesNotAllowedException(findNegatives(param));
            }
            String[] stringNumbers = param.split(FIND_COMMAS_JUMP_LINES);
            for (String stringNumber : stringNumbers){
                try {
                    sum += Integer.parseInt(stringNumber);
                }catch (NumberFormatException e){
                    return 0;
                }
            }
            return sum;
        }
        return sum;


    }

    private String findNegatives(String param){
        String[] stringNumbers = param.split(FIND_COMMAS_JUMP_LINES);
        StringBuilder negativesBuilder = new StringBuilder();
        for (String stringNumber : stringNumbers) {
            if (stringNumber.contains("-")) {
                negativesBuilder.append(stringNumber);
            }
        }
        return negativesBuilder.toString();
    }
}
