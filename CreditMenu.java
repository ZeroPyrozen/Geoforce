import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CreditMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreditMenu extends World
{

    /**
     * Constructor for objects of class CreditMenu.
     * 
     */
    public CreditMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        prepare();
    }
    private void prepare()
    {

        Back ba = new Back();
        addObject(ba,getWidth()/2,185);
        ba.setLocation(980,650);
    }
}
