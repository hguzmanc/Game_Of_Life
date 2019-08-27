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
    private static ArrayList rows_game = new ArrayList();
    
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
            rows_game.add(rows);
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
    public static int GameRules(int row, int colum){
        int neighborhood_counter = 0;
        if (row > 0 && colum > 0){
            for (int row_position = row-1;row_position <= row+1; row_position++){
                ArrayList list_row = (ArrayList)rows_game.get(row_position);
               for (int colum_position = colum-1;colum_position <= colum+1; colum_position++){
                   if(row_position != row || colum_position != colum){
                       int data = Integer.parseInt(list_row.get(colum_position).toString());            
                        if(data == 1){
                            neighborhood_counter = neighborhood_counter+1;
                        }
                   }  
                } 
            }
            if(neighborhood_counter >= 2){
                return 1;
            }
            return 0;
        }else{
            for (int row_position = row;row_position <= row+1; row_position++){
                ArrayList list_row = (ArrayList)rows_game.get(row_position);
               for (int colum_position = colum;colum_position <= colum+1; colum_position++){
                   if(row_position != row || colum_position != colum){
                       int data = Integer.parseInt(list_row.get(colum_position).toString());            
                        if(data == 1){
                            neighborhood_counter = neighborhood_counter+1;
                        }
                   }  
                } 
            }
        if(neighborhood_counter >= 2){
            return 1;
        }
        return 0;    
        }
    }
    
    public static void main(String[] args) {
        CreateGame();
        GameRules(1, 4);
        // TODO code application logic here
    }
    
}
