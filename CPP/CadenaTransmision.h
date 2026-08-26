#ifndef CADENATRANSMISION_H
#define CADENATRANSMISION_H

#include <string>
#include "Persona.h"
#include "Objeto.h"

using namespace std;

class CadenaTransmision {
public:
    string estornudarSobreObjeto(Persona* persona, Objeto* objeto);

    string tocarObjeto(Persona* persona, Objeto* objeto);

    string tenerContacto(Persona* origen, Persona* destino);

    string tocarRostro(Persona* persona);

    string lavarManos(Persona* persona);

    string desinfectarObjeto(Objeto* objeto);

private:
    void validarPersona(Persona* persona);
    void validarObjeto(Objeto* objeto);
};

#endif