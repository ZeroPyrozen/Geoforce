import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Over title = new Over();
        addObject(title,getWidth()/2,185);
        title.setLocation(getWidth()/2,175);
        Retry re = new Retry();
        addObject(re,getWidth()/2,424);
        Back backMenu = new Back();
        addObject(backMenu,getWidth()/2,578);
        re.setLocation(getWidth()/2,407);
        backMenu.setLocation(getWidth()/2,579);
    }
}
