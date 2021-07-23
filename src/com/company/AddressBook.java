package com.company;

import java.io.*;
import java.util.*;


public class AddressBook {
    final static String outputFilePath = "resources/contactos.txt";
    HashMap<String, String> book = new HashMap<>();

    Scanner sn = new Scanner(System.in);
    String numeroContacto="";
    String nombreContacto="";
    public void agregaContacto(){
        System.out.println("Ingrese numero de telefono: ");
        numeroContacto=sn.next();
        System.out.println("Ingrese nombre: ");
        nombreContacto=sn.next();
        if(!book.containsKey(numeroContacto)) {
            book.put(numeroContacto, nombreContacto);
            System.out.println("Se agrego correctamente");
        }else{
            System.out.println("Ya existe el contacto");
        }
    }
    public void mostrarContactos(){

        book.entrySet().forEach(entry -> {
           System.out.println(entry.getKey()+" : "+entry.getValue());
        });

    }
    public void saveContactos() {
        File file = new File(outputFilePath);
        BufferedWriter bf = null;

        try {


            bf = new BufferedWriter(new FileWriter(file));


            for (Map.Entry<String, String> entry :
                    book.entrySet()) {


                bf.write(entry.getKey() + ","
                        + entry.getValue());


                bf.newLine();
            }

            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {


                bf.close();
            } catch (Exception e) {
            }

        }
    }

    public void loadContactos() {
        File file = new File(outputFilePath);
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        }catch (FileNotFoundException ex){

        }
    }


    public void borrarContacto(){
        System.out.println("Introducir telefono del contacto a borrar: ");
        numeroContacto=sn.next();
        if(book.containsKey(numeroContacto)){
            book.remove(numeroContacto);
            System.out.println("Se ha eliminado el contacto");
        }else{
            System.out.println("No existe conntacto con este telefono");
        }
    }

}
