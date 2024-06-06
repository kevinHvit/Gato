/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

/**
 *
 * @author Kevin Castrillo
 */
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
        
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    
     static Person [] persons = new Person[20];
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        boolean salir=false;
        int j=0;
        
        
        String nickName1;
        String nickName2;
        String opc;
        
        Match game = new Match();
        Model m = new Model();
       // Person [] persons = new Person[20];
        //Person p1 = new Person();
        //Person p2 = new Person();
        
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        
//        String s="s";
//        String p="p";
        
        persons[0]= new Person(12,0,"1234","s");
        persons[1]= new Person(12,0,"123","p");
        while(!salir){
            
            System.out.println("Bienvenido al juego de Gato(Tic-Tac-Toe)");
            System.out.println("Menú principal");
            System.out.println("1: Partida");
            System.out.println("2: Registrarse");
            System.out.println("3: Salir");
            System.out.println("Ingrese una opción: ");
            
            opc = br.readLine();
            switch(opc){
                case "1":{
                    int n1;
                    int n2;

                    System.out.println("Digite el nombre del primer Jugador");
                    nickName1= br.readLine();

                    System.out.println("Digite el nombre del segundo  Jugador");
                    nickName2= br.readLine();
                    
//                    for(int i=0;i<persons.length;i++){
//                        if(!persons[i].getNickName().equals(nickName1)&&!persons[i].getNickName().equals(nickName2)){
//                            
//                            System.out.println("Error nombre incorrecto...");
//                            break;
//                        }
//                    }    

                    n1= search(nickName1);
                    n2= search(nickName2);
                    
                    if(n1!=32&&n2!=32){ 
                        System.out.println("Iniciando Partida");
                        System.out.println("\t" + nickName1 + " VS " + nickName2 );
                        System.out.println("El jugador " + nickName1 + " ultiliza la letra ' X ' y el jugador "+ nickName2 + " con la letra ' O '" );
                        System.out.println(nickName1 + " Elija una Coordena de la estructura que este en el rango establecido. ");
                        System.out.println("Ejemplo [ 1 - 1 ]");
                        
                        game.playerVsPlayer(persons[n1], persons[n2]);
                    }else{
                    
                        System.out.println("Error el nombre es incorrecto");
                    
                    }


                    break;
                }
                case "2":{
                    int edad;
                    int score = 0;
                    String ide;
                    String name;

                    System.out.println("Digite el nombre o apodo del Jugador");
                    name= br.readLine();

                    System.out.println("Digite el ide del jugador ");
                    ide = br.readLine();

                    System.out.println("Digite la edad");
                    edad = Integer.parseInt(br.readLine());


                    persons[j] = new Person(edad,score,ide,name);

                    j++;
                    break;
                }
                case "3":{
                    salir=true;
                    System.out.println("Gracias por su participación");
                    System.exit(0);
                    break;
                }
                default:

                    System.out.println("El valor"+ opc+ " no se encuentra dentro de las opciones válidas");
                    break;
            }
        
        System.out.println("El programa a finaliza2 ");
        
        }
    }
    
    public static int search(String name){
        for(int i =0;i<persons.length;i++){
            if(persons[i].getNickName().equals(name)){
                
                return i;
            }
        }
    return 32;
    }
    
}
