/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author san-k
 */
public class SnakeGame extends JFrame implements ActionListener {

public static int HEIGHT = 20;     
public static int WIDTH = 20;
public static int START_SNAKE_POSITION[] = new int[] {160, 160};
public static int START_SNAKE_LENGTH = 4;
public static int START_SNAKE_DIRECTION = -1;//random direction
public static int PIXEL_SIZE = 16;
public static int SPEEAD = 3; 
private boolean isGame;
private Snake snake;
private Apple apple;
private Timer timer;
    
    public SnakeGame(){
        super("Snake");
        isGame = true;
        this.timer = new Timer(SPEEAD == 0 ? 1000 : 1000/SPEEAD, this);
        snake = new Snake(HEIGHT * PIXEL_SIZE, WIDTH * PIXEL_SIZE, START_SNAKE_POSITION[0], START_SNAKE_POSITION[1], START_SNAKE_LENGTH, PIXEL_SIZE, START_SNAKE_DIRECTION);
        apple = new Apple(PIXEL_SIZE);
        setSize(WIDTH * PIXEL_SIZE, HEIGHT * PIXEL_SIZE);
        setResizable(false);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        addKeyListener(new KeyInputHandler(snake));
        timer.start();
    }
    
       @Override
       public void paint(Graphics g) {
	g.setColor(Color.black); 
	g.fillRect(0, 0, WIDTH * PIXEL_SIZE, HEIGHT * PIXEL_SIZE);
        if(isGame){           
            // create snake            
            for(int i = 0; i < snake.getSnakeLength(); i++){
            if(i == 0){
                g.setColor(Color.ORANGE);
            }else{
                g.setColor(Color.GREEN);        
            }
            g.drawRoundRect(snake.getsX()[i], snake.getsY()[i], snake.getSnakeStepLength(), snake.getSnakeStepLength(), 20, 15);
            }  
            //create apple
            g.setColor(Color.RED); 
            g.fillOval(apple.getX(), apple.getY(), PIXEL_SIZE, PIXEL_SIZE);
        }else{
            g.setColor(Color.RED);
            g.drawString("GAME OVER", START_SNAKE_POSITION[0], START_SNAKE_POSITION[1]);
        }       
     }
       

    public void actionPerformed(ActionEvent ev) {
        snake.Motion();// двигаем
        if(snake.isApple(apple.getX(), apple.getY())){
            apple.appleUpdate();
        }
        if(snake.isLost()){
            isGame = false;
        }   
        repaint();// пересовываю        
    }
    
//    private void lostGame(){
//        System.out.println("lose");
//    }
}
