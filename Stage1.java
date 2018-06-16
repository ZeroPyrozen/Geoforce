import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Stage1 extends World
{
    public int x = 0,y = 0;
    public Stage1()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false);
        prepare();
         // backgroundMusic.playLoop();
          //public void stopped()
        //  {
        //      backgroundMusic.pause();
        //  }
        //    public void started()
        //  {
        //      backgroundMusic.playLoop();
        //  }
    }
    
    public void prepare()
    {
        //Adding Up Player
        Player play = new Player();
        GreenfootSound bgm = new GreenfootSound("bgm1.mp3");
        bgm.play();
        addObject(play,getWidth()/2,600);
        HitBox play1 = new HitBox();
        addObject(play1,getWidth()/2,600);
        setEnemyGenerator();
        play.setBGM(bgm);
    }
    
    public void setEnemyGenerator()
    {
        SpawnEnemy s = new SpawnEnemy();
        addObject(s, -10,-10);
    }
    
}