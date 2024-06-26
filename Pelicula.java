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
        return "Pelicula [nombre=" + nombre + ", genero=" + genero + ", año=" + año + ", id=" + id + ", precio=" + precio + "]";
    }
}