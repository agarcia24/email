package net.ausiasmarch.examen.modelo;

/**
 *
 * @author Adrian Garcia Vicente
 */
public class SeguroMedico {

    private String mensaje, trabajo;
    private int edad, numHijos;
    private boolean hombre, mujer;
    private boolean casado, embarazada;
    private boolean enfermedadCorazon, enfermedadOjos, enfermedadPiel;
    private boolean coberturaCorazon, coberturaOftalmologica, coberturaInVitro;
    private boolean coberturaPediatria, coberturaDermatologia;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public boolean isHombre() {
        return hombre;
    }

    public void setHombre(boolean hombre) {
        this.hombre = hombre;
    }

    public boolean isMujer() {
        return mujer;
    }

    public void setMujer(boolean mujer) {
        this.mujer = mujer;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public boolean isEmbarazada() {
        return embarazada;
    }

    public void setEmbarazada(boolean embarazada) {
        this.embarazada = embarazada;
    }

    public boolean isEnfermedadCorazon() {
        return enfermedadCorazon;
    }

    public void setEnfermedadCorazon(boolean enfermedadCorazon) {
        this.enfermedadCorazon = enfermedadCorazon;
    }

    public boolean isEnfermedadOjos() {
        return enfermedadOjos;
    }

    public void setEnfermedadOjos(boolean enfermedadOjos) {
        this.enfermedadOjos = enfermedadOjos;
    }

    public boolean isEnfermedadPiel() {
        return enfermedadPiel;
    }

    public void setEnfermedadPiel(boolean enfermedadPiel) {
        this.enfermedadPiel = enfermedadPiel;
    }

    public boolean isCoberturaCorazon() {
        return coberturaCorazon;
    }

    public void setCoberturaCorazon(boolean coberturaCorazon) {
        this.coberturaCorazon = coberturaCorazon;
    }

    public boolean isCoberturaOftalmologica() {
        return coberturaOftalmologica;
    }

    public void setCoberturaOftalmologica(boolean coberturaOftalmologica) {
        this.coberturaOftalmologica = coberturaOftalmologica;
    }

    public boolean isCoberturaInVitro() {
        return coberturaInVitro;
    }

    public void setCoberturaInVitro(boolean coberturaInVitro) {
        this.coberturaInVitro = coberturaInVitro;
    }

    public boolean isCoberturaPediatria() {
        return coberturaPediatria;
    }

    public void setCoberturaPediatria(boolean coberturaPediatria) {
        this.coberturaPediatria = coberturaPediatria;
    }

    public boolean isCoberturaDermatologia() {
        return coberturaDermatologia;
    }

    public void setCoberturaDermatologia(boolean coberturaDermatologia) {
        this.coberturaDermatologia = coberturaDermatologia;
    }

    //Metodos
    public boolean aceptado() {

        /* •La edad debe ser mayor o igual de 18 años
         Si eligió ’‘Embarazada’ o cobertura ‘Fecundación in vitro, el sexo debe ser ‘Mujer’.
         El número de hijos debe ser mayor o igual que cero
         Con cobertura ‘Pediatría’ el número de hijos debe ser mayor de cero
         Si seleccionó la cobertura ‘Dermatológica” debe seleccionar la enfermedad ‘Piel’
         Si seleccionó la cobertura ‘Corazón” debe seleccionar la enfermedad ‘Corazón’
         Si seleccionó la cobertura Oftalmología” debe seleccionar la enfermedad ‘Ojos’
         */
        if (edad < 18) {
            mensaje = "La edad debe ser minimo 18 años";
            return false;
        }
        if (hombre && (embarazada || coberturaInVitro)) {
            mensaje = "Si eligió ’‘Embarazada’ o cobertura ‘Fecundación in vitro, el sexo debe ser ‘Mujer’";
            return false;
        }
        if (numHijos <= 0) {
            mensaje = "El número de hijos debe ser mayor o igual que cero";
            return false;
        }
        if (coberturaDermatologia == true && enfermedadPiel == false) {
            mensaje = "Si seleccionó la cobertura Dermatológica debe seleccionar la enfermedad Piel";
            return false;
        }
        if (coberturaCorazon == true && enfermedadCorazon == false) {
            mensaje = "Si seleccionó la cobertura Corazón debe seleccionar la enfermedad Corazón";
            return false;
        }
        if (coberturaOftalmologica == true && enfermedadOjos == false) {
            mensaje = "Si seleccionó la cobertura Oftalmología debe seleccionar la enfermedad Ojos";
            return false;
        }
        return true;
    }

    public double importeMensual() {

        //creamos una variable para fijar la cuantia del importeMensual
        double importeMensual = 200;

        //Por cada enfermedad que padezca de añadirán 15 € más. (Crear 3 IF)
        if (enfermedadOjos) {
            importeMensual = importeMensual + 15;
        }
        if (enfermedadPiel) {
            importeMensual = importeMensual + 15;
        }
        if (enfermedadCorazon) {
            importeMensual = importeMensual + 15;
        }
        //Por cada cobertura añadirle un sobre-coste (al igual que con las enfermedades)
        if (coberturaOftalmologica) {
            importeMensual = importeMensual + 15;
        }
        if (coberturaPediatria) {
            importeMensual = importeMensual + 15;
        }
        if (coberturaInVitro) {
            importeMensual = importeMensual + 40;
        }
        if (coberturaCorazon) {
            importeMensual = importeMensual + 50;
        }
        if (coberturaDermatologia) {
            importeMensual = importeMensual + 25;
        }
        return importeMensual;
    }

    private double descuento() {

        // creamos variable descuento aqui con valor 0
        double descuento = 0;
        //toUPPERCase para dentro del case tenemos que ponerlas en MAYUSCULAS
        //si fuera toLOWERCase lo hariamos en minusculas dentro del CASE
        trabajo = trabajo.toUpperCase();
        //Dentro del SWITCH ponemos los diferentes casos de las opciones
        switch (trabajo) {
            case "FUNCIONARIO":
                descuento = 15;
            case "CONTRATADO":
                descuento = 5;
            case "AUTÓNOMO":
                descuento = 5;
        }

        return (12 * importeMensual()) * (descuento / 100);
    }

    /**
     * Asi tenemos el importe anual 
     * @return importe mensual x 12 meses - el descuento que le hayamos hecho
     */
    public double importeAnual() {
        return (importeMensual() * 12) - descuento();
    }
}
