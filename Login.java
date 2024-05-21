import java.util.Scanner; // Importa la clase Scanner del paquete java.util

public class Login { // Declara una clase pública llamada Login
    private static final String USUARIO_CORRECTO = "Antonio"; // Usuario correcto almacenado como constante
    private static final String CONTRASENA_CORRECTA = "2706"; // Contraseña correcta almacenada como constante

    public void authenticate() { // Método para autenticar al usuario
        Scanner sc = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario
        String usuario, contrasena; // Declaración de variables para almacenar el usuario y la contraseña ingresados

        do { // Comienza un bucle do-while que se ejecutará al menos una vez y se repetirá mientras la condición sea verdadera
            System.out.println("Que tal, bienvenido, digite su información por favor"); // Mensaje de bienvenida e instrucciones para el usuario
            System.out.print("Usuario: "); // Solicita al usuario que ingrese su nombre de usuario
            usuario = sc.nextLine(); // Lee el nombre de usuario proporcionado por el usuario
            System.out.print("Contraseña: "); // Solicita al usuario que ingrese su contraseña
            contrasena = sc.nextLine(); // Lee la contraseña proporcionada por el usuario

            if (usuario.equals(USUARIO_CORRECTO) && contrasena.equals(CONTRASENA_CORRECTA)) { // Comprueba si el nombre de usuario y la contraseña coinciden con los valores correctos
                System.out.println("Bienvenido a tu aplicacion catálogo de peliculas"); // Mensaje de bienvenida si la autenticación es exitosa
                return; // Sale del método authenticate() después de la autenticación exitosa
            } else { // Si el nombre de usuario o la contraseña son incorrectos
                System.out.println("Contraseña incorrecta."); // Mensaje de error
                try {
                    Thread.sleep(1000); // Espera 2 segundos para dar tiempo al usuario a leer el mensaje de error
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Limpia la pantalla de la consola (funciona en Windows)
                } catch (Exception e) {
                    System.out.println(e); // Captura y muestra cualquier excepción que pueda ocurrir
                }
            }
        } while (true); // Bucle infinito para volver a solicitar la autenticación si la contraseña es incorrecta
    }
}