package Java;

class CadenaTransmision {

    public String estornudarSobreObjeto(Persona persona, Objeto objeto) {
        validarPersona(persona);
        validarObjeto(objeto);

        if (!persona.estaInfectada()) {
            return persona.getNombre()
                    + " no esta infectada; "
                    + objeto.getNombre()
                    + " permanece limpio.";
        }

        objeto.contaminar();

        return persona.getNombre()
                + " estornuda cerca de "
                + objeto.getNombre()
                + ". El objeto queda contaminado.";
    }

    public String tocarObjeto(Persona persona, Objeto objeto) {
        validarPersona(persona);
        validarObjeto(objeto);

        if (!objeto.estaContaminado()) {
            return persona.getNombre()
                    + " toca "
                    + objeto.getNombre()
                    + ", pero el objeto esta limpio.";
        }

        persona.contaminarManos();

        return persona.getNombre()
                + " toca "
                + objeto.getNombre()
                + ". Sus manos quedan contaminadas, pero la persona todavia no esta infectada.";
    }

    public String tenerContacto(Persona origen, Persona destino) {
        validarPersona(origen);
        validarPersona(destino);

        if (origen == destino) {
            throw new IllegalArgumentException(
                    "El origen y el destino deben ser personas diferentes.");
        }

        if (!origen.tieneManosContaminadas()) {
            return origen.getNombre()
                    + " tiene contacto con "
                    + destino.getNombre()
                    + ", pero no transmite contaminacion.";
        }

        destino.contaminarManos();

        return origen.getNombre()
                + " tiene contacto con "
                + destino.getNombre()
                + ". "
                + destino.getNombre()
                + " queda como portador temporal en sus manos.";
    }

    public String tocarRostro(Persona persona) {
        validarPersona(persona);

        if (!persona.tieneManosContaminadas()) {
            return persona.getNombre()
                    + " se toca ojos, nariz o boca, pero no se infecta porque sus manos estan limpias.";
        }

        if (persona.estaInfectada()) {
            return persona.getNombre()
                    + " se toca el rostro, pero ya constaba como persona infectada.";
        }

        persona.infectar();

        return persona.getNombre()
                + " se toca ojos, nariz o boca con las manos contaminadas y se infecta.";
    }

    public String lavarManos(Persona persona) {
        validarPersona(persona);

        persona.lavarManos();

        return persona.getNombre()
                + " se lava las manos. La cadena de transmision por contacto se interrumpe.";
    }

    public String desinfectarObjeto(Objeto objeto) {
        validarObjeto(objeto);

        objeto.desinfectar();

        return objeto.getNombre()
                + " fue desinfectado y queda limpio.";
    }

    private void validarPersona(Persona persona) {
        if (persona == null) {
            throw new IllegalArgumentException(
                    "La persona no puede ser nula.");
        }
    }

    private void validarObjeto(Objeto objeto) {
        if (objeto == null) {
            throw new IllegalArgumentException(
                    "El objeto no puede ser nulo.");
        }
    }
}
