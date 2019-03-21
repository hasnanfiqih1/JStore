package TanyaJawabModul3;


/**
 * Enumeration class StatusAnggota - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum StatusAnggota
{
    Active("Aktif"), Inactive("Hiatus"), Out("Keluar");
    
    private String value;
    
    private StatusAnggota (String value)
    {
        this.value = value;
    }
    
    public String value()
    {
        return value;
    }
}
