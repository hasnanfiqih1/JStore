
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main
{

    /**
     * Constructor for objects of class main
     */
    public main()
    {
     
    }

    public static void main(String args[])
    {
        Anggota Band = new Anggota("Afdal", Status.valueOf("Active"), 
        "Band");
        
        System.out.println("-------------------------------");
        Band.print();
        
    }
}
