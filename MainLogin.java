public class MainLogin { // Declara una clase pública llamada MainLogin
    public static void main(String[] args) { // Método principal, punto de entrada del programa
        Login login = new Login(); // Crea un objeto de la clase Login llamado login
        login.authenticate(); // Llama al método authenticate() del objeto login para iniciar el proceso de autenticación
    }
}