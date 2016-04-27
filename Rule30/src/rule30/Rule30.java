/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rule30;
/**
 *
 * @author Charie Mae
 */
public class Rule30 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
    /** default length is 20. (matrix 20 x 20)
     * user MUST input exactly 20 binary characters. (ex: 00000000010000000000)
     * incomplete input length will result to an ERROR. (ex: 101001)
     * character '1' will be printed as '-'.
     */
    
     char [][] matrix = init_state("00000000010000000000");
    display(rule30(matrix));

  }
  
  
  public static char[][] init_state(String state){  
    char[][] matrix = new char [20][20];
    
    for (int i = 0; i < 20; i++){
      if (state.charAt(i) == '1'){
        matrix[0][i] = '-';
      } else {
        matrix[0][i] = state.charAt(i);
      }
    }
   
    for (int i = 1; i < matrix.length; i++){
      for (int j = 0; j < matrix.length; j++){
        matrix[i][j] = '0';
      }
    }
    return matrix;      
  }
  public static boolean pattern (char a, char b, char c){
    if (a == '-' && b == '-' && c == '-' || a == '-' && b == '-' && c == '0' ||
        a == '-' && b == '0' && c == '1' || a == '0' && b == '0' && c == '0'){
      return false;          
    } else return a == '-' && b == '0' && c == '0' || a == '0' && b == '-' && c == '-' ||
            a == '0' && b == '-' && c == '0' || a == '0' && b == '0' && c == '-';
  }
  
  public static char[][] rule30 (char[][] matrix){
    char[][] newMatrix = matrix;
    
    for (int i = 0; i < matrix.length; i ++){
      for (int j = 0; j < matrix.length; j++){
        if (j < 18 &&  i < 19){
          if (pattern (newMatrix[i][j], matrix[i][j+1], matrix[i][j+2]) == true){
              newMatrix[i+1][j+1] = '-';  
          } else {
           newMatrix[i+1][j+1] = '0'; 
          }
        }   
      }
    }  
    return newMatrix;
  }
  
  public static void display(char[][] matrix){
    for (char[] matrix1 : matrix) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.print(matrix1[j] + " ");
      }
      System.out.println();
    }
  }
}