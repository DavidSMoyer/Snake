import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class SnakeHead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeHead extends Actor
{
    // The size of the snake
    private int size;
    // How fast the snake should move
    private int speed;
    /**
     * Constructor of the object
     */
    public SnakeHead()
    {
        size = 10;
        speed = 3;
        GreenfootImage img = new GreenfootImage(30,30);
        img.setColor(Color.WHITE);
        img.fillOval(0,0,29,29);
        setImage(img);
        
    }
    /**
     * Act - do whatever the SnakeHead wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        move(speed);
        addPart();
        eatFood();
        collisionDetection();
    }    
    /**
     * Checks the keys to turn the snake or to speed it up.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("left") == true)
        {
            turn(-3);
            if (Greenfoot.isKeyDown("up") == true)
            {
                turn(-1);
            }
        }
        if (Greenfoot.isKeyDown("right") == true)
        {
            turn(3);
            if (Greenfoot.isKeyDown("up") == true)
            {
                turn(1);
            }
        }
        if (Greenfoot.isKeyDown("up") == true)
        {
            move(2);
        }
    }
    /**
     * Adds a snake part at the current x and y coordinates.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    private void addPart()
    {
        getWorld().addObject(new SnakePart(size,getRotation()),getX(),getY());
    }
    /**
     * Eats any food it is touching, changes the size by 10, score by 1, and adds another piece in a random location.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    private void eatFood()
    {
        MyWorld world = (MyWorld)getWorld();
        List<Food> food = getIntersectingObjects(Food.class);
        if (food.isEmpty() == false)
        {
            world.removeObject(food.get(0));
            size+=10;
            world.addFood();
            ((MyWorld)getWorld()).addScore();
        }
    }
    /**
     * Checks if the player is touching their tail or the edge of the world. If they are, end the game.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    private void collisionDetection()
    {
        List<SnakePart> tail = getIntersectingObjects(SnakePart.class);
        if (isAtEdge())
        {
            ((MyWorld)getWorld()).gameOver();
        }
        else if (tail.isEmpty() == false)
        {
            for(int i = 0;i < tail.size();i++)
            {
                if (tail.get(i).getLT() < size-30)
                {
                    ((MyWorld)getWorld()).gameOver();
                    i = tail.size();
                }
            }
        }
    }
}
