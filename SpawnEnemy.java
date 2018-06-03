import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpawnEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpawnEnemy extends Actor
{
    /**
     * Act - do whatever the SpawnEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int count = 0;
    public int timer = 0 ;
    public void act() 
    {
        // Add your action code here.
        if(timer<=800)
        {
            if(count==40)
            {
                basicWave();
            }
            else if(count == 60)
            {
                basicWave();
                count = 0;
            }
            count++;
            
        }
        else if(timer>=800&&timer<=1600)
        {
            if(count==80)
            {
                suicideWave();
                count = 0;
            }
            count++;
        }
        timer++;
        
    }
    public void basicWave()
    {  
       //Right to Left
       getWorld().addObject(new RegularShip(5,5,0),getWorld().getWidth(),1);
       //Left to Right
       getWorld().addObject(new RegularShip(5,5,1),1,100);
       
    }
    public void suicideWave()
    {
        getWorld().addObject(new RegularShip(5,5,3),getWorld().getWidth(),1);
        getWorld().addObject(new RegularShip(5,5,3),1,1);
    }
}