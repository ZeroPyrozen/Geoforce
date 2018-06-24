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
    private int count = 0;
    public long currentTimeM = 0;
    public long currentTimeS = 0;
    public long startTime = 0;
    private int pX = 0, pY = 0;
    private boolean turnBack = false;
    private int countFirst = 0;
    public SpawnEnemy()
    {
        startTime = System.currentTimeMillis();
    }
    public void act() 
    {
        // Add your action code here.
        currentTimeM = System.currentTimeMillis() - startTime;
        
        if((currentTimeM/1000)<=15)
        {
            
           if(countFirst==10)
           {
               
               if(pX==1280)
                    turnBack=true;
               else if(pX==0)
                    turnBack=false;
               if(turnBack==false)
                    pX +=160;
               else
                    pX-=160;
               firstWave();
               countFirst = 0;
           }
           countFirst++;
        }
        if((currentTimeM/1000)>=8)
        {
            if(((currentTimeM-startTime)/10)%10==0)
                spawnParticle1();
            if(count==60)
            {
                basicWave();
                count=0;
            }
            count++;
            
        }
        
        
        
        
    }
    public void basicWave()
    {  
       //Right to Left
       getWorld().addObject(new RegularShip(5,5,0),getWorld().getWidth(),1);
       //Left to Right
       getWorld().addObject(new RegularShip(5,5,1),20,100);
       
    }
    public void firstWave()
    {
        getWorld().addObject(new RegularShip(5,5,2),pX,20);
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
