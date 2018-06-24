import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerBullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int bulletSpeed = 20;
    private int code = 0;
    public PlayerBullet(int code)
    {
        this.code = code;
    }
    public void act() 
    {
        // Add your action code here.
        if(code==0)
            setLocation(getX(),getY()-bulletSpeed);
        else
            setLocation(getX(),getY()+bulletSpeed);
        if(isTouching(RegularShip.class))
        {
            Actor regularShip;
            Actor playerBullet;
            playerBullet = getOneIntersectingObject(PlayerBullet.class);
            regularShip = getOneIntersectingObject(RegularShip.class);
            if(regularShip!=null)
            {
                getWorld().removeObject(playerBullet);
                getWorld().removeObject(regularShip);
                
            }
             
        }
        if(isTouching(ParticleGenerator.class))
        {
            Actor playerBullet;
            Actor particleAs;
            particleAs = getOneIntersectingObject(ParticleGenerator.class);
            playerBullet = getOneIntersectingObject(PlayerBullet.class);
            if(particleAs!=null)
            {
                getWorld().removeObject(playerBullet);
                getWorld().removeObject(particleAs);
                
            }
        }
         
    }    
}