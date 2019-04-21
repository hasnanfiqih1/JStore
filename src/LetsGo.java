import java.util.Random;

public class LetsGo
{
    public LetsGo()
    {

    }

    public int random(int min, int max)
    {
        if (min >= max)
        {
            throw new IllegalArgumentException("max harus lebih besar dari min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args)
    {
        LetsGo mulai = new LetsGo();
        RunForYourLife R1 = new RunForYourLife( "Lionel", mulai.random(37,56));
        RunForYourLife R2 = new RunForYourLife( "Andres", mulai.random(19,38));
        RunForYourLife R3 = new RunForYourLife( "Messi", mulai.random(1,20));

        R1.start();
        R2.start();
        R3.start();
    }
}