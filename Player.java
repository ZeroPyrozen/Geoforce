import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean isAlive = true;
    private boolean intro = true;
    private int lives = 0;
    protected int flightSpeed = 10;
    private int flightVelocity = 50;
    private boolean isMove = false;
    private int counterBullet = 0;
    public int score = 0;
    private GreenfootSound bg;
    public Player()
    {
        lives = setLiveToMax();
        
    }
    public void act() 
    {
        // Add your action code here.
        if(isAlive)
        {
            showInfo();
            flight();
            if(isBoundaries()!=0)
            {
                //Teleportation
                switch(isBoundaries())
                {
                   case 1:
                    //to Upper
                   setLocation(getX(),getWorld().getHeight());
                       break;
                   case 2:
                    //to Lower
                   setLocation(getX(),0);
                       break;
                   case 3:
                    //to Right
                   setLocation(getWorld().getWidth(),getY());
                        break;
                   case 4:
                    //to Left
                   setLocation(10,getY());
                        break;
                }
            }
            if(isCollide())
            {
                lives--;
            }
            if(lives<=0)
            {
                isAlive = false;
                bg.stop();
                Greenfoot.setWorld(new GameOver());
            }
            if(Greenfoot.isKeyDown("z"))
            {
                //Shoot
                shoot();
            }
            score++;
        }
    }
    private int setLiveToMax()
    {
        return 5;
    }
    public boolean isCollide()
    {
        Actor par = getOneObjectAtOffset(0,0,ParticleGenerator.class);
        Actor reg = getOneObjectAtOffset(0,0,RegularShip.class);
        Actor bul = getOneObjectAtOffset(0,0,Bullet.class);
        if(par!=null)
        {
            getWorld().removeObject(par);
            return true;
        }
        if(reg!=null)
        {
            getWorld().removeObject(reg);
            return true;
        }
        if(bul!=null)
        {
            getWorld().removeObject(bul);
            return true;
        }
        return false;
    }
    private int isBoundaries()
    {
        if(getY()>getWorld().getHeight()) //Teleport to Up
            return 1;
        else if(getY()<0) //Teleport to Down
            return 2;
        else if(getX()<0) //Teleport to Right
            return 3;
        else if(getX()>getWorld().getWidth()) //Teleport to Left
            return 4;
        return 0;
    }
    private void flight()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-flightSpeed,getY());
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+flightSpeed,getY());
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-flightSpeed);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+flightSpeed);
        }
    }
    public void showInfo()
    {
       getWorld().showText("Score: "+score, 100, 50);
       getWorld().showText("Lives: "+lives, 100, 100);
    }
    public void shoot()
    {
        if(counterBullet==10)
        {
            counterBullet=0;
            PlayerBullet peluruKiri = new PlayerBullet(0);
            getWorld().addObject(peluruKiri, getX()-30, getY());
            PlayerBullet peluruKanan = new PlayerBullet(0);
            getWorld().addObject(peluruKanan, getX()+30, getY());
        }
        counterBullet++;
    }
    public GreenfootSound setBGM(GreenfootSound bg)
    {
        this.bg = bg;
        return bg;
    }
    public GreenfootSound getBGM()
    {
        return bg;
    }
    public int setScore(int score)
    {
        return this.score = score;
    }
    public int getScore()
    {
        return score;
    }
    
}

