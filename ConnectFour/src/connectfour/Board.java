/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

/**
 *
 * @author Priyank Sevak
 */
public class Board {
    private State[][] GameBoard;
    private int boardSize = 6;

    public State[][] getGameBoard() {
        return GameBoard;
    }

    public void setGameBoard(State[][] GameBoard) {
        this.GameBoard = GameBoard;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
    
    public void InitialiseBoard(){
       GameBoard = new State[boardSize][boardSize];
       
       System.out.println();
        
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                GameBoard[i][j] = State.$;
            }
        }
        
    }
    public void ShowBoard(){
        for(int i=0;i<boardSize;i++){
            System.out.print(i + " | ");
        }
        
        System.out.println();
        System.out.println();
        
        for(int i=0;i<boardSize;i++){
           
            for(int j=0;j<boardSize;j++){ 
                System.out.print(GameBoard[i][j] + " | ");
            }
            System.out.println();
            System.out.println("------------------------");
        }
    } 
    
    
}
