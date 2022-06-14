package miagenda;

public class Persona {
    String nombre;
    String ApPaterno;
    String ApMaterno;
    String telefono;
    String correo;

    public Persona() {
    }

    public Persona(String nombre, String ApPaterno, String ApMaterno, String telefono, String correo) {
        this.nombre = nombre;
        this.ApPaterno = ApPaterno;
        this.ApMaterno = ApMaterno;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return ApPaterno;
    }

    public void setApPaterno(String ApPaterno) {
        this.ApPaterno = ApPaterno;
    }

    public String getApMaterno() {
        return ApMaterno;
    }

    public void setApMaterno(String ApMaterno) {
        this.ApMaterno = ApMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return nombre+"%"+ ApPaterno + "%" + ApMaterno + "%" + telefono + "%" + correo + "\n" ;
    }
    public void mostrar() {
        System.out.println("Nombre: "+nombre+" "+ApPaterno+" "+ApMaterno);
        System.out.println("Telefono: "+telefono);
        System.out.println("Correo: "+correo);
    }
    
}
