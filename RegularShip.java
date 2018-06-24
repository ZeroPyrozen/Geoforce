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
    
    public RegularShip(int i,int j,int dir)
    {
       xTambah = i;
       yTambah = j;
       direct = dir;
    }
    public void act() 
    {
        // Add your action code here.
        movement();
        if (fire_rate > 0) {
            fire_rate--;
        }
        if(fire_rate == 0 && Greenfoot.getRandomNumber(100)<3)
        {
            shoot();
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
        


                Actor player = (Actor)getWorld().getObjects(Player.class).get(0);
                if(getX() == player.getX()&&direct ==1 || getX() == player.getX()&&direct ==0)
                {
                    xTambah = 0;
                    yTambah = 10;
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
                else
                {
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
            
        

    }
   
    
}
