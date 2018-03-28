/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.images;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author miyan
 */
public class Animation {
    
    private int speed;
    private int frames;
    
    private int index = 0;
    private int count = 0;
    
    private BufferedImage[] images;

    public BufferedImage getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(BufferedImage currentImage) {
        this.currentImage = currentImage;
    }
    private BufferedImage currentImage;
    

    public Animation(int speed, BufferedImage... args) { //allows for unlimated arguments
        this.speed = speed;
        images = new BufferedImage[args.length];
        for (int i = 0; i < args.length; i++) {
            images[i] = args[i];
        }
        frames = args.length;
        
    }
    
    public void runAnimation(){
        index++;
        if(index > speed){
            index = 0;
            nextFrame();
        }
    }
    
    private void nextFrame(){
        for (int i = 0; i < frames ; i++) {
            if(count == i)
                currentImage = images[i];
                
        }
        count++;
        
        
        if(count>frames)
            count = 0;
    }
    
    public void drawAnimation(Graphics g, int x, int y){
        g.drawImage(currentImage, x, y, null);
    }

    public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY){
        g.drawImage(currentImage, x, y, scaleX, scaleY, null);
    }    
    
}