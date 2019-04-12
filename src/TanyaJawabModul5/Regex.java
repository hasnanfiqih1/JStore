package TanyaJawabModul5;
import java.util.regex.*;
import java.util.Scanner.*;
import java.lang.String.*;

public class Regex
{
    public String input;
    //public String regex = ("+62.......");
    
    public static void main (String[] args)
    {
        System.out.println("Masukan Nomor telepon untuk di cek: ");
        
        String input = System.console().readLine();
        System.out.println(input.matches("[+620-9]{14}"));
        var ref = "0" + input.substring(3);
        System.out.println(ref);
        
    }

}
