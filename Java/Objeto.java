package Java;

class Objeto {
    private final String nombre;
    private boolean contaminado;

    public Objeto(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del objeto no puede estar vacio.");
        }

        this.nombre = nombre;
        this.contaminado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaContaminado() {
        return contaminado;
    }

    void contaminar() {
        contaminado = true;
    }

    void desinfectar() {
        contaminado = false;
    }

    public void mostrarEstado() {
        String estado = contaminado ? "CONTAMINADO" : "LIMPIO";
        System.out.printf("Objeto:  %-22s | Estado: %s%n", nombre, estado);
    }
}
