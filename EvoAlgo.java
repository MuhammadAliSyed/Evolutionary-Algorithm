/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoalgo;

/**
 *
 */
public class EvoAlgo {

    /**
     * @param args the command line arguments
     */
    static int[] sort = new int[9]; 
    public static void main(String[] args) {
        int array1[][] = new int[5][2]; int r1,r2= 0; int r5 = 0; int r6 = 0;
        int array2[][] = new int[9][2]; int array3[][] = new int[9][2]; int r3 = 0,r4 = 0; int r7 = 0; int r8 = 0;
        array1[0][0] = 1; array1[0][1] = 2; array1[1][0] = -2; array1[1][1] = -3;
        array1[2][0] = 4; array1[2][1] = -1; array1[3][0] = 5; array1[3][1] = 2;
        array1[4][0] = -3; array1[4][1] = 3; int temp = 0;
        int f1,f5 = 0; int f2,f6 = 0; int f3,f7 = 0; int f4,f8 = 0; int t1,t3 = 0; int t2,t4 = 0;
        double m1 = 0; double m2 = 0; double m3 = 0; double m4 = 0;
        int OS[][] = new int[4][2]; int Temp[][] = new int[4][2];
        
        //r1 & r2 choosing first parent
        for (int a = 0; a < 50; a++){
        r1 = (int) (Math.random() * 5);
        r2 = (int) (Math.random() * 5);
        while (r2 == r1){
            r2 = (int) (Math.random() * 5);
            //System.out.println(r2);
        }
            //System.out.println(r1 + " " + r2);
        f1 = f(array1[r1][0],array1[r1][1]);
        f2 = f(array1[r2][0],array1[r2][1]);
        if (f1 > f2){
            t1 = r1;
            Temp[0][0] = array1[r1][0];
            Temp[0][1] = array1[r1][1];
        }
        else {
            t1 = r2;
            Temp[0][0] = array1[r2][0];
            Temp[0][1] = array1[r2][1];
        }
        
        // r3 & r4 choosing second parent
        r3 = (int) (Math.random() * 5);
        while (r3 == r1 || r3 == r2){
            r3 = (int) (Math.random() * 5);
        }
        r4 = (int) (Math.random() * 5);
        while (r4 == r1 || r4 == r2 || r4 == r3){
            r4 = (int) (Math.random() * 5);
        }
        //System.out.println(r3 + " " + r4);
        f3 = f(array1[r3][0],array1[r3][1]);
        f4 = f(array1[r4][0],array1[r4][1]);
        if (f3 > f4){
            t2 = r3;
            Temp[1][0] = array1[r3][0];
            Temp[1][1] = array1[r3][1];
        }
        else {
            t2 = r4;
            Temp[1][0] = array1[r4][0];
            Temp[1][1] = array1[r4][1];
        }
        // first two offsprings by crossover
        OS[0][0] = Temp[0][0];
        OS[0][1] = Temp[1][1];
        OS[1][0] = Temp[1][0];
        OS[1][1] = Temp[0][1];
        
        //r5 & r6 choosing third parent
        r5 = (int) (Math.random() * 5);
        while (r5 == t1 || r5 == t2){
            r5 = (int) (Math.random() * 5);
        }
        r6 = (int) (Math.random() * 5);
        while (r6 == t1 || r6 == t2 || r6 == r5){
            r6 = (int) (Math.random() * 5);
        }
        //System.out.println(r5 + " " + r6);
        f5 = f(array1[r5][0],array1[r5][1]);
        f6 = f(array1[r6][0],array1[r6][1]);
        if (f5 > f6){
            t3 = r5;
            Temp[2][0] = array1[r5][0];
            Temp[2][1] = array1[r5][1];
        }
        else {
            t3 = r6;
            Temp[2][0] = array1[r6][0];
            Temp[2][1] = array1[r6][1];
        }
        
        //r7 & r8 choosing fourth parent
        r7 = (int) (Math.random() * 5);
        while (r7 == t1 || r7 == t2 || r7 == t3){
            r7 = (int) (Math.random() * 5);
        }
        r8 = (int) (Math.random() * 5);
        while (r8 == t1 || r8 == t2 || r8 == t3 || r8 == r7){
            r8 = (int) (Math.random() * 5);
        }
        //System.out.println(r7 + " " + r8);
        f7 = f(array1[r7][0],array1[r7][1]);
        f8 = f(array1[r8][0],array1[r8][1]);
        if (f7 > f8){
            t4 = r7;
            Temp[3][0] = array1[r7][0];
            Temp[3][1] = array1[r7][1];
        }
        else {
            t4 = r8;
            Temp[3][0] = array1[r8][0];
            Temp[3][1] = array1[r8][1];
        }
        // second two offsprings
        OS[2][0] = Temp[2][0];
        OS[2][1] = Temp[3][1];
        OS[3][0] = Temp[3][0];
        OS[3][1] = Temp[2][1];
        
        // computing mutation by generating random number and checking if > 50%
        // for all four offsprings
        m1 = Math.random();
        if (m1 > 0.50){
            temp = OS[0][0];
            OS[0][0] = OS[0][1];
            OS[0][1] = temp;
        }
        m2 = Math.random();
        if (m2 > 0.50){
            temp = OS[1][0];
            OS[1][0] = OS[1][1];
            OS[1][1] = temp;
        }
        m3 = Math.random();
        if (m3 > 0.50){
            temp = OS[2][0];
            OS[2][0] = OS[2][1];
            OS[2][1] = temp;
        }
        m4 = Math.random();
        if (m4 > 0.50){
            temp = OS[3][0];
            OS[3][0] = OS[3][1];
            OS[3][1] = temp;
        }
        // copying to an array
            int i = 0;
            for (int j = 0; j <5; j++){
                array2[i][0] = array1[j][0]; array2[i][1] = array1[j][1];
                i++;
            }
            for (int k = 0; k < 4; k++){
                array2[i][0] = OS[k][0]; array2[i][1] = OS[k][1];
                i++;
            }
            fvalue(array2);
            for (int m = 0; m < 9; m++){
                for (int n = 0; n <9; n++){
                    if (sort[m] == f(array2[n][0],array2[n][1])){
                        array3[m][0] = array2[n][0];
                        array3[m][1] = array2[n][1];
                        break;
                    }
                }
            }
            // choosing best five 
            for (int c = 0; c < 5; c++){
                array1[c][0] = array3[c][0];
                array1[c][1] = array3[c][1];
            }
            PrintArray(array1);
            System.out.println("Best Value is " + "(" + array1[0][0] + "," + array1[0][1] + ")" + " f(x) = " + f(array1[0][0],array1[0][1]));
        
        }
     }
    public static int f(int x,int y){
        return ((x * x) + (y * y));
    } 
    public static void PrintArray(int[][] A){
        for (int i = 0; i < A.length; i++){
            System.out.print("(" + A[i][0] + "," + A[i][1] + ")" + ",");
        }
    }
    public static void fvalue(int[][] array2){
        for (int i = 0; i < 9; i++){
            sort[i] = (array2[i][0] * array2[i][0]) + (array2[i][1] * array2[i][1]); 
        }
        bubbleSort(sort);
    }
    // using bubble sort for sorting
    public static void bubbleSort(int array[]) {
    int size = array.length;
    for (int i = 0; i < size - 1; i++)
      for (int j = 0; j < size - i - 1; j++)
        // To sort in descending order, change > to < in this line.
        if (array[j] < array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
  }
}
