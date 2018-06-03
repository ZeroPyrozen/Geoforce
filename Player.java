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
    public Player()
    {
        lives = setLiveToMax();
        
    }
    public void act() 
    {
        // Add your action code here.
        if(isAlive)
        {
            flight();
            //if(isBoundaries()!=0)
            //{
                //Teleportation
              //  switch(isBoundaries())
               // {
               //     case 1:
                 //   //to Upper
              //      setLocation(getX(),10);
               //         break;
                //    case 2:
                    //to Lower
               //     setLocation(getX(),1230);
               //         break;
               //     case 3:
                    //to Right
             //       setLocation(430,getY());
                //        break;
              //      case 4:
                    //to Left
              //      setLocation(290,getY());
               //         break;
               // }
            //}
            
            if(lives<=0)
            {
                isAlive = false;
                Greenfoot.stop();
            }
            if(Greenfoot.isKeyDown("z"))
            {
                //Shoot
                shoot();
            }
        }
    }
    private int setLiveToMax()
    {
        return 5;
    }
    private int isBoundaries()
    {
        if(getY()>1200) //Teleport to Up
            return 1;
        else if(getY()<=0) //Teleport to Down
            return 2;
        else if(getX()<240) //Teleport to Right
            return 3;
        else if(getX()>480) //Teleport to Left
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
    public void shoot()
    {
        if(counterBullet==10)
        {
            counterBullet=0;
            Bullet peluruKiri = new Bullet();
            getWorld().addObject(peluruKiri, getX()-30, getY());
            Bullet peluruKanan = new Bullet();
            getWorld().addObject(peluruKanan, getX()+30, getY());
        }
        counterBullet++;
    }
}
