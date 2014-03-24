package com.tr.dojo012;

public class LookAndSaySequence {

    private String initial = null;
    
    public LookAndSaySequence(int start){
        
        if (start < 1 || start > 9) {
            throw new InvalidNumberException();
        }
        
        initial = String.valueOf(start);
    }
    
    public String say(String value) {
            
        int count = 1;
        char element = Character.MIN_VALUE;
        StringBuilder saw = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {

            element = value.charAt(i);
            if (i < value.length() - 1 && element == value.charAt(i + 1)){
                count++;
            } else {
                saw.append(count).append(element);
                
                count = 1;
            }
        }
        
        return saw.toString();
    }
    
    public int sum(int rodadas){
        String sequence = initial;
        int sum = 0;
        
        for (int i = 1; i <= rodadas; i++) {
            sequence = say(sequence);
        }
         
        for(int i = 0; i < sequence.length(); i++){
            sum += Character.getNumericValue(sequence.charAt(i)); 
        }
        
        return sum; 
    }
    
}

class InvalidNumberException extends RuntimeException {
    
}
