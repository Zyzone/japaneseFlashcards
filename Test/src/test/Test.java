/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Zyzone
 */
import java.util.Arrays;
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] A = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        
        for(int i = 0; i < A.length; i++) {
            int[] reverse = new int[A[i].length];
            for(int j = A[i].length - 1; j >= 0; j--) {
                 reverse[(A[i].length - 1) - j] = A[i][j];
                 if(reverse[(A[i].length - 1) - j] == 0) {
                     reverse[(A[i].length - 1) - j] = 1;
                 }else {
                     reverse[(A[i].length - 1) - j] = 0;
                 }
            }
            A[i] = reverse;
        }
        
        
        
        System.out.println(Arrays.deepToString(A));
    }
    
}
