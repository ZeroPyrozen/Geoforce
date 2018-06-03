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
    public int dy = 1;
    public int direct = 0;
    public RegularShip(int i,int j,int dir)
    {
       xTambah = i;
       yTambah = j;
       direct = dir;
    }
    public void act() 
    {
        // Add your action code here.
        Actor Player;
        movement();
        if(getX()>getWorld().getWidth()||getX()<-100||getY()<0||getY()> getWorld().getHeight())
        {
            destroy();
        }
        
    }
    public void destroy()
    {
        getWorld().removeObject(this);
    }
    public void movement()
    {
        
        if(direct==3)
        {
            if(getWorld().getObjects(Player.class).isEmpty())
                return;
            Actor player = (Actor)getWorld().getObjects(Player.class).get(0);
            turnTowards(player.getX(),player.getY());
            move(10);
        }
        else
        {
            setLocation(getX()-xTambah,getY()+yTambah);
            Actor player = (Actor)getWorld().getObjects(Player.class).get(0);
            if(getX() == player.getX()&&direct ==1 || getX() == player.getX()&&direct ==0)
            {
                
                xTambah = 0;
                yTambah += 2;
            
            }
            else
            {
                if( direct == 0)
                {
                    xTambah += dy;
                }
                else if(direct == 1)
                {
                    xTambah -= dy;
                }
            }
        }

    }
   
    
}
