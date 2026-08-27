#include <iostream>
#include <string>

#include "Persona.h"
#include "Objeto.h"
#include "CadenaTransmision.h"

using namespace std;

// CAPACIDAD FIJA = ESTRUCTURA ESTATICA
const int MAX_PERSONAS = 10;
const int MAX_OBJETOS = 10;

// ARREGLOS ESTATICOS
Persona* personas[MAX_PERSONAS] = {nullptr};
Objeto* objetos[MAX_OBJETOS] = {nullptr};

int cantidadPersonas = 0;
int cantidadObjetos = 0;


// -------------------------------------------------
// MOSTRAR PERSONAS REGISTRADAS
// -------------------------------------------------
void listarPersonas() {

    if (cantidadPersonas == 0) {
        cout << "\nNo existen personas registradas.\n";
        return;
    }

    cout << "\n===== PERSONAS REGISTRADAS =====\n";

    for (int i = 0; i < cantidadPersonas; i++) {
        cout << i << ". ";
        personas[i]->mostrarEstado();
    }
}


// -------------------------------------------------
// MOSTRAR OBJETOS REGISTRADOS
// -------------------------------------------------
void listarObjetos() {

    if (cantidadObjetos == 0) {
        cout << "\nNo existen objetos registrados.\n";
        return;
    }

    cout << "\n===== OBJETOS REGISTRADOS =====\n";

    for (int i = 0; i < cantidadObjetos; i++) {
        cout << i << ". ";
        objetos[i]->mostrarEstado();
    }
}


// -------------------------------------------------
// REGISTRAR PERSONA
// -------------------------------------------------
void registrarPersona() {

    if (cantidadPersonas >= MAX_PERSONAS) {
        cout << "\nEl arreglo de personas esta lleno.\n";
        return;
    }

    string nombre;
    int infectada;

    cout << "\n===== REGISTRAR PERSONA =====\n";

    cout << "Nombre: ";
    cin >> ws;
    getline(cin, nombre);

    cout << "Esta infectada? (1 = SI / 0 = NO): ";
    cin >> infectada;

    // INSTANCIACION DE OBJETO
    personas[cantidadPersonas] =
        new Persona(nombre, infectada == 1);

    cantidadPersonas++;

    cout << "\nPersona registrada correctamente.\n";
}


// -------------------------------------------------
// REGISTRAR OBJETO
// -------------------------------------------------
void registrarObjeto() {

    if (cantidadObjetos >= MAX_OBJETOS) {
        cout << "\nEl arreglo de objetos esta lleno.\n";
        return;
    }

    string nombre;

    cout << "\n===== REGISTRAR OBJETO =====\n";

    cout << "Nombre del objeto: ";
    cin >> ws;
    getline(cin, nombre);

    // INSTANCIACION DE OBJETO
    objetos[cantidadObjetos] =
        new Objeto(nombre);

    cantidadObjetos++;

    cout << "\nObjeto registrado correctamente.\n";
}


// -------------------------------------------------
// PERSONA INFECTADA CONTAMINA OBJETO
// -------------------------------------------------
void estornudarSobreObjeto(CadenaTransmision& cadena) {

    if (cantidadPersonas == 0 || cantidadObjetos == 0) {
        cout << "\nDebe registrar personas y objetos primero.\n";
        return;
    }

    listarPersonas();
    int persona;

    cout << "\nSeleccione persona: ";
    cin >> persona;

    listarObjetos();
    int objeto;

    cout << "\nSeleccione objeto: ";
    cin >> objeto;

    if (persona < 0 || persona >= cantidadPersonas ||
        objeto < 0 || objeto >= cantidadObjetos) {

        cout << "\nSeleccion invalida.\n";
        return;
    }

    cout << "\n"
         << cadena.estornudarSobreObjeto(
                personas[persona],
                objetos[objeto])
         << endl;
}


// -------------------------------------------------
// PERSONA TOCA OBJETO
// -------------------------------------------------
void tocarObjeto(CadenaTransmision& cadena) {

    if (cantidadPersonas == 0 || cantidadObjetos == 0) {
        cout << "\nDebe registrar personas y objetos primero.\n";
        return;
    }

    listarPersonas();

    int persona;
    cout << "\nSeleccione persona: ";
    cin >> persona;

    listarObjetos();

    int objeto;
    cout << "\nSeleccione objeto: ";
    cin >> objeto;

    if (persona < 0 || persona >= cantidadPersonas ||
        objeto < 0 || objeto >= cantidadObjetos) {

        cout << "\nSeleccion invalida.\n";
        return;
    }

    cout << "\n"
         << cadena.tocarObjeto(
                personas[persona],
                objetos[objeto])
         << endl;
}


