/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivequeen;

/**
 *
 * @author pushg
 */
public class RecursiveQueen {
    int max = 8;   
    static int count = 0;  
    static int num = 0;  
    int[] arr = new int[max];
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        RecursiveQueen queue8 = new RecursiveQueen();
        queue8.check(0);
        System.out.println(count);
        System.out.println(num);
        
    }
    private void check(int n) {
   
        if (n == max) {
  
            print();  
            return;
        }
        
        for (int i = 0; i < max; i++) {

            arr[n] = i;
            if (adjust(n)) {    
                check(n + 1); 
            } else {

            }
        }
    }

    private boolean adjust(int n) {
        num++;
        for (int i = 0; i < n; i++) {   
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i]))
                return false;
        }
        return true;
    }

    private void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        count++;
        System.out.println();
    }
}
