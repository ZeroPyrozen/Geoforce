import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends Screen
{
    /**
     * Act - do whatever the TitleScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        if(Greenfoot.isKeyDown("escape"))
        {
            //Exit with Escape Button
            isNavigated = true;
            Greenfoot.stop();
        }
        else if(Greenfoot.isKeyDown("enter"))
        {
            //Show Instruction
        }
        
        
    }    
}
