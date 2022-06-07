package Proyecto;

import java.awt.*;
import java.util.Scanner;

public class Principal {
    static Scanner entrada = new Scanner(System.in);
    final static int num = 4; //Numero de aeropuertos
    static Aeropuerto[] aeropuertos = new Aeropuerto[num];


    public static void main(String[] args) {

        //insertar datos de los aeropertos
        insertarDatosAeropuerto(aeropuertos);
        Menu();
    }

    public static void insertarDatosAeropuerto(Aeropuerto aero []){
        aero[0] = new AeropuertoPublico("Ezeisa","BA","Argentina",80000000);
        aero[0].insertarCompañia(new Compañia("AeroAr"));
        aero[0].insertarCompañia(new Compañia("LATAM"));
        aero[0].getCompañia("AeroAr").insertarVuelo(new Vuelo("AA01","Buenos Aires","Mexico",150.90,150));
        aero[0].getCompañia("AeroAr").insertarVuelo(new Vuelo("AA02","Buenos Aires","Bogota",170.90,180));
        aero[0].getCompañia("LATAM").insertarVuelo(new Vuelo("LT01","Buenos Aires","Madrid",450.90,190));
        aero[0].getCompañia("AeroAr").getVuelo("AA01").insertarPasajero(new Pasajero("Ronnie","123CF30","Mexicana"));
        aero[0].getCompañia("AeroAr").getVuelo("AA01").insertarPasajero(new Pasajero("Romina","345JH11","Argentina"));
        aero[0].getCompañia("LATAM").getVuelo("LT01").insertarPasajero(new Pasajero("Raul","543LK123","Español"));

        aero[1] = new AeropuertoPublico("Dorado","Bogota","Colombia",50000000);
        aero[1].insertarCompañia(new Compañia("AirAmerica"));
        aero[1].insertarCompañia(new Compañia("VuelaBogota"));
        aero[1].getCompañia("AirAmerica").insertarVuelo(new Vuelo("AM01","Bogota","Buenos Aires",170.90,150));
        aero[1].getCompañia("VuelaBogota").insertarVuelo(new Vuelo("VB01","Bogota","Buenos Aires",190.00,180));
        aero[1].getCompañia("AirAmerica").getVuelo("AM01").insertarPasajero(new Pasajero("Andres","123KS345","Colombiano"));
        aero[1].getCompañia("VuelaBogota").getVuelo("VB01").insertarPasajero(new Pasajero("Daiana","457OP011","Argentina"));

        aero[2] = new AeropuertoPublico("Aeropuerto Mexico","Mexico","Mexico",70000000);
        aero[2].insertarCompañia(new Compañia("AeroMexico"));
        aero[2].getCompañia("AeroMexico").insertarVuelo(new Vuelo("AX01","Mexico","Buenos Aires",150.90,150));
        aero[2].getCompañia("AeroMexico").insertarVuelo(new Vuelo("AX02","Mexico","Buenos Aires",150.90,150));
        aero[2].getCompañia("AeroMexico").getVuelo("AX01").insertarPasajero(new Pasajero("Camila","987BNV231","Mexicanna"));

        aero[3] = new AeropuertoPrivado("Central Ciudad Real","Madrid","España");
        aero[3].insertarCompañia(new Compañia("AirEuropa"));
        String empresas[] = {"Cobresol","Anguila34"};
        ((AeropuertoPrivado)aero[3]).insertarEmpresas(empresas);
        aero[3].getCompañia("AirEuropa").insertarVuelo(new Vuelo("AE01","Madrid","Buenos Aires",500.90,200));
        aero[3].getCompañia("AirEuropa").getVuelo("AE01").insertarPasajero(new Pasajero("Luis","985MRG472","Español"));
    }

