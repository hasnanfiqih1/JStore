package TanyaJawabModul3;


/**
 * Write a description of class Anggota here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Anggota
{
    // instance variables - replace the example below with your own
    private String nama;
    private StatusAnggota status;
    private String role;

    /**
     * Constructor for objects of class Anggota
     */
    public Anggota(String nama, StatusAnggota status, String role)
    {
        this.nama = nama;
        this.status = status;
        this.role = role;
    }

    public void setNama(String nama)
    {
        this.nama = nama;
    }
    
    public void setStatus(StatusAnggota status)
    {
        this.status = status;
    }
    
    public void setRole(String role)
    {
        this.role = role;
    }
    
    public String getNama()
    {
        return nama;
    }
    
    public StatusAnggota getStatus()
    {
        return status;
    }
    
    public String getRole()
    {
        return role;
    }
    
    public void printData()
    {
     System.out.println("========ANGGOTA========");
     System.out.println("Nama: "+nama);
     System.out.println("Status: "+status);
     System.out.println("Role: "+role);
     System.out.println("=======================");
    }
}
