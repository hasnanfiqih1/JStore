
/**
 * Enumeration class Status - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Status
{
    Active("Aktif"),
    Inactive("Hiatus"),
    Out ("Keluar");
    
    
    public String desc;
    
    Status(String desc)
    {
        this.desc=desc;
    }   
    
    public String toString()
    {
        return desc;
    }
}   