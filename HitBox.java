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
        Actor player = (Actor)getWorld().getObjects(Player.class).get(0);
        setLocation(player.getX(),player.getY());
    }    
}
