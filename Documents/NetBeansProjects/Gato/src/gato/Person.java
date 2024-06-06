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
public class Person {
    
    private int age;
    private int score;
    private String IdPlayer;
    private String nickName;
    

    public Person() {
        this.age = 0;
        this.score= 0;
        this.IdPlayer= null;
        this.nickName = null;
    }

    public Person(int age,int score, String IdPlayer, String nickName) {
        this.age = age;
        this.score= score;
        this.IdPlayer = IdPlayer;
        this.nickName = nickName;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    public int getScore(){
        return score;
    }
    
    public void setScore(){
        this.score = score;
    }
    /**
     * @return the IdPlayer
     */
    public String getIdPlayer() {
        return IdPlayer;
    }

    /**
     * @param IdPlayer the IdPlayer to set
     */
    public void setIdPlayer(String IdPlayer) {
        this.IdPlayer = IdPlayer;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public void showAllPerson(Person persons[]){
        
        for(int i=0;i<persons.length;i++){
            System.out.print("NickName: "+persons[i].getNickName());
            System.out.print("Id User: "+persons[i].getIdPlayer());
            System.out.print("Score: "+persons[i].getScore());
            System.out.print("Edad: "+persons[i].getAge());
            
        }
        
    }
    public int search(Person persons [],String name){
        for(int i =0;i<persons.length;i++){
            if(persons[i].getNickName().equals(name)){
                
                return i;
            }
        }
    return 32;
    }
    
    public void showPerson(Person persons [],String name){
    int i = search(persons,name);
    //System.out.println("");
    
    if(i!=32){
        System.out.println("<____________________________________>");
        System.out.println(persons[i].getNickName());
        System.out.println("<------------------------------------>");
      }
    
    }
    
    
}
