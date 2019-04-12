
/**
 * Write a description of class Anggota here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Anggota
{
    private String name;
    private Status status;
    private String role;

    /**
     * Constructor for objects of class Anggota
     */
    public Anggota(String name, Status status, String role)
    {
        this.name=name;
        this.status=status;
        this.role=role;
    }
    
    private String getNama()
    {
        return name;
    }
    
    private Status getStatus()
    {
        return status;
    }
    
    private String getRole()
    {
        return role;
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
    
    public void setStatus(Status status)
    {
        this.status=status;
    }
    
    public void setRole(String role)
    {
        this.role=role;
    }
    public void print()
    {
       System.out.println (name+ "berstatus sebagai" + role + "Beranggota" + status);
       
    }
}

