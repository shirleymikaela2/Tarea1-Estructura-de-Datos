#include "Persona.h"
#include <iostream>
using namespace std;

Persona::Persona(string nombre, bool infectada) {
    this->nombre = nombre;
    this->infectada = infectada;
    this->manosContaminadas = false;
}

string Persona::getNombre() {
    return nombre;
}

bool Persona::estaInfectada() {
    return infectada;
}

bool Persona::tieneManosContaminadas() {
    return manosContaminadas;
}

void Persona::contaminarManos() {
    manosContaminadas = true;
}

void Persona::lavarManos() {
    manosContaminadas = false;
}

void Persona::infectar() {
    infectada = true;
}

void Persona::mostrarEstado() {
    cout << "Persona: " << nombre
         << " | Infectada: " << (infectada ? "SI" : "NO")
         << " | Manos contaminadas: "
         << (manosContaminadas ? "SI" : "NO")
         << endl;
}