import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Stage1 extends World
{
    
    public Stage1()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false);
        prepare();
    }
    public void prepare()
    {
        //Adding Up Player
        Player play = new Player();
        addObject(play,(2*getWidth())/3,600);
    }
}
