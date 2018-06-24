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
    private long currentTimeM = 0;
    private long currentTimeS = 0;
    private long startTime = 0;
    private int pX = 0, pY = 0;
    private boolean turnBack = false;

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
            
           if(count==10)
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
               count = 0;
           }
           count++;
        }
        if((currentTimeM/1000)>=8&&(currentTimeM/1000)<=114)
        {
            if(((currentTimeM-startTime)/10)%10==0)
                spawnParticle1();
        }
        if((currentTimeM/1000)>=14&&(currentTimeM/1000)<=27)
        {
            if((currentTimeM/1000)<=23)
            {
                if(count>=20)
                {
                    basicWaveLeft(20,100);
                    count=0;
                }
                count++;
            }
            else
            {
                if(count>=20)
                {
                    basicWaveRight(getWorld().getWidth(),150);
                    count=0;
                }
                count++;
            }
        }
        if((currentTimeM/1000)>=28&&(currentTimeM/1000)<=60)
        {
               if(count>=20)
               {
                    advanceWaveCurve1(Greenfoot.getRandomNumber(getWorld().getWidth()),getWorld().getHeight());
                    count=0;
               }
               count++;
        }
        if((currentTimeM/1000)>=45&&(currentTimeM/1000)<=60)
        {
            if(count>=40)
            {
                    count = 100;
                    for(int i=1; i<=2; i++)
                    {
                        if(i%2==0)
                            basicWaveLeft(70,count);
                        else
                            basicWaveLeft(20,count);
                        count+=100;
                    }
                count=0;
            }
                count++;
        }
        if((currentTimeM/1000)>=68&&(currentTimeM/1000)<=75)
        {
            if(count>=40)
            {
                    count = 100;
                    for(int i=1; i<=2; i++)
                    {
                        if(i%2==0)
                            basicWaveRight(getWorld().getWidth(),count);
                        else
                            basicWaveRight(getWorld().getWidth(),count);
                        count+=100;
                    }
                count=0;
            }
                count++;
        }
        if((currentTimeM/1000)>=75&&(currentTimeM/1000)<=82)
        {
            if(count>=40)
            {
                    count = 100;
                    for(int i=1; i<=2; i++)
                    {
                        if(i%2==0)
                            basicWaveLeft(70,count);
                        else
                            basicWaveLeft(20,count);
                        count+=100;
                    }
                count=0;
            }
                count++;
        }
        if((currentTimeM/1000)>=82&&(currentTimeM/1000)<=97)
        {
               if(count>=20)
               {
                    advanceWaveCurve1(Greenfoot.getRandomNumber(getWorld().getWidth()),Greenfoot.getRandomNumber(getWorld().getHeight()));
                    count=0;
               }
               count++;
        }
        if((currentTimeM/1000)>=98&&(currentTimeM/1000)<=110)
        {
            if(count>=80)
            {
                count = 100;
                    for(int i=1; i<=2; i++)
                    {
                        basicWaveLeft(20,count);
                        basicWaveRight(getWorld().getWidth(),count+150);
                        count+=100;
                    }
                count=0;
            }
            count++;
        }
        
        
        
    }
    public void advanceWaveCurve1(int x, int y)
    {
        getWorld().addObject(new RegularShip(5,5,3),x,y);
    }
    public void basicWaveRight(int x, int y)
    {  
       //Right to Left
       getWorld().addObject(new RegularShip(5,5,0),x,y);
    }
    public void basicWaveLeft(int x, int y)
    {
        //Left to Right
        getWorld().addObject(new RegularShip(5,5,1),x,y);
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
