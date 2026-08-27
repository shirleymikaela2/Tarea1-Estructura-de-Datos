package Java;

import java.util.Scanner;

public class Main {

    // ESTRUCTURA ESTATICA:
    // arreglos de tamaño fijo para almacenar máximo 10 elementos.
    private static final int MAX_PERSONAS = 10;
    private static final int MAX_OBJETOS = 10;

    private static final Persona[] personas =
            new Persona[MAX_PERSONAS];

    private static final Objeto[] objetos =
            new Objeto[MAX_OBJETOS];

    private static int cantidadPersonas = 0;
    private static int cantidadObjetos = 0;

    private static final Scanner scanner = new Scanner(System.in);

    private static final CadenaTransmision cadena =
            new CadenaTransmision();


    // -------------------------------------------------
    // REGISTRAR PERSONA
    // -------------------------------------------------
    private static void registrarPersona() {

        if (cantidadPersonas >= MAX_PERSONAS) {
            System.out.println("\nEl arreglo de personas esta lleno.");
            return;
        }

        System.out.println("\n===== REGISTRAR PERSONA =====");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Esta infectada? (1 = SI / 0 = NO): ");
        int opcion = Integer.parseInt(scanner.nextLine());

        boolean infectada = opcion == 1;

        // INSTANCIACION DE OBJETO
        personas[cantidadPersonas] =
                new Persona(nombre, infectada);

        cantidadPersonas++;

        System.out.println(
                "\nPersona registrada correctamente.");
    }


    // -------------------------------------------------
    // REGISTRAR OBJETO
    // -------------------------------------------------
    private static void registrarObjeto() {

        if (cantidadObjetos >= MAX_OBJETOS) {
            System.out.println("\nEl arreglo de objetos esta lleno.");
            return;
        }

        System.out.println("\n===== REGISTRAR OBJETO =====");

        System.out.print("Nombre del objeto: ");
        String nombre = scanner.nextLine();

        // INSTANCIACION DE OBJETO
        objetos[cantidadObjetos] =
                new Objeto(nombre);

        cantidadObjetos++;

        System.out.println(
                "\nObjeto registrado correctamente.");
    }


    // -------------------------------------------------
    // LISTAR PERSONAS
    // -------------------------------------------------
    private static void listarPersonas() {

        if (cantidadPersonas == 0) {
            System.out.println(
                    "\nNo existen personas registradas.");
            return;
        }

        System.out.println(
                "\n===== PERSONAS REGISTRADAS =====");

        for (int i = 0; i < cantidadPersonas; i++) {

            System.out.print(i + ". ");
            personas[i].mostrarEstado();
        }
    }


    // -------------------------------------------------
    // LISTAR OBJETOS
    // -------------------------------------------------
    private static void listarObjetos() {

        if (cantidadObjetos == 0) {
            System.out.println(
                    "\nNo existen objetos registrados.");
            return;
        }

        System.out.println(
                "\n===== OBJETOS REGISTRADOS =====");

        for (int i = 0; i < cantidadObjetos; i++) {

            System.out.print(i + ". ");
            objetos[i].mostrarEstado();
        }
    }


    // -------------------------------------------------
    // PERSONA INFECTADA CONTAMINA OBJETO
    // -------------------------------------------------
    private static void estornudarSobreObjeto() {

        if (cantidadPersonas == 0 ||
                cantidadObjetos == 0) {

            System.out.println(
                    "\nDebe registrar personas y objetos primero.");
            return;
        }

        listarPersonas();

        System.out.print(
                "\nSeleccione persona: ");

        int persona =
                Integer.parseInt(scanner.nextLine());

        listarObjetos();

        System.out.print(
                "\nSeleccione objeto: ");

        int objeto =
                Integer.parseInt(scanner.nextLine());

        if (persona < 0 ||
                persona >= cantidadPersonas ||
                objeto < 0 ||
                objeto >= cantidadObjetos) {

            System.out.println(
                    "\nSeleccion invalida.");
            return;
        }

        System.out.println(
                "\n" +
                cadena.estornudarSobreObjeto(
                        personas[persona],
                        objetos[objeto]));
    }


    // -------------------------------------------------
    // PERSONA TOCA OBJETO
    // -------------------------------------------------
    private static void tocarObjeto() {

        if (cantidadPersonas == 0 ||
                cantidadObjetos == 0) {

            System.out.println(
                    "\nDebe registrar personas y objetos primero.");
            return;
        }

        listarPersonas();

        System.out.print(
                "\nSeleccione persona: ");

        int persona =
                Integer.parseInt(scanner.nextLine());

        listarObjetos();

        System.out.print(
                "\nSeleccione objeto: ");

        int objeto =
                Integer.parseInt(scanner.nextLine());

        if (persona < 0 ||
                persona >= cantidadPersonas ||
                objeto < 0 ||
                objeto >= cantidadObjetos) {

            System.out.println(
                    "\nSeleccion invalida.");
            return;
        }

        System.out.println(
                "\n" +
                cadena.tocarObjeto(
                        personas[persona],
                        objetos[objeto]));
    }


