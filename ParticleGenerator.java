import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class ParticleGenerator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParticleGenerator extends Actor
{
    /**
     * Act - do whatever the ParticleGenerator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int dir = 0;
    public ParticleGenerator(int dir)
    {
        this.dir = dir;
    }
    public void act() 
    {
        // Add your action code here.
        if(dir == 0)
        {
            setLocation(getX(),getY()+10);
        }
        else if(dir ==1)
        {
            setLocation(getX(),getY()-10);
        }
        
        if(getY()>getWorld().getHeight())
        {
            destroy();
        }
       
    }
    public void destroy()
    {
        Actor par = getWorld().getObjects(ParticleGenerator.class).get(0);
        if(par!=null)
        {
            getWorld().removeObject(par);
        }
    }

}
