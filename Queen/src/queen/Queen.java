/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queen;

/**
 *
 * @author pushg
 */

import java.io.*;

public class Queen {
    private int[] board, directions;
    private int size, numSolutions;
    public static final int QUEEN = 0x01000000;
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int size, c;
        for (;;) {
            StringBuffer sb = new StringBuffer();
            System.out.print("Please input the Queen size: ");
            for (;;) {
                try {
                    c = System.in.read();
                    if (!(c>='0' && c<='9')) {
                         if (sb.length()>0) break;
                         continue;
                    }
                } catch(IOException ex) {
                    return;
                }
                sb.append((char)c);
            }
            try {
                size = Integer.parseInt(sb.toString());
            } catch(NumberFormatException ex) {
                continue;
            }
            if (size==0) break;
            Queen x = new Queen(size);
            x.arrange();
            System.out.println("The "+size+" Queen has "+x.getSolutionNum()+" solutions");
        }   
    }
    public Queen(int size) {
        this.size = size;
        directions = new int[3];
        directions[0] = size+1; 
        directions[1] = size+2; 
        directions[2] = size+3;
        board = new int[(size+2)*(size+2)];
        int lastLine = (size+2)*(size+1);
        for (int i=0; i< size+2; i++) { 
            board[i] = -1;
            board[lastLine+i] = -1;
        }
        for (int i=1; i<=size; i++) { 
            board[i*(size+2)] = -1;
            board[i*(size+2)+size+1] = -1;
        }
    }
    public int getSolutionNum() {
        return numSolutions;
    }
    public void arrange() {
        arrange(1);
    }
    
    private void arrange(int row) {
        for (int i=1; i <= size; i++) { 
            int puton = (size+2)*row+i;
            if (board[puton] == 0) { 
                if (row==size) { 
                    numSolutions++;
                } else {
                    board[puton] = QUEEN; 
                    for (int j=0; j<3; j++) { 
                        for (int k=puton+directions[j]; board[k]>=0; k+=directions[j]) {
                            board[k]++;
                        }
                    }
                    arrange(row+1);
                    board[puton] = 0; 
                    for (int j=0; j<3; j++) { 
                        for (int k=puton+directions[j]; board[k]>=0; k+=directions[j]) { 
                            board[k]--;
                        }
                    }
                }
            }
        }
    }
    
}
