package miagenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


 
public class MiAgenda {

    static File archivo = new File ("agenda.txt");
    static FileWriter fw = null;
    static BufferedWriter bw =null;
    static FileReader fr = null;
    static BufferedReader br = null;
    
    
    public static void main(String[] args) {
        MiAgenda agenda = new MiAgenda();
        
        Persona p = null;
        Scanner leerNumeros = new Scanner(System.in);
        Scanner leerCaracteres = new Scanner(System.in);
        int opcion = 0;
        
        while (opcion<4){
            System.out.println("Menu");
        System.out.println("1. Ingresar contato");
        System.out.println("2. Consultar Agenda");
        System.out.println("3. Buscar Contacto por Nombre");
        System.out.println("4. Salir");
            try {
                opcion=leerNumeros.nextInt();
            } catch (Exception e) {
                leerNumeros= new Scanner(System.in);
            }
        
        
        switch(opcion){
            case 1:
                 System.out.println("Nombre:");
                 String nombre = leerCaracteres.nextLine();
                 System.out.println("Apellido Paterno:");
                 String ApPaterno = leerCaracteres.nextLine();
                 System.out.println("Apellido Materno:");
                 String ApMaterno = leerCaracteres.nextLine();
                 System.out.print("Telefono:");
                 String telefono = leerCaracteres.nextLine();
                 System.out.print("Correo:");
                 String Correo = leerCaracteres.nextLine();
                 p = new Persona(nombre, ApPaterno, ApMaterno, telefono, Correo);
                 agenda.escribirContacto(p);
                 break;
            case 2:
                agenda.leerContacto();
                break;
            case 3:
                System.out.println("Ingresar Nombre: ");
                String nombreB = leerCaracteres.nextLine();
                agenda.buscar(nombreB);
                break;
            case 4:
                System.exit(0);
            default:  
                throw new AssertionError();
        }//fin switch
        
        }//fin while
        
       //agenda.escribirContacto(p);
       // agenda.leerContacto();

    }//fin main
    private void escribirContacto(Persona p){
        
        try{
            fw = new FileWriter(archivo,true);
            bw = new BufferedWriter (fw);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }else{
                bw.write(p.toString());
                bw.close();
            }
            
        }
        catch(IOException e){
             System.out.println("Eception IO: "+e.getMessage());
        }
        catch(Exception e){
            System.out.println("Eception: "+e.getMessage());
        }
                
    }
    private void leerContacto(){
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String cadena;
            while ((cadena = br.readLine())!=null) {                
                //System.out.println(cadena);
                String contacto[] = cadena.split("%");
                Persona p = 
                new Persona(contacto[0], contacto[1], contacto[2], contacto[3], contacto[4]);
                p.mostrar();
            }
            br.close();
        }
        catch(IOException e){
            System.out.println("Exeption IO:"+e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Exeption :"+e.getMessage());
        }
    }

    private void buscar(String nombreB) {
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String cadena;
            boolean bandera = false;
            while ((cadena=br.readLine())!=null) {
                String contacto[] = cadena.split("%");
                if (nombreB.equals(contacto[0])) {
                    bandera = true;
                    Persona p = 
                    new Persona(contacto[0], contacto[1], contacto[2], contacto[3], contacto[4]);
                    p.mostrar();
                    System.out.println("********************");
                }else{
                    System.out.println("Contacto No existente.");
                }
            }//fin while
             if (bandera==false) {
               System.out.print("El contacto no existe");
            }
            br.close();
        }
        catch(IOException e){
            System.out.println("Exeption IO:"+e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Exeption :"+e.getMessage());
        }
    }
  
    
}
