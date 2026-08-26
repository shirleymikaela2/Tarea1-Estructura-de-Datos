#include "Objeto.h"
#include <iostream>
using namespace std;

Objeto::Objeto(string nombre) {
    this->nombre = nombre;
    this->contaminado = false;
}

string Objeto::getNombre() {
    return nombre;
}

bool Objeto::estaContaminado() {
    return contaminado;
}

void Objeto::contaminar() {
    contaminado = true;
}

void Objeto::desinfectar() {
    contaminado = false;
}

void Objeto::mostrarEstado() {
    cout << "Objeto: " << nombre
         << " | Estado: "
         << (contaminado ? "CONTAMINADO" : "LIMPIO")
         << endl;
}