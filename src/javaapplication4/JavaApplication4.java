
package javaapplication4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Rafael
 */
public class JavaApplication4 {
       final static int precio= 8;// Variables locales
   static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    
   
   public static void main(String[] args) throws IOException {
       int numeroEntradas;
       numeroEntradas=inicializacionEntradas();
       menu(numeroEntradas);
    }
   
   private static void menu(int entradasDisponibles) throws IOException{
       int op = 0;
       do {
           System.out.println("**** 1 - Realizar compra ***********");
           System.out.println("**** 2 - Realizar consulta *********");
           System.out.println("**** 3 - Salir *********************");
           try{
               do { //Lectura correcta
                   System.out.println("Introduce la opcion ha realizar");
                   op = Integer.parseInt(teclado.readLine());
               } while (op<1 || op>3);
               switch (op) {
                   case 1:
                       entradasDisponibles = realizarCompra(entradasDisponibles);
                       break;
                   case 2:
                       realizarConsulta(entradasDisponibles);
                       break;
               }
           }catch(NumberFormatException e){
               System.out.println("Introduce un numero entero");
              
           }catch(Exception e){
               System.out.println("Se ha produciso un error");
           }
       } while (op!=3 && entradasDisponibles>0);// Se repite hasta que el numero de entradasDisponibles sea cero o marques la opcion de salir
       
   }
    
   private static void realizarConsulta(int entradasDisponibles)throws IOException{
       if (entradasDisponibles > 0) {System.out.println("Hay "+entradasDisponibles+ " entradas");
       
       } else{ System.out.println("No hay entradas ");
       
       }
       
   }
   
   private static int realizarCompra(int entradasDisponibles)throws IOException{
       boolean error;
       int compras=0;
       do {
           error=false;
           try{
               System.out.println("¿Cuantas entradas quieres comprar? Min:1 Max:15 (Entradas disponibles:" +entradasDisponibles+ ")");
               
               do {
                   compras = Integer.parseInt(teclado.readLine());
                   
               } while (compras<1 || compras >15);
               if (compras <= entradasDisponibles) {
                   System.out.println("Numero de entradas: " +compras+" Total: " +compras * precio +" €");
                   
                   return entradasDisponibles-=compras;
               }else{
                   System.out.println("No hay suficientes entradas");
               }
                 
           }catch(NumberFormatException e){
               System.out.println("Introduce un numero entero");
               error=true;
           }catch(Exception e){
               System.out.println("Se ha producido un error");
               error=true;
           }
              
       } while (error==true);
       return entradasDisponibles ;
   }
   
   
   private static int inicializacionEntradas()throws IOException{
       boolean error;
       int entradas=0;
       do {
           error=false;
           try{
               System.out.println("Cuantas entradas hay a la venta");
               do {
                   entradas=Integer.parseInt(teclado.readLine());
               } while (entradas<1 || entradas>200);
               
           }catch(NumberFormatException e){
               System.out.println("Introduce un numero entero");
               error=true;
           }catch(Exception e){
               System.out.println("Se ha producido un error");
               error=true;
           }
              
       } while (error==true);
       return entradas;
   }
}
