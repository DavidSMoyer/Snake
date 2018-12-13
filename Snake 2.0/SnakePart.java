import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnakePart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakePart extends Actor
{
    // How long the part lasts in act cycles
    private int lifeTime;
    /**
     * The constructor of the object
     */
    public SnakePart(int lt, int direction)
    {
        lifeTime = lt;
        GreenfootImage img = new GreenfootImage(25,25);
        img.setColor(Color.WHITE);
        img.fillOval(0,0,24,24);
        setImage(img);
        setRotation(direction);
    }
    /**
     * Act - do whatever the SnakePart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (lifeTime > 0)
        {
            lifeTime--;
        }
        else
        {
            getWorld().removeObject(this);
        }
    }  
    /**
     * Gets the current life time value of the object.
     * 
     * @Param None There are no parameters.
     * @return Returns the current value of the LifeTime int variable.
     */
    public int getLT()
    {
        return lifeTime;
    }
}
