/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamethelife;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class GameTheLife {
    private static int[] row = new int[6];
    private static int[] colum = new int [6];
    boolean life_of_death = false;
    private static int list_live[][] = {{1,2}, {2,3}, {3,2}, {3,4}, {4,2}, {5,3}};
    
    /**
     * @param args the command line arguments
     */

    
    public static boolean ValidateDimension(){
        if(row.length <= 3){
            return false;
        }
        return true;
    }
    public static void CreateBoard(){          
        for (int counter_row = 1; counter_row <= row.length; counter_row++){
            ArrayList rows = new ArrayList();
            for (int counter_colum = 1; 
                    counter_colum <= colum.length; counter_colum++){
                int cell_value = DefinedDeadLive(counter_row, counter_colum);
                int element = cell_value;
                rows.add(element);
            }
            System.out.println(rows);
        }
    }
    public static int DefinedDeadLive(int row, int colum){
        int live = list_live.length;
        int live_or_dead = 0;
        for (int alive = 0; alive < live; alive++){
            if (row == list_live[alive][0]){
                if(colum == list_live[alive][1]){
                    live_or_dead = 1;
                }
            }
        }
        return live_or_dead;
    }
    public static void CreateGame(){
        if (ValidateDimension()){
            CreateBoard();
        }else{
            System.out.println("Very small board");
        }
    }
    public static void main(String[] args) {
        CreateGame();
        // TODO code application logic here
    }
    
}
