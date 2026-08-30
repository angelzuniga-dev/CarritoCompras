public class Usuario extends Persona {
    private String username;
    private String password;

    public Usuario(String nombre, String documentoIdentidad, String username, String password) {
        super(nombre, documentoIdentidad);
        this.username = username;
        this.password = password;
    }
}