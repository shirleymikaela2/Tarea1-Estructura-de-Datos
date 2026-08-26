#ifndef PERSONA_H
#define PERSONA_H

#include <string>
using namespace std;

class Persona {
private:
    string nombre;
    bool infectada;
    bool manosContaminadas;

public:
    Persona(string nombre, bool infectada);

    string getNombre();
    bool estaInfectada();
    bool tieneManosContaminadas();

    void contaminarManos();
    void lavarManos();
    void infectar();
    void mostrarEstado();
};

#endif