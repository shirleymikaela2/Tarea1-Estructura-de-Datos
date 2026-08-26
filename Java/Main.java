package Java;

public class Main {

    public static void main(String[] args) {
        ejecutarCasoContagio();
        ejecutarCasoPrevencion();
    }

    private static void ejecutarCasoContagio() {
        System.out.println("==================================================");
        System.out.println("CASO 1: CADENA DE TRANSMISION COMPLETA");
        System.out.println("==================================================");

        Persona carlos = new Persona("Carlos", true);
        Persona ana = new Persona("Ana", false);
        Persona luis = new Persona("Luis", false);

        Objeto teclado = new Objeto("Teclado del computador");

        CadenaTransmision cadena = new CadenaTransmision();

        mostrarEstadoInicial(carlos, ana, luis, teclado);

        ejecutarPaso(1, cadena.estornudarSobreObjeto(carlos, teclado));
        ejecutarPaso(2, cadena.tocarObjeto(ana, teclado));
        ejecutarPaso(3, cadena.tenerContacto(ana, luis));
        ejecutarPaso(4, cadena.tocarRostro(luis));

        System.out.println("\nESTADO FINAL DEL CASO 1");

        carlos.mostrarEstado();
        ana.mostrarEstado();
        luis.mostrarEstado();
        teclado.mostrarEstado();
    }

    private static void ejecutarCasoPrevencion() {
        System.out.println("\n==================================================");
        System.out.println("CASO 2: INTERRUPCION MEDIANTE LAVADO DE MANOS");
        System.out.println("==================================================");

        Persona maria = new Persona("Maria", true);
        Persona pedro = new Persona("Pedro", false);

        Objeto celular = new Objeto("Telefono celular");

        CadenaTransmision cadena = new CadenaTransmision();

        ejecutarPaso(1, cadena.estornudarSobreObjeto(maria, celular));
        ejecutarPaso(2, cadena.tocarObjeto(pedro, celular));
        ejecutarPaso(3, cadena.lavarManos(pedro));
        ejecutarPaso(4, cadena.tocarRostro(pedro));
        ejecutarPaso(5, cadena.desinfectarObjeto(celular));

        System.out.println("\nESTADO FINAL DEL CASO 2");

        maria.mostrarEstado();
        pedro.mostrarEstado();
        celular.mostrarEstado();
    }

    private static void mostrarEstadoInicial(
            Persona persona1,
            Persona persona2,
            Persona persona3,
            Objeto objeto) {

        System.out.println("\nESTADO INICIAL");

        persona1.mostrarEstado();
        persona2.mostrarEstado();
        persona3.mostrarEstado();
        objeto.mostrarEstado();
    }

    private static void ejecutarPaso(int numero, String resultado) {
        System.out.println("\nPASO " + numero);
        System.out.println(resultado);
    }
}