    public static void Menu(){
        String nombreAeropuerto, nombreCompañia, origen, destino;
        int opcion;
        Aeropuerto aeropuerto;
        Compañia compañia;

        do {
            System.out.println("\t.:Menu:.");
            System.out.println("1. Ver Aeropuertos gestionados (Publicos o Privados)");
            System.out.println("2. Ver empresas (Privado) o Subvencion (Publico)");
            System.out.println("3. Listas de compañias de un Aeropuerto");
            System.out.println("4. Lista de vuelos por compañia");
            System.out.println("5. Lista posibles vuelos de Origen a Destino");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");
            opcion = entrada.nextInt();

            switch(opcion){
                case 1: //Ver Aeropuertos gestionados (Publicos o Privados)
                        System.out.println("");
                        mostrarDatosAeropuertos(aeropuertos);
                        break;
                case 2: //Ver empresas (Privado) o Subvencion (Publico)
                        System.out.println("");
                        mostrarParocinio(aeropuertos);
                        break;
                case 3: //Listas compañias de un Aeropuerto
                        entrada.nextLine();
                        System.out.print("\nIndique nombre del Aeropuerto: ");
                        nombreAeropuerto = entrada.nextLine();
                        aeropuerto = buscarAeropuerto(nombreAeropuerto,aeropuertos);
                        if (aeropuerto==null){
                            System.out.println("El Aeropuerto no existe");
                        }
                        else {
                            mostrarCompañias(aeropuerto);
                        }
                        break;
                case 4: //Lista de vuelos por compañia
                        entrada.nextLine();
                        System.out.print("\nIndique nombre del Aeropuerto: ");
                        nombreAeropuerto = entrada.nextLine();
                        aeropuerto = buscarAeropuerto(nombreAeropuerto,aeropuertos);
                        if (aeropuerto==null) {
                            System.out.println("El Aeropuerto no existe");
                        }
                        else {
                            System.out.print("Indiqe el nombre de la compañia: ");
                            nombreCompañia = entrada.nextLine();
                            compañia = aeropuerto.getCompañia(nombreCompañia);
                            mostrarVuelos(compañia);
                        }
                        break;
                case 5: //Lista posibles vuelos de Origen a Destino
                        entrada.nextLine();
                        System.out.print("\nIndique Ciudad de origen: ");
                        origen = entrada.nextLine();
                        System.out.print("Indique Ciudad de destino: ");
                        destino = entrada.nextLine();
                        mostrarVueloOrigenDestino(origen,destino,aeropuertos);
                        break;
                case 6: //Salir
                        break;
                default: System.out.println("Error, se equivoco de opcion de menu");
            }
            System.out.println("");
        }while (opcion!=6);
    }

    public static void mostrarDatosAeropuertos(Aeropuerto aeropuertos []){
        for(int i=0;i<aeropuertos.length; i++){
            if (aeropuertos[i] instanceof AeropuertoPrivado){
                System.out.println("Aeropuerto Privado");
                System.out.println("Nombre: "+aeropuertos[i].getNombre());
                System.out.println("Ciudad: "+aeropuertos[i].getCiudad());
                System.out.println("Pais: "+aeropuertos[i].getPais());
            }
            else {
                System.out.println("Aeropuerto Publico");
                System.out.println("Nombre: "+aeropuertos[i].getNombre());
                System.out.println("Ciudad: "+aeropuertos[i].getCiudad());
                System.out.println("Pais: "+aeropuertos[i].getPais());
            }
            System.out.println("");
        }
    }

    public static void mostrarParocinio(Aeropuerto aeropuertos []){
        String empresas[];

        for (int i=0;i<aeropuertos.length;i++){
            if (aeropuertos[i] instanceof AeropuertoPrivado){
                System.out.println("Aeropuerto Privado: "+aeropuertos[i].getNombre());
                empresas = ((AeropuertoPrivado)aeropuertos[i]).getListaEmpresas();
                System.out.println("Empresas: ");
                for (int j=0;j<empresas.length;j++){
                    System.out.println(empresas[j]);
                }
            }
            else {
                System.out.println("Aeropuerto Publico: "+aeropuertos[i].getNombre());
                System.out.println("Subvencio: "+((AeropuertoPublico)aeropuertos[i]).getSubvencion());
            }
            System.out.println("");
        }
    }

