import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int bulletSpeed = 20;
    public void act() 
    {
        // Add your action code here.
        setLocation(getX(),getY()-bulletSpeed);
        if(isTouching(RegularShip.class))
        {
            Actor RegularShip;
            Actor Bullet;
            Bullet = getOneIntersectingObject(Bullet.class);
            RegularShip = getOneIntersectingObject(RegularShip.class);
            if(RegularShip!=null)
            {
                getWorld().removeObject(RegularShip);
                getWorld().removeObject(Bullet);
            }
                
        }
    }    
}