// -------------------------------------------------
// CONTACTO ENTRE PERSONAS
// -------------------------------------------------
void tenerContacto(CadenaTransmision& cadena) {

    if (cantidadPersonas < 2) {
        cout << "\nDebe registrar al menos dos personas.\n";
        return;
    }

    listarPersonas();

    int origen;
    int destino;

    cout << "\nSeleccione persona de origen: ";
    cin >> origen;

    cout << "Seleccione persona de destino: ";
    cin >> destino;

    if (origen < 0 || origen >= cantidadPersonas ||
        destino < 0 || destino >= cantidadPersonas) {

        cout << "\nSeleccion invalida.\n";
        return;
    }

    try {

        cout << "\n"
             << cadena.tenerContacto(
                    personas[origen],
                    personas[destino])
             << endl;

    } catch (const exception& e) {

        cout << "\nError: " << e.what() << endl;
    }
}


// -------------------------------------------------
// TOCAR ROSTRO
// -------------------------------------------------
void tocarRostro(CadenaTransmision& cadena) {

    if (cantidadPersonas == 0) {
        cout << "\nNo existen personas registradas.\n";
        return;
    }

    listarPersonas();

    int persona;

    cout << "\nSeleccione persona: ";
    cin >> persona;

    if (persona < 0 || persona >= cantidadPersonas) {

        cout << "\nSeleccion invalida.\n";
        return;
    }

    cout << "\n"
         << cadena.tocarRostro(personas[persona])
         << endl;
}


// -------------------------------------------------
// LAVAR MANOS
// -------------------------------------------------
void lavarManos(CadenaTransmision& cadena) {

    if (cantidadPersonas == 0) {
        cout << "\nNo existen personas registradas.\n";
        return;
    }

    listarPersonas();

    int persona;

    cout << "\nSeleccione persona: ";
    cin >> persona;

    if (persona < 0 || persona >= cantidadPersonas) {

        cout << "\nSeleccion invalida.\n";
        return;
    }

    cout << "\n"
         << cadena.lavarManos(personas[persona])
         << endl;
}


// -------------------------------------------------
// DESINFECTAR OBJETO
// -------------------------------------------------
void desinfectarObjeto(CadenaTransmision& cadena) {

    if (cantidadObjetos == 0) {
        cout << "\nNo existen objetos registrados.\n";
        return;
    }

    listarObjetos();

    int objeto;

    cout << "\nSeleccione objeto: ";
    cin >> objeto;

    if (objeto < 0 || objeto >= cantidadObjetos) {

        cout << "\nSeleccion invalida.\n";
        return;
    }

    cout << "\n"
         << cadena.desinfectarObjeto(objetos[objeto])
         << endl;
}


// -------------------------------------------------
// LIBERAR MEMORIA
// -------------------------------------------------
void liberarMemoria() {

    for (int i = 0; i < cantidadPersonas; i++) {
        delete personas[i];
    }

    for (int i = 0; i < cantidadObjetos; i++) {
        delete objetos[i];
    }
}


// -------------------------------------------------
// MAIN - MENU POR CONSOLA
// -------------------------------------------------
int main() {

    CadenaTransmision cadena;

    int opcion;

    do {

        cout << "\n======================================\n";
        cout << "        TDA CORONAVIRUS\n";
        cout << "======================================\n";
        cout << "1. Registrar persona\n";
        cout << "2. Registrar objeto\n";
        cout << "3. Listar personas\n";
        cout << "4. Listar objetos\n";
        cout << "5. Estornudar sobre objeto\n";
        cout << "6. Tocar objeto\n";
        cout << "7. Contacto entre personas\n";
        cout << "8. Tocar rostro\n";
        cout << "9. Lavar manos\n";
        cout << "10. Desinfectar objeto\n";
        cout << "0. Salir\n";
        cout << "======================================\n";

        cout << "Seleccione una opcion: ";
        cin >> opcion;

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
                estornudarSobreObjeto(cadena);
                break;

            case 6:
                tocarObjeto(cadena);
                break;

            case 7:
                tenerContacto(cadena);
                break;

            case 8:
                tocarRostro(cadena);
                break;

            case 9:
                lavarManos(cadena);
                break;

            case 10:
                desinfectarObjeto(cadena);
                break;

            case 0:
                cout << "\nPrograma finalizado.\n";
                break;

            default:
                cout << "\nOpcion invalida.\n";
        }

    } while (opcion != 0);

    liberarMemoria();

    return 0;
}