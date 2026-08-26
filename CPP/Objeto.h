  #ifndef OBJETO_H
#define OBJETO_H

#include <string>
using namespace std;

class Objeto {
private:
    string nombre;
    bool contaminado;

public:
    Objeto(string nombre);

    string getNombre();
    bool estaContaminado();

    void contaminar();
    void desinfectar();
    void mostrarEstado();
};

#endif