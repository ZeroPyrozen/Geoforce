import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{

    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
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

        Title title = new Title();
        addObject(title,getWidth()/2,185);
        StartGame startgame = new StartGame();
        addObject(startgame,getWidth()/2,424);
        ExitGame exitgame = new ExitGame();
        addObject(exitgame,getWidth()/2,578);
        title.setLocation(getWidth()/2,175);
        startgame.setLocation(getWidth()/2,407);
        exitgame.setLocation(getWidth()/2,579);
    }
}
