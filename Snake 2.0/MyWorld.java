import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{
    // The current score
    private int score = 0;
    // If the game has started or not
    private boolean started = false;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        showText("0",getWidth()/2,25);
        initialize();
        showText("Press LEFT or RIGHT to turn\nPress UP to go faster\nPress UP to start",getWidth()/2,getHeight()/2);
    }
    /**
     * Runs every time ACT or RUN is called.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    public void act()
    {
        if (started == false)
        {
            while(Greenfoot.isKeyDown("up") == false);
            showText("",getWidth()/2,getHeight()/2);
            started = true;
        }
    }
    /**
     * Initializes the objects in the world
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    private void initialize()
    {
        setPaintOrder(SnakeHead.class,SnakePart.class,Food.class);
        addObject(new SnakeHead(),getWidth()/4,getHeight()/2);
        addFood();
        
    }
    /**
     * Adds a piece of food in a random location in the world
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    public void addFood()
    {
        addObject(new Food(),Greenfoot.getRandomNumber(501)+50,Greenfoot.getRandomNumber(301)+50);
    }
    /**
     * Removes all the objects in the world and tells the player "game over", and their final score.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    public void gameOver()
    {
        showText("",getWidth()/2,25);
        removeObjects(getObjects(null));
        showText("Game Over\nYou got " + score + " points.",getWidth()/2,getHeight()/2);
    }
    /**
     * Adds one to the score
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    public void addScore()
    {
        score++;
        showText("" + score,getWidth()/2,25);
    }
}
