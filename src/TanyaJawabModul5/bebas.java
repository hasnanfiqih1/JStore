package tanyajawabmodul5;
import java.util.regex.*;
import java.util.Scanner;

/**
 * Write a description of class bebas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bebas
{
    public static void main (String[] args)
    {
    
    Scanner scan1 = new Scanner(System.in);
    String input = scan1.nextLine();
    if (Pattern.matches("[+]62[0-9]{11}", input)) {
        System.out.println("Nomor benar");
    } else {
        System.out.println("Nomor salah");
    }
}
}
