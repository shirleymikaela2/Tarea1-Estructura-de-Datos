#include <iostream>
#include "Persona.h"
#include "Objeto.h"
#include "CadenaTransmision.h"

using namespace std;

void ejecutarPaso(int numero, string resultado) {
    cout << "\nPASO " << numero << endl;
    cout << resultado << endl;
}

void ejecutarCasoContagio() {
    cout << "==================================================" << endl;
    cout << "CASO 1: CADENA DE TRANSMISION COMPLETA" << endl;
    cout << "==================================================" << endl;

    Persona carlos("Carlos", true);
    Persona ana("Ana", false);
    Persona luis("Luis", false);

    Objeto teclado("Teclado del computador");
 
    CadenaTransmision cadena;

    cout << "\nESTADO INICIAL" << endl;

    carlos.mostrarEstado();
    ana.mostrarEstado();
    luis.mostrarEstado();
    teclado.mostrarEstado();

    ejecutarPaso(1, cadena.estornudarSobreObjeto(&carlos, &teclado));
    ejecutarPaso(2, cadena.tocarObjeto(&ana, &teclado));
    ejecutarPaso(3, cadena.tenerContacto(&ana, &luis));
    ejecutarPaso(4, cadena.tocarRostro(&luis));

    cout << "\nESTADO FINAL DEL CASO 1" << endl;

    carlos.mostrarEstado();
    ana.mostrarEstado();
    luis.mostrarEstado();
    teclado.mostrarEstado();
}

void ejecutarCasoPrevencion() {
    cout << "\n==================================================" << endl;
    cout << "CASO 2: INTERRUPCION MEDIANTE LAVADO DE MANOS" << endl;
    cout << "==================================================" << endl;

    Persona maria("Maria", true);
    Persona pedro("Pedro", false);

    Objeto celular("Telefono celular");

    CadenaTransmision cadena;

    ejecutarPaso(1, cadena.estornudarSobreObjeto(&maria, &celular));
    ejecutarPaso(2, cadena.tocarObjeto(&pedro, &celular));
    ejecutarPaso(3, cadena.lavarManos(&pedro));
    ejecutarPaso(4, cadena.tocarRostro(&pedro));
    ejecutarPaso(5, cadena.desinfectarObjeto(&celular));

    cout << "\nESTADO FINAL DEL CASO 2" << endl;

    maria.mostrarEstado();
    pedro.mostrarEstado();
    celular.mostrarEstado();
}

int main() {
    ejecutarCasoContagio();
    ejecutarCasoPrevencion();

    return 0;
}