    // -------------------------------------------------
    // CONTACTO ENTRE PERSONAS
    // -------------------------------------------------
    private static void tenerContacto() {

        if (cantidadPersonas < 2) {

            System.out.println(
                    "\nDebe registrar al menos dos personas.");
            return;
        }

        listarPersonas();

        System.out.print(
                "\nSeleccione persona de origen: ");

        int origen =
                Integer.parseInt(scanner.nextLine());

        System.out.print(
                "Seleccione persona de destino: ");

        int destino =
                Integer.parseInt(scanner.nextLine());

        if (origen < 0 ||
                origen >= cantidadPersonas ||
                destino < 0 ||
                destino >= cantidadPersonas) {

            System.out.println(
                    "\nSeleccion invalida.");
            return;
        }

        try {

            System.out.println(
                    "\n" +
                    cadena.tenerContacto(
                            personas[origen],
                            personas[destino]));

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "\nError: " + e.getMessage());
        }
    }


    // -------------------------------------------------
    // TOCAR ROSTRO
    // -------------------------------------------------
    private static void tocarRostro() {

        if (cantidadPersonas == 0) {

            System.out.println(
                    "\nNo existen personas registradas.");
            return;
        }

        listarPersonas();

        System.out.print(
                "\nSeleccione persona: ");

        int persona =
                Integer.parseInt(scanner.nextLine());

        if (persona < 0 ||
                persona >= cantidadPersonas) {

            System.out.println(
                    "\nSeleccion invalida.");
            return;
        }

        System.out.println(
                "\n" +
                cadena.tocarRostro(
                        personas[persona]));
    }


    // -------------------------------------------------
    // LAVAR MANOS
    // -------------------------------------------------
    private static void lavarManos() {

        if (cantidadPersonas == 0) {

            System.out.println(
                    "\nNo existen personas registradas.");
            return;
        }

        listarPersonas();

        System.out.print(
                "\nSeleccione persona: ");

        int persona =
                Integer.parseInt(scanner.nextLine());

        if (persona < 0 ||
                persona >= cantidadPersonas) {

            System.out.println(
                    "\nSeleccion invalida.");
            return;
        }

        System.out.println(
                "\n" +
                cadena.lavarManos(
                        personas[persona]));
    }


    // -------------------------------------------------
    // DESINFECTAR OBJETO
    // -------------------------------------------------
    private static void desinfectarObjeto() {

        if (cantidadObjetos == 0) {

            System.out.println(
                    "\nNo existen objetos registrados.");
            return;
        }

        listarObjetos();

        System.out.print(
                "\nSeleccione objeto: ");

        int objeto =
                Integer.parseInt(scanner.nextLine());

        if (objeto < 0 ||
                objeto >= cantidadObjetos) {

            System.out.println(
                    "\nSeleccion invalida.");
            return;
        }

        System.out.println(
                "\n" +
                cadena.desinfectarObjeto(
                        objetos[objeto]));
    }


    // -------------------------------------------------
    // MAIN - MENU POR CONSOLA
    // -------------------------------------------------
    public static void main(String[] args) {

        int opcion;

        do {

            System.out.println(
                    "\n======================================");
            System.out.println(
                    "          TDA CORONAVIRUS");
            System.out.println(
                    "======================================");

            System.out.println("1. Registrar persona");
            System.out.println("2. Registrar objeto");
            System.out.println("3. Listar personas");
            System.out.println("4. Listar objetos");
            System.out.println("5. Estornudar sobre objeto");
            System.out.println("6. Tocar objeto");
            System.out.println("7. Contacto entre personas");
            System.out.println("8. Tocar rostro");
            System.out.println("9. Lavar manos");
            System.out.println("10. Desinfectar objeto");
            System.out.println("0. Salir");

            System.out.println(
                    "======================================");

            System.out.print(
                    "Seleccione una opcion: ");

            opcion =
                    Integer.parseInt(scanner.nextLine());

            switch (opcion) {

                case 1:
                    registrarPersona();
                    break;

                case 2:
                    registrarObjeto();
                    break;

                case 3:
                    listarPersonas();
                    break;

                case 4:
                    listarObjetos();
                    break;

                case 5:
                    estornudarSobreObjeto();
                    break;

                case 6:
                    tocarObjeto();
                    break;

                case 7:
                    tenerContacto();
                    break;

                case 8:
                    tocarRostro();
                    break;

                case 9:
                    lavarManos();
                    break;

                case 10:
                    desinfectarObjeto();
                    break;

                case 0:
                    System.out.println(
                            "\nPrograma finalizado.");
                    break;

                default:
                    System.out.println(
                            "\nOpcion invalida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}