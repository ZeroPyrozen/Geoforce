import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HitBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HitBox extends Player
{
    /**
     * Act - do whatever the HitBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public HitBox()
    {
        super();
    }
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-flightSpeed,getY());
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+flightSpeed,getY());
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-flightSpeed);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+flightSpeed);
        }
    }    
}
