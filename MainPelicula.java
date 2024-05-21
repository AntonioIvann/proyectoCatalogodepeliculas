import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class MainPelicula {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pelicula> lista = new ArrayList<>();
        lista.add(new Pelicula("Avengers Infinity War", "accion", 2018, 231090, 19.99));
        lista.add(new Pelicula("El padrino", "crimen", 1972, 231064, 29.99));
        lista.add(new Pelicula("Narcos gays", "drama,terror,romantico", 2002, 231069, 9.99));
        lista.add(new Pelicula("Killer bean", "accion,comedia", 2008, 235690, 14.99));
        lista.add(new Pelicula("Taxi driver", "accion,crimen", 1978, 234590, 199.99));

        boolean salir = false;

        do {
            System.out.println("Menu de peliculas");
            System.out.println("1. Agregar pelicula");
            System.out.println("2. Consultar pelicula");
            System.out.println("3. Actualizar pelicula");
            System.out.println("4. Eliminar pelicula");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarPelicula(sc, lista);
                    break;

                case 2:
                    consultarPelicula(sc, lista);
                    break;

                case 3:
                    actualizarPelicula(sc, lista);
                    break;

                case 4:
                    eliminarPelicula(sc, lista);
                    break;

                case 5:
                    salir = true;
                    break;

                default:
                    System.out.println("Opcion no valida. Por favor, intente nuevamente.");
                    break;
            }
        } while (!salir);

        sc.close();
    }

    private static void agregarPelicula(Scanner sc, List<Pelicula> lista) {
        System.out.print("Ingresa el nombre de la pelicula: ");
        String nombre = sc.nextLine();

        System.out.print("A que genero pertenece: ");
        String genero = sc.nextLine();

        System.out.print("Ingresa la fecha de estreno: ");
        int año = sc.nextInt();

        System.out.print("Ingresa el ID: ");
        int id = sc.nextInt();

        System.out.print("Ingresa el precio: ");
        double precio = sc.nextDouble();

        Pelicula nuevaPelicula = new Pelicula(nombre, genero, año, id, precio);
        lista.add(nuevaPelicula);
        System.out.println("Pelicula agregada exitosamente.");
        limpiarConsolaDespuesDeTiempo();
    }

    private static void consultarPelicula(Scanner sc, List<Pelicula> lista) {
        System.out.print("Ingresa el ID de la pelicula: ");
        int idConsulta = sc.nextInt();
        Pelicula peliculaEncontrada = buscarPeliculaPorId(lista, idConsulta);
        if (peliculaEncontrada != null) {
            System.out.println(peliculaEncontrada);
        } else {
            System.out.println("Pelicula no encontrada.");
        }
        limpiarConsolaDespuesDeTiempo();
    }

    private static void actualizarPelicula(Scanner sc, List<Pelicula> lista) {
        System.out.print("Ingresa el ID de la pelicula a actualizar: ");
        int idActualizar = sc.nextInt();
        sc.nextLine();
        Pelicula peliculaActualizar = buscarPeliculaPorId(lista, idActualizar);
        if (peliculaActualizar != null) {
            System.out.print("Ingresa el nuevo titulo de la pelicula: ");
            String nuevoNombre = sc.nextLine();
            System.out.print("Ingresa el nuevo genero: ");
            String nuevoGenero = sc.nextLine();
            System.out.print("Ingresa el nuevo año de estreno: ");
            int nuevoAño = sc.nextInt();
            System.out.print("Ingresa el nuevo ID: ");
            int nuevoId = sc.nextInt();
            System.out.print("Ingresa el nuevo precio: ");
            double nuevoPrecio = sc.nextDouble();
            sc.nextLine();

            peliculaActualizar.setNombre(nuevoNombre);
            peliculaActualizar.setGenero(nuevoGenero);
            peliculaActualizar.setAño(nuevoAño);
            peliculaActualizar.setId(nuevoId);
            peliculaActualizar.setPrecio(nuevoPrecio);
            System.out.println("Pelicula actualizada exitosamente.");
        } else {
            System.out.println("Pelicula no encontrada.");
        }
        limpiarConsolaDespuesDeTiempo();
    }

    private static void eliminarPelicula(Scanner sc, List<Pelicula> lista) {
        System.out.print("Ingresa el ID de la pelicula a eliminar: ");
        int idEliminar = sc.nextInt();
        Pelicula peliculaEliminar = buscarPeliculaPorId(lista, idEliminar);
        if (peliculaEliminar != null) {
            lista.remove(peliculaEliminar);
            System.out.println("Pelicula eliminada exitosamente.");
        } else {
            System.out.println("Pelicula no encontrada.");
        }
        limpiarConsolaDespuesDeTiempo();
    }

    private static Pelicula buscarPeliculaPorId(List<Pelicula> lista, int idConsulta) {
        for (Pelicula pelicula : lista) {
            if (pelicula.getId() == idConsulta) {
                return pelicula;
            }
        }
        return null;
    }

    private static void limpiarConsolaDespuesDeTiempo() {
        try {
            Thread.sleep(5000);
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}