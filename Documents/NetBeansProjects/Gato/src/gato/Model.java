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
public class Model {
    char struct[][];

    public Model() {
        
        this.struct = new char [3][3];
        
        for(int i=0; i<3;i++){
            for(int j= 0; j < 3; j++){
            this.struct[i][j]=32;
            }
        }
    }
    public void setStruct(int i, int j, char letter)
    {
	struct[i][j] = letter; 
    }
    public int getStruct(int i, int j)
    {
        return struct[i][j]; 
    }
    public boolean savePosition(int i, int j, char letter){
        if((isEmpty())&&(letter==79||(letter==88))){
            struct[i][j]= letter;
            return true;
        }
        return false;
    }
    
    //Posible matriz  del juego
    public void showStruct(){
        
        System.out.print("\t   "+0+"    "+1+"    "+2+"\n");
        System.out.print("\t0  "+struct[0][0]+" | "+struct[0][1]+" | "+struct[0][2]+"\n");
        System.out.print("\t --------------\n");
        System.out.print("\t1  "+struct[1][0]+" | "+struct[1][1]+" | "+struct[1][2]+"\n");
        System.out.print("\t --------------\n");
        System.out.print("\t2  "+struct[2][0]+" | "+struct[2][1]+" | "+struct[2][2]+"\n");
    
    }
    
    public boolean isEmpty(){
        for(int i=0;i<struct.length;i++){
            for(int j= 0;j<struct.length;j++){
                if(struct [i][j]==32){
                    return true;
                }
            }
        }
    return false;
    }
}
