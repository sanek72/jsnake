/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.snake;

/**
 *
 * @author san-k
 */
public class Snake {

private int snakeLength;
private int snakeStepLength = 30;
private int sX[];
private int sY[];
private int direction;

private int maxWidth;
private int maxHeight;
//TODO height width
    public Snake(int height, int width, int x, int y, int snakeLength, int snakeStepLength, int direction){
       init(height, width, x , y, snakeLength, snakeStepLength, direction);
     }
    
    private void init(int height, int width, int x, int y, int snakeLength, int snakeStepLength, int direction){
       this.maxHeight = height - snakeStepLength; 
       this.maxWidth = width - snakeStepLength;
       this.snakeLength = snakeLength;
       this.snakeStepLength = snakeStepLength;
       if(direction < 1 || direction > 4){
           this.direction = (int) (Math.random() * 4);
       } else{
           this.direction = direction;
       }          
       sX = new int[height/snakeStepLength];
       sY = new int[width/snakeStepLength];
       sX[0] = x;
       sY[0] = y;
       
       for(int i = 1; i < snakeLength; i++){      
           sX[i] = sX[i-1];
           sY[i] = sY[i-1];
       }        
    }
    
    public boolean isLost(){
        for(int i = snakeLength; i > 0; i--){
            if(sX[0] == sX[i] && sY[0] == sY[i]){
                return true;
            }
        }
        if(sX[0] > maxWidth){
            return true;           
        }else if(sX[0] < 0){
            return true;           
        }else if(sY[0] > maxHeight){
            return true;           
        }else if(sY[0] < 0){
            return true;           
        } else return false;
    }
    
    public boolean isApple(int x, int y){       
        if(sX[0] == x && sY[0] == y){
            snakeLength++;
            return true;
        }
        return false;
    }

    public void Motion(){  
        if(direction == -1){
             return;// stop
         }
        for(int i = snakeLength; i > 0; i--){
            sX[i] = sX[i-1];
            sY[i] = sY[i-1];
        }    
        switch (direction) {       
            case 0://up 
                sY[0] -= snakeStepLength;  
                break;            
            case 1://down
                sY[0] += snakeStepLength;
                break;          
            case 2://right
                sX[0] += snakeStepLength;
                break;         
            case 3://left
                sX[0] -= snakeStepLength;
                break;              
        }
    }

    public int[] getsY() {
        return sY;
    }

    public int[] getsX() {
        return sX;
    }

    public int getSnakeLength() {
        return snakeLength;
    }
    
    public int getSnakeStepLength() {
        return snakeStepLength;
    }  
    
    public int istDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }    

   }
