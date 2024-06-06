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
import static javafx.scene.input.KeyCode.O;
        


public class Match {
    
    private boolean turn;
    private Model model;
    private Person persons[];

    public Match() {
       this.model = new Model ();
        
    }

    public Match(boolean turn, Model model, Person[] persons) {
        this.turn = turn;
        this.model = model;
        this.persons = persons;
    }

    /**
     * @return the turn
     */
    public boolean isTurn() {
        return turn;
    }

    /**
     * @param turn the turn to set
     */
    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    /**
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * @return the persons
     */
    public Person[] getPersons() {
        return persons;
    }

    /**
     * @param persons the persons to set
     */
    public void setPersons(Person[] persons) {
        this.persons = persons;
    }
    
    public boolean winner(int letter){
        
        if(this.model.getStruct(0,0)==letter && this.model.getStruct(0,1)==letter && this.model.getStruct(0,2)==letter){
            return true;
        }else if(this.model.getStruct(1,0)==letter && this.model.getStruct(1,1)==letter && this.model.getStruct(1,2)==letter){
            return true;
        }else if(this.model.getStruct(2,0)==letter && this.model.getStruct(2,1)==letter && this.model.getStruct(2,2)==letter){
            return true;
        }else if(this.model.getStruct(0,0)==letter && this.model.getStruct(1,0)==letter && this.model.getStruct(2,0)==letter){
            return true;
        }else if(this.model.getStruct(0,1)==letter && this.model.getStruct(1,1)==letter && this.model.getStruct(2,1)==letter){
            return true;
        }else if(this.model.getStruct(0,2)==letter && this.model.getStruct(1,2)==letter && this.model.getStruct(2,2)==letter){
            return true;
        }else if(this.model.getStruct(0,0)==letter && this.model.getStruct(1,1)==letter && this.model.getStruct(2,2)==letter){
            return true;
        }else if(this.model.getStruct(2,0)==letter && this.model.getStruct(1,1)==letter && this.model.getStruct(0,2)==letter){
            return true;
        }
        return false;
    }
    
    public void playerVsPlayer(Person p1,Person p2)throws IOException{
        int c=0;
        int i;
        int j;
        char letter;
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        
        do{
            
            
           if(!isTurn()){
               System.out.println(" ");
               this.model.showStruct();
               System.out.println(" ");
               
               System.out.print("Turno de "+ p1.getNickName()+ ": eliga una coordenada[ x-y ] "); 
               String cor = br.readLine();
               String coordenadas[] = cor.split("-");
               i= Integer.parseInt(coordenadas[0]);
               
               j= Integer.parseInt(coordenadas[1]);
               
               letter = 88;
               this.model.savePosition(i, j,letter);
               
               System.out.println(" ");
               this.model.showStruct();
               System.out.println(" ");
               
               if(c>3){
                   if(winner(letter)){
                       
                       System.out.println(p1.getNickName()+ " Ha ganado, Felicidades !!! ");
                       break;
                   }
               
               }
               setTurn(true);
               
               
           }else{
               
               
               System.out.print("Turno de "+ p2.getNickName()+ ": eliga una coordenada[ "); 
               
               
               String cor = br.readLine();
               String coordenadas[] = cor.split("-");
               i= Integer.parseInt(coordenadas[0]);
               j= Integer.parseInt(coordenadas[1]);
               
               letter = 79;
               this.model.savePosition(i, j,letter);
               if(c>3){
                   if(winner(letter)){
                       
                       System.out.println(p2.getNickName()+ " Ha ganado, Felicidades !!! ");
                       break;
                   }
               
               }
               setTurn(false);
               
               System.out.println(" ");
               this.model.showStruct();
               System.out.println(" ");
           }
           if(c==8){
           System.out.print("Hay un empate");
           
           }
        
        c++;
        }while(c<9);
        
        
    
    }
    
    
    
    
}