    public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]){
        boolean encontrado = false;
        int i = 0;
        Aeropuerto aero = null;
        while ((!encontrado) && (i<aeropuertos.length)){
            if (nombre.equals(aeropuertos[i].getNombre())){
                encontrado = true;
                aero = aeropuertos[i];
            }
            i++;
        }
        return aero;
    }

    public static void mostrarCompañias(Aeropuerto aeropuerto){
        System.out.println("\nLas compañias del aeropuerto: "+aeropuerto.getNombre());
        for (int i=0;i<aeropuerto.getNumCompañia();i++){
            System.out.println(aeropuerto.getCompañia(i).getNombre());
        }
    }

    public static void mostrarVuelos(Compañia compañia){
        Vuelo vuelo;
        System.out.println("Los vuelos de la compañia: "+compañia.getNombre());
        for (int i=0;i<compañia.getNumVuelo();i++){
            vuelo = compañia.getVuelo(i);
            System.out.println("Identificador: "+vuelo.getIdentificador());
            System.out.println("Ciudad de origen: "+vuelo.getCiudadOrigen());
            System.out.println("Ciudad Destino: "+vuelo.getCiudadDesino());
            System.out.println("precio: $"+vuelo.getPrecio());
            System.out.println("");
        }
    }

    public static Vuelo[] buscarVueloOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]){
        Vuelo vuelo;
        int contador = 0;
        Vuelo listaVuelo[];

        for (int i=0;i<aeropuertos.length;i++){ //Recorremos los aropuertos
            for (int j=0;j<aeropuertos[i].getNumCompañia();j++) { //Recorremos las compañias
                for (int k = 0; k < aeropuertos[i].getCompañia(j).getNumVuelo(); k++) { //Recorremos los vuelos
                    vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
                    if ((origen.equals(vuelo.getCiudadOrigen())) && (destino.equals(vuelo.getCiudadDesino()))) {
                        contador++;
                    }
                }
            }
        }
        listaVuelo = new Vuelo[contador];
        int q=0;

        for (int i=0;i<aeropuertos.length;i++) { //Recorremos los aropuertos
            for (int j = 0; j < aeropuertos[i].getNumCompañia(); j++) { //Recorremos las compañias
                for (int k = 0; k < aeropuertos[i].getCompañia(j).getNumVuelo(); k++) { //Recorremos los vuelos
                    vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
                    if ((origen.equals(vuelo.getCiudadOrigen())) && (destino.equals(vuelo.getCiudadDesino()))) {
                        listaVuelo[q] = vuelo;
                        q++;
                    }
                }
            }
        }
        return listaVuelo;
    }

    public static Compañia buscarCompañia(String nombre,Compañia compañias[]){
        boolean encontrado = false;
        int i = 0;
        Compañia compa = null;
        while ((!encontrado) && (i<compañias.length)){
            if (nombre.equals(compañias[i].getNombre())){
                encontrado = true;
                compa = compañias[i];
            }
            i++;
        }
        return compa;
    }

    public static void mostrarVueloOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]){
        Vuelo vuelos[];
        vuelos = buscarVueloOrigenDestino(origen,destino,aeropuertos);
        if (vuelos.length==0){
            System.out.println("No existen vuelos de la ciudad origen y destino indicada");
        }
        else {
            System.out.println("\nVuelos Encontrados: ");
            for (int i=0;i<vuelos.length;i++){
                System.out.println("Identificador: "+vuelos[i].getIdentificador());
                System.out.println("Ciudad de Origen: "+vuelos[i].getCiudadOrigen());
                System.out.println("Ciudad de Destino: "+vuelos[i].getCiudadDesino());
                System.out.println("Precio: $"+vuelos[i].getPrecio());
                System.out.println("");
            }
        }

    }

}















