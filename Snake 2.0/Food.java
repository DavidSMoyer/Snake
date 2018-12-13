import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{
    // An image array to be randomly set to the image.
    public String img[] = {"apple1.png","apple2.png","bananas.png","plum.png","stawberry.png","strawberry2.png","cherries.png"};
    /**
     * Constructor of the object
     */
    public Food()
    {
        setImage(img[Greenfoot.getRandomNumber(img.length)]);
        getImage().scale(30,30);
    }
    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
