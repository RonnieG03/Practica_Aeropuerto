package Proyecto;

public class Vuelo {
    private String identificador;
    private String ciudadOrigen;
    private String ciudadDesino;
    private Double precio;
    private int numMaxPasajeros;
    private int numActualPasajero;
    private Pasajero listaPasajero[];

    public Vuelo(String identificador, String ciudadOrigen, String ciudadDesino, Double precio, int numMaxPasajeros) {
        this.identificador = identificador;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDesino = ciudadDesino;
        this.precio = precio;
        this.numMaxPasajeros = numMaxPasajeros;
        this.numActualPasajero = 0;
        this.listaPasajero = new Pasajero[numMaxPasajeros];
    }

    public void insertarPasajero (Pasajero pasajero){
        listaPasajero[numActualPasajero] = pasajero;
        numActualPasajero++;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDesino() {
        return ciudadDesino;
    }

    public Double getPrecio() {
        return precio;
    }

    public int getNumMaxPasajeros() {
        return numMaxPasajeros;
    }

    public int getNumActualPasajero() {
        return numActualPasajero;
    }

    public Pasajero getPasajero(int i){
        return listaPasajero[i];
    }

    public Pasajero getPasajero(String pasaporte){
        boolean encontrado = false;
        int i = 0;
        Pasajero pas = null;
        while ((!encontrado) && (i<listaPasajero.length)){
            if (pasaporte.equals(listaPasajero[i].getPasaporte())){
                encontrado = true;
                pas = listaPasajero[i];
            }
            i++;
        }
        return pas;
    }

}
