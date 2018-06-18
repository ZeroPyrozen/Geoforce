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
    public long currentTimeM = 0;
    public long currentTimeS = 0;
    public long startTime = 0;
    public SpawnEnemy()
    {
        startTime = System.currentTimeMillis();
    }
    public void act() 
    {
        // Add your action code here.
        currentTimeM = System.currentTimeMillis() - startTime;
        if((currentTimeM/1000)%10==0)
        {
           spawnParticle1();
           //spawnParticle2();
        }
        if((currentTimeM/1000)<=800)
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
        else if((currentTimeM/1000)>=800&&(currentTimeM/1000)<=1600)
        {
            if(count==80)
            {
                suicideWave();
                count = 0;
            }
            count++;
        }
        //System.out.println(timer);
        
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
    public void spawnParticle1()
    {
        ParticleGenerator s = new ParticleGenerator(0);
        getWorld().addObject(s, Greenfoot.getRandomNumber(getWorld().getWidth()), 0);
    }
    public void spawnParticle2()
    {
        ParticleGenerator a = new ParticleGenerator(1);
        getWorld().addObject(a, Greenfoot.getRandomNumber(getWorld().getWidth()), getWorld().getHeight());
    }
}
