import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the PlayerBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int bulletSpeed = 10;
    private int code = 0;
    public Bullet(int code)
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
        if(isTouching(Player.class))
        {
            Actor Player;
            Actor Bullet;
            Bullet = getOneIntersectingObject(Bullet.class);
            Player = getOneIntersectingObject(Player.class);
            if(Player!=null)
            {
                getWorld().removeObject(Bullet);
            }
                
        }
    }    
}
