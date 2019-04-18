package tanyajawabmodul3;


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
    public Anggota(
        String nama, 
        StatusAnggota status,
        String role
    )
    {
        this.nama = nama;
        this.status = status;
        this.role = role;
    }
    
    public String getNama(String nama)
    {
        return nama;
    }
    public StatusAnggota getStatus(StatusAnggota status)
    {
        return status;
    }
    public String getRole(String role)
    {
        return role;
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
    
    public void printData()
    {
        System.out.println("Nama = " + nama);
        System.out.println("Status = " + status);
        System.out.println("Role = " + role);
    }
}
