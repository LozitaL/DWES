
package Menu;

/**
 *
 * @author 2º DAW
 */
public class EntMenu {
    private int codigo;
    private String nombre;
    private String url;
    private int orden;

    public EntMenu(int codigo, String nombre, String url, int orden) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.url = url;
        this.orden = orden;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }

    public int getOrden() {
        return orden;
    }
    
    
}
