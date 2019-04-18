package tanyajawabmodul3;


/**
 * Enumeration class StatusAnggota - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum StatusAnggota
{
    Active("Aktif"), Inactive("Hiatus"), Out("Keluar");
    
    private String StatusAnggota;
   
    private StatusAnggota(String StatusAnggota)
    {
        this.StatusAnggota = StatusAnggota;
    }
    
    private String StatusAnggota()
    {
        return StatusAnggota;
    }
    
}
