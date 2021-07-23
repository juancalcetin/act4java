package com.company;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AddressBook hi = new AddressBook();
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        boolean salir = false;
        int opcion;

        while (!salir){

            System.out.println("1. Agregar nuevo contacto");
            System.out.println("2. Listar contactos existentes");
            System.out.println("3. Eliminar contacto existente");
            System.out.println("4. Guardar cambios en el archivo de texto");
            System.out.println("5. Mostrar contactos en el archivo de texto");
            System.out.println("6. Salir");
            try {
                System.out.println("Ingrese el numero de la accion deseada");
                opcion=scan.nextInt();

                switch (opcion){
                    case 1:
                        hi.agregaContacto();
                        break;

                    case 2:
                        hi.mostrarContactos();
                        break;

                    case 3:
                        hi.borrarContacto();
                        break;

                    case 4:
                        hi.saveContactos();
                        break;

                    case 5:
                        hi.loadContactos();
                        break;

                    case 6:
                        salir=true;
                        break;

                    default:
                        System.out.println("Solo numeros entre 1 y 4");
                }
            } catch (InputMismatchException e){
                System.out.println("Debes ingresar un numero");
                scan.next();
            }

        }

    }
}
