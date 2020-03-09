/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.util.Scanner;

/**
 *
 * @author Priyank Sevak
 */
class Game {

    Scanner sc = new Scanner(System.in);
    Board gameBoard = new Board();
    Player player1 = new Player();
    Player player2 = new Player();
    String[] mark;
    
    public void StartGame() {
        gameBoard.InitialiseBoard();
        gameBoard.ShowBoard();
        String winner="";
        GetPlayerInformation();
        sc.nextLine();
        
        int turn = 1;
        while (turn <= gameBoard.getBoardSize() * gameBoard.getBoardSize()) {

            

            if (turn % 2 == 1) {
                String[] mark = CheckValidity(player1);
                TurnOfPlayer(mark,player1);
                if (CheckWinner(mark, player1)) {
                    winner = player1.getName();
                    break;
                }
            } else {
                String[] mark = CheckValidity(player2);
                TurnOfPlayer(mark,player2);
                if (CheckWinner(mark, player2)) {
                    winner = player2.getName();
                    break;
                }
            }
            gameBoard.ShowBoard();
            turn++;
        }
        gameBoard.ShowBoard();
        DecideWinner(winner);
    }
    
    boolean CheckWinner(String[] mark, Player player) {
        
        if (CheckRow(mark, player) || CheckColumn(mark, player) || CheckDiagonal(mark, player) || CheckAntiDiagonal(mark, player)) {
            return true;
        }
        return false;
    }

    boolean CheckRow(String[] mark, Player player) {
        int x = Integer.parseInt(mark[0]);
        int markInRow=0;
        for (int i = 0; i < gameBoard.getBoardSize(); i++) {
            if (gameBoard.getGameBoard()[x][i] == player.getChoice()) {
                markInRow++;
                
            }
            else if(markInRow > 0 && gameBoard.getGameBoard()[x][i] != player.getChoice()){
                markInRow=0;
            }
            if (markInRow == 4) {
                return true;
            }
        }
        return false;
    }
    
    boolean CheckColumn(String[] mark, Player player) {
        int y = Integer.parseInt(mark[1]);
        int markInCol=0;
        for (int i = 0; i < gameBoard.getBoardSize(); i++) {
            if (gameBoard.getGameBoard()[i][y] == player.getChoice()) {
                markInCol++;
            }
            else if(markInCol > 0 && gameBoard.getGameBoard()[i][y] != player.getChoice()){
                markInCol=0;
            }
            if (markInCol == 4) {
                return true;
            }
        }
        return false;
    }
    
    boolean CheckDiagonal(String[] mark, Player player) {
        
        int markInDiag = 0;
            
            
            for (int i = (gameBoard.getBoardSize() - 4) + 1; i < gameBoard.getBoardSize(); i++) {
                for(int j=gameBoard.getBoardSize()-1;j>=(gameBoard.getBoardSize() - 4) + 1;j--)
                if (gameBoard.getGameBoard()[i][j] == player.getChoice()) {
//                    markInDiag++;
                    for(int k=0;k<4;k++){
                        if(gameBoard.getGameBoard()[i-k][j-k] == player.getChoice()){
                            markInDiag++;
                        }else{
                            markInDiag=0;
                            break;
                        }
                    }
                    if(markInDiag == 4)
                        return true;
                }
                
            }
        
        return false;
    }
    
    boolean CheckAntiDiagonal(String[] mark, Player player) {
       
        int markInAntiDiag = 0;
        
            for (int i = (gameBoard.getBoardSize() - 4) + 1; i < gameBoard.getBoardSize(); i++) {
                for(int j=0;j<=(gameBoard.getBoardSize() - 4) + 1;j++)
                if (gameBoard.getGameBoard()[i][j] == player.getChoice()) {
//                    markInDiag++;
                    for(int k=0;k<4;k++){
                        if(gameBoard.getGameBoard()[i-k][j+k] == player.getChoice()){
                            markInAntiDiag++;
                        }else{
                            markInAntiDiag=0;
                            break;
                        }
                    }
                    if(markInAntiDiag == 4)
                        return true;
                }
                
            }
        
        return false;
        }
      
    
    public void GetPlayerInformation() {
        System.out.println("Player1 enter your name:");
        player1.setName(sc.nextLine());

        System.out.println("Player2 enter your name:");
        player2.setName(sc.nextLine());

        
        char ch;
        do {
            System.out.println(player1.getName() + " enter your choice X or O");
            ch = sc.next().charAt(0);

            if (ch == 'X') {
                player1.setChoice(State.X);
                player2.setChoice(State.O);
            } 
            else if(ch == 'O') {
                player1.setChoice(State.O);
                player2.setChoice(State.X);
            }
           
        } while(!(ch == 'X' || ch == 'O'));
    }

    
    
    String[] CheckValidity(Player player) {
        String[] mark = new String[2];

        while (true) {

            System.out.println(player.getName() + " Enter column number you want to drop");
            int y = sc.nextInt();
            try {

                
                if (y > gameBoard.getBoardSize() || y < 0) {
                    throw new InvalidEntryException();
                }
                for (int x = gameBoard.getBoardSize() - 1; x >= 0; x--) {
                    if (gameBoard.getGameBoard()[x][y] == State.$) {
                        mark[0] = String.valueOf(x);
                        mark[1] = String.valueOf(y);
                        return mark;
                    }
                }

            } catch (InvalidEntryException e) {
                System.out.println("You marked out of the board!! You lose!!");
//                PlayAgain();
            }
        }
    }

    private void TurnOfPlayer(String[] mark,Player player) {
        State choice = player.getChoice();
        int x = Integer.parseInt(mark[0]);
        int y = Integer.parseInt(mark[1]);
        
        gameBoard.getGameBoard()[x][y] = choice;
    }

    private void DecideWinner(String winner) {
        System.out.println("CONGRATULATIONS!!! You won "  + winner.toUpperCase());
    }

}
