package tanyajawabmodul3;


/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
        public static void main(String args[]) 
    {
        Anggota anggota1 = new Anggota(args[0], StatusAnggota.Active, args[1]);
        
        System.out.println("-----Anggota-----");
        anggota1.printData();
    }
}
