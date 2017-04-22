
package ru.m;

/**
 * @author san-k
 */
public class Vector {
    
    private int[] a;
    private int[] b;
    private int[] c;
    
    public void Vector(int[] a, int b[], int c[]){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void Vector(int[] a, int b[]){
        this.a = a;
        this.b = b;
    }   
    
//    public int lengthVector(int i[]){
//        return i[0]+i[1];
//    }
   
    public int zeroVector(){
        return 0;
    }
    
    }
    


