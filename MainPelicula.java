import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Pelicula {
    private String nombre;
    private String genero;
    private int año;
    private int id;
    private double precio;

    public Pelicula(String nombre, String genero, int año, int id, double precio) {
        this.nombre = nombre;
        this.genero = genero;
        this.año = año;
        this.id = id;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", año=" + año +
                ", id=" + id +
                ", precio=" + precio +
                '}';
    }
}

public class MainPelicula {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pelicula> lista = new ArrayList<>();
        lista.add(new Pelicula("Avengers", "accion", 2018, 231090, 19.99));
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
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el nombre de la pelicula: ");
                    String nombre = sc.nextLine();

                    System.out.print("A qué género pertenece: ");
                    String genero = sc.nextLine();

                    System.out.print("Ingresa el año de estreno: ");
                    int año = sc.nextInt();

                    System.out.print("Ingresa el ID: ");
                    int id = sc.nextInt();

                    System.out.print("Ingresa el precio: ");
                    double precio = sc.nextDouble();

                    Pelicula nuevaPelicula = new Pelicula(nombre, genero, año, id, precio);
                    lista.add(nuevaPelicula);
                    System.out.println("Pelicula agregada exitosamente.");
                    break;

                case 2:
                    System.out.print("Ingresa el ID de la pelicula: ");
                    int idConsulta = sc.nextInt();
                    Pelicula peliculaEncontrada = buscarPeliculaPorId(lista, idConsulta);
                    if (peliculaEncontrada != null) {
                        System.out.println(peliculaEncontrada);
                    } else {
                        System.out.println("Pelicula no encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Ingresa el ID de la pelicula a actualizar: ");
                    int idActualizar = sc.nextInt();
                    sc.nextLine(); // Consumir la nueva línea
                    Pelicula peliculaActualizar = buscarPeliculaPorId(lista, idActualizar);
                    if (peliculaActualizar != null) {
                        System.out.print("Ingresa el nuevo título de la pelicula: ");
                        String nuevoNombre = sc.nextLine();
                        System.out.print("Ingresa el nuevo género: ");
                        String nuevoGenero = sc.nextLine();
                        System.out.print("Ingresa el nuevo año de estreno: ");
                        int nuevoAño = sc.nextInt();
                        System.out.print("Ingresa el nuevo ID: ");
                        int nuevoId = sc.nextInt();
                        System.out.print("Ingresa el nuevo precio: ");
                        double nuevoPrecio = sc.nextDouble();
                        sc.nextLine(); // Consumir la nueva línea

                        peliculaActualizar.setNombre(nuevoNombre);
                        peliculaActualizar.setGenero(nuevoGenero);
                        peliculaActualizar.setAño(nuevoAño);
                        peliculaActualizar.setId(nuevoId);
                        peliculaActualizar.setPrecio(nuevoPrecio);
                        System.out.println("Pelicula actualizada exitosamente.");
                    } else {
                        System.out.println("Pelicula no encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Ingresa el ID de la pelicula a eliminar: ");
                    int idEliminar = sc.nextInt();
                    Pelicula peliculaEliminar = buscarPeliculaPorId(lista, idEliminar);
                    if (peliculaEliminar != null) {
                        lista.remove(peliculaEliminar);
                        System.out.println("Pelicula eliminada exitosamente.");
                    } else {
                        System.out.println("Pelicula no encontrada.");
                    }
                    break;

                case 5:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
                    break;
            }
        } while (!salir);

        sc.close();
    }

    private static Pelicula buscarPeliculaPorId(List<Pelicula> lista, int idConsulta) {
        for (Pelicula pelicula : lista) {
            if (pelicula.getId() == idConsulta) {
                return pelicula;
            }
        }
        return null;
    }
}
