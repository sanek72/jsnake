/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author sanek72
 */
public class KeyInputHandler extends KeyAdapter  {
    private Snake snake;

    KeyInputHandler(Snake snake) {
        this.snake = snake;
    }
    @Override
    public void keyPressed(KeyEvent e) { 
	if (e.getKeyCode() == KeyEvent.VK_UP & snake.istDirection() != 1) {
		snake.setDirection(0);
	}
	if (e.getKeyCode() == KeyEvent.VK_DOWN & snake.istDirection() != 0) {
		snake.setDirection(1);
	}
	if (e.getKeyCode() == KeyEvent.VK_RIGHT & snake.istDirection() != 3) {
		snake.setDirection(2);
	}
	if (e.getKeyCode() == KeyEvent.VK_LEFT & snake.istDirection() != 2) {
		snake.setDirection(3);
	}        
} 	
    @Override
    public void keyReleased(KeyEvent e) { 


    }
}
