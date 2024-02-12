package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] cantidadCompras=new int[6];
        Scanner sc=new Scanner(System.in);
        // programa que me permita gestionar las ventas de unnegocio de pandebonos
        // pandobono tradicional=8000, pandebono de guayaba=9500, pandebono de arequipe=12000
        // pandebono 7 quesos=20000
        // se venden bebidas calientes chocolate, cafe 9500
        /* mostrar un menu, donde permita agregar una compra
        calcular el total de la compra, incluye propina o no
        modificar orden de compra
        salir
        *
        * */
        LocalDate fecha=LocalDate.now();
        LocalDateTime fecha2=LocalDateTime.now();
        String[] productos={"pandobono tradicional","pandebono de guayaba","pandebono de arequipe","pandebono 7 quesos","chocolate","cafe"};
        int [] precios={8000,9500,12000,20000,9500,9500};
        Double totalCompra=0.0;

        Boolean condicion=true;
        Boolean banderaInterna=true;
        System.out.println("Bienvenido a la tienda de pandebonos a continuacion las opciones ");
        while (condicion) {
            MostrarMenuGeneral();
            System.out.print("escoja una opcion: ");
            int opcionMenu = sc.nextInt();
            if (opcionMenu==1){
                while (true) {
                    MostrarMenuProductos();
                    System.out.println("escoja un producto");
                    int opcionMenuProductos = sc.nextInt();
                    if (opcionMenuProductos==7){
                        break;
                    }else {
                        cantidadCompras = CantidadProductos(opcionMenuProductos, sc,cantidadCompras);

                    }

                }

            } else if (opcionMenu==2) {
                System.out.println("desea agregar propina del 10% de la compra si/no");
                String opcionPropina=sc.nextLine();
                if (opcionPropina.equals("si")) {
                    totalCompra = CalcularTotal(cantidadCompras, precios);
                    System.out.println("el total de la compra es: " + totalCompra);
                }
            } else if (opcionMenu==3) {
                System.out.println("modificacion de compras");
                System.out.println("escoja el numero del producto que quiere modificar");
                MostrarMenuProductos();
                int opcionMenuProductos = sc.nextInt();
                System.out.println("seleccione la cantidad de: " +productos[opcionMenuProductos-1]+"que desea actualizar");
                int nuevaCantidad=sc.nextInt();
                modificarCompras(cantidadCompras,opcionMenuProductos,nuevaCantidad);
            } else if (opcionMenu==4) {
                condicion=false;
            }else {
                System.out.println("opcion incorrecta");
            }


        }


    }
    public static void MostrarMenuGeneral(){
        System.out.println("1. Agregar compra");
        System.out.println("2. Calcular total");
        System.out.println("3. Modificar la compra");
        System.out.println("4. Salir");
    }
    public static void MostrarMenuProductos(){
        System.out.println("1. pandobono tradicional");
        System.out.println("2. pandobono de guayaba");
        System.out.println("3. pandobono de arequipe");
        System.out.println("4. pandobono 7 quesos");
        System.out.println("5. Chocolate");
        System.out.println("6. Cafe");
        System.out.println("7. Salir");
    }
    public static int[] CantidadProductos(int opcion, Scanner sc, int[]cantidadCompras){

        String[] mensajes = {
                "pandebono tradicional",
                "pandebono de guayaba",
                "pandebono de arequipe",
                "pandebono 7 quesos",
                "chocolates",
                "cafes "
        };

        if (opcion >= 1 && opcion <= 6) {
            System.out.println("Ingrese la cantidad de " + mensajes[opcion - 1] + " que desea comprar");
            int opcionCantidades = sc.nextInt();
            cantidadCompras[opcion - 1] += opcionCantidades;
        } else if (opcion == 7) {
            System.out.println("Menú anterior");
        } else {
            System.out.println("Opción incorrecta");
        }

        return cantidadCompras;
    }
    public static double CalcularTotal(int[] cantidadProductos, int[] precios){
        Double totalCompra=0.0;
        for (int i=0;i<cantidadProductos.length;i++){
            totalCompra+=cantidadProductos[i]*precios[i];
        }
        return totalCompra;
    }
    public static void modificarCompras(int[] compras, int producto, int nuevaCantidad) {
        if (producto >= 1 && producto <= 6) {
            compras[producto - 1] = nuevaCantidad;
            System.out.println("Modificación exitosa.");
        } else {
            System.out.println("Opción de producto incorrecta.");
        }
    }

}