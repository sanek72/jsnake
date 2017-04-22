/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.snake;

import java.util.Random;

/**
 *
 * @author san-k
 */
public class Apple {

    private int x;
    private int y;   
    
    private int maxSize;

    
    public Apple(int maxSize){
       this.maxSize = maxSize;        
        x = new Random().nextInt(20)*maxSize;
        y = new Random().nextInt(20)*maxSize;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }    
    
    public void appleUpdate(){   
        x = new Random().nextInt(20)*maxSize;
        y = new Random().nextInt(20)*maxSize;
    }
    
    
}
