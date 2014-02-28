import java.io.*;

/**
 * Evernote challenge - Question #3
 */
public class Solution {
    
    
    
    public long[] calcular(long[] input) {
        long produto = 1;
        boolean hasZeros = false;
        long[] result = new long[input.length];
        
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0) {
                produto *= input[i];
            }
            else {
                hasZeros = true;
            }
        }
        
        for (int i = 0; i < input.length; i++) {
            long value = input[i];
            if (hasZeros && value != 0) {
                result[i] = 0;
            }
            else if (value != 0) {
                result[i] = produto/input[i];
            }
            else {
                result[i] = (produto != 1) ? produto : 0;
            }
        }
        
        return result;
    }
    

    public static void main(String args[]) throws Exception {
        Solution s = new Solution();
   
        // Input format: First line of input contains N, number of elements in list. 
        // Next N lines will each contain an element (a signed integer)       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        long[] inputArray = new long[N];
        long[] outputArray = null;
        
        
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = Integer.parseInt(br.readLine());
        }
        
        // invoke method to calculate the product of subset elements
        outputArray = s.calcular(inputArray);
        
        // print the result
        for (int i = 0; i < outputArray.length; i++) {
            System.out.println(outputArray[i]);
        }
    }
}
