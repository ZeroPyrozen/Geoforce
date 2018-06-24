import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RegularShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RegularShip extends Enemy
{
    /**
     * Act - do whatever the RegularShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int xTambah = 0;
    public int yTambah = 0;
    public int dy = 0;
    public int direct = 0;
    private int fire_rate = 20;
    private boolean hasDirection = false;
    private boolean canShoot = false;
    public RegularShip(int i,int j,int dir)
    {
       xTambah = i;
       yTambah = j;
       direct = dir;
       if(direct==0||direct==1)
       {
           canShoot = true;       
       }
       else if(direct==2)
       {
           yTambah = 10;
           canShoot = false;
       }
       else
       {
           canShoot = false;
           setRotation(180);
       }
           
    }
    public void act() 
    {
        // Add your action code here.
        movement();
        if(canShoot==true)
        {
            if (fire_rate > 0) 
            {
                fire_rate--;
            }
            if(fire_rate == 0 && Greenfoot.getRandomNumber(100)<3)
            {
                shoot();
            }
        }
        
        if(getX()>getWorld().getWidth()||getX()<-100||getY()<0||getY()> getWorld().getHeight())
        {
            destroy();
        }
    }
    public void destroy()
    {
        getWorld().removeObject(this);
    }
    public void shoot()
    {
        fire_rate = 50;
        Bullet peluru = new Bullet(1);
        getWorld().addObject(peluru, getX(), getY());
    }
    public void movement()
    {
        if(direct==0||direct==1)
        {
                Actor player = (Actor)getWorld().getObjects(Player.class).get(0);
                if(hasDirection!=true)
                    yTambah = 0;
                if(getX() == player.getX()&&direct ==1 || getX() == player.getX()&&direct ==0)
                {
                    xTambah = 0;
                    yTambah = 10;
                    hasDirection = true;
                    canShoot = false;
                }
  
                if( direct == 0)
                {
                     xTambah += dy;
                     setLocation(getX()-xTambah,getY()+yTambah);
                }
                else if(direct == 1)
                {
                     xTambah += dy;
                     setLocation(getX()+xTambah,getY()+yTambah);
                }
        }
        else if(direct==2)
        {
            
            setLocation(getX(),getY()+yTambah);
            if(yTambah<=20)
            {
                yTambah+=dy;
            }
                
        }
        else if(direct==3)
        {
            setLocation(getX(), getY()-yTambah);
            if(yTambah<=50)
                yTambah = (int)(yTambah*(float)1.1);
        }
                
 
            
        

    }
   
    
}
