package rentapeliculasarraylist;

/**
 * TECNOLOGÍA ORIENTADA A OBJETOS (9-10AM), 1er PARCIAL
 * Martes, 11 de febrero de 2020
 * Este ejercicio tiene el objetivo de relacionar directamente los diagramas de clase UML y de objetos
 * con el código de un programa como tal.
 * Fue un trabajo en equipo en el que tuvimos que hacer:
    *Diagrama de clase
    * Diagrama de objetos
    * Código de lo mencionado
 * Elegimos hacerlo de Renta de películas como un videoclub (Ej: Blockbuster)
 * Lo implementamos con ArrayList para hacer un arreglo dinámico de los objetos y manejar
        la información con mayor facilidad.
        * Esto lo hacemos creando un ArrayList del tipo Usuario (que es un objeto) y además manejamos los métodos
           con un objeto por separado para luego agregar el objeto al Arreglo (nombreArrayList.add(objeto);)
 */

import java.util.Scanner;
import java.util.ArrayList;

class Usuario{
    private int Edad, ID;//ID entero para irlo aumentando con una sumatoria (aunque sería mejor como String)
    private String Direccion, Telefono, Nombre;//ID
    public Usuario(){
        Edad= ID=0;
        Direccion = new String("");
        Telefono = new String("");
        Nombre = new String("");
    }
    public void registraUsuario(int Edad, String Direccion, String Telefono, String Nombre){
        this.Edad = Edad;
        ID = registraID();    //El constructor del Objeto String estará en el main
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Nombre = Nombre;
        /*En otros casos como cuando no hay parámetros se puede utilizar this( , , , , )
            https://javadesdecero.es/palabra-clave/this/*/
    }
    public int registraID(){
        return ID++;
    }
    public void ImprimeInfo(){  
        /*Este método imprime la información de los usuarios ya que no la podemos imprimir directamente del
            arrayList. Se tiene que acceder al objeto y con este método la imprimimos.*/
        System.out.println(" - Nombre: " + Nombre + ", Edad: " + Edad);
        System.out.println(" - ID: " + ID + ", Telefono: " + Telefono);
        System.out.println(" - Direccion: " + Direccion);
    }
}

class UsuarioArrayList{
    private ArrayList<Usuario> userArray;
    public UsuarioArrayList(){
        userArray = new ArrayList<>();
    }
    public void addUsuario(Usuario user){
        userArray.add(user);
    }
    public void imprimeAL(){
        /*Aquí mediante un ciclo recorremos todos los elementos del arreglo y mediante el método
            que definimos anteriormente para imprimir la info del usuario, lo utilizamos aquí ya
            habiendo accedido al objeto.*/
        for(Usuario user : userArray)//each loop feature of java: https://www.quora.com/How-do-I-display-all-the-elements-in-ArrayList-in-Java-using-loop
            user.ImprimeInfo();//Usando el método imprimir la info de cada objeto
        /*El ciclo también podría ser con un for normal y utilizando el método "size()" de la clase ArrayList.
            Sólo que como es un objeto, no se puede imprimir directamente, pero si fueran elementos
            individuales, sí se podría.1*/
        //for(int i=0; i<userArray.size(); i++)
          //  userArray.get(i);
    }
    
    //public
}

public class RentaPeliculasArrayList{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //ArrayList<Usuario> user = new ArrayList<Usuario>();
        //ArrayList<Usuario> user = new ArrayList<>();
//        ArrayList<Usuario> userArray; //El compilador sugería que se hicieran esos procesos por separado
//        userArray = new ArrayList<>();
        UsuarioArrayList userArray = new UsuarioArrayList();
        Usuario userObj = new Usuario();
        String ID, Dir, Tel, Nombre;
        int op=1, Edad, i;//op = opción que se inicia en 1 para entrar al ciclo
        while(op!=0){
            System.out.println("\t-> Que quieres hacer? <-");
            System.out.println("1.- Registrar Usuario; 2.- Ver usuario; 3.- ");
            op = input.nextInt();
            switch(op){
                case 1: //Registrar usuario
                    //String usimgNew = new String("Hola"); Marca un warning
                    System.out.println("-> Nombre: ");
                    Nombre = input.nextLine();
                    System.out.println("-> Edad: ");
                    Edad = input.nextInt();
                    /*ID = new String(input.nextLine());  //nextLine() es un método para leer String
                        Se dice que esto es ineficiente ya que no es "memory efficient"
                    Fuente: https://help.semmle.com/wiki/display/JAVA/Inefficient+String+constructor*/
                    //ID = input.nextLine(); El ID no se genera, se ingresa
                    //System.out.println(ID); Para ver si sí se imprimía bien
                    System.out.println("-> Direccion: ");
                    Dir = input.nextLine();
                    System.out.println("-> Telefono: ");
                    Tel = input.nextLine();
                    userObj.registraUsuario(Edad, Dir, Tel, Nombre);
                    userArray.addUsuario(userObj);
                    break;
                case 2: //Ver información del usuario
                    userArray.imprimeAL();
                    break;
            }
        }
        
    }
    
}