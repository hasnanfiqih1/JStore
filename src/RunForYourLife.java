public class RunForYourLife implements Runnable
{
    private Thread thread;
    private String nama;
    private int delay;

    RunForYourLife(String nama, int delay)
    {
        this.nama = nama;
        this.delay = delay;
        System.out.println(nama + ", ready");
        System.out.println(nama + ", set ...");
    }

    public void run()
    {
        
        try
        {
            for(int cp = 1; cp <= 19; cp++)
            {
                System.out.println(nama + ", has passed checkpoint (" + (cp+1) + ")");
                Thread.sleep(delay);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(nama + " was interrupted.");
        }
        System.out.println(nama + " has finished!");
    }

    public void start()
    {
        if (thread == null)
        {
            thread = new Thread (this, nama);
            thread.start();
            System.out.println(nama + ", go!");
            System.out.println(nama + ", has passed checkpoint (1)");

        }
    }
}
