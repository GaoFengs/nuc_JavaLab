/**
 * 
 * @author ����
 *
�������ݣ�

����:
4 5
0  1 -1  1 -1
1 -1  1  1 -1
0  0  0 -1  0
0 -1  1 -1  0
�����false

����:
5 5
0  1 -1  1 -1
1 -1  1 -1 -1
0  0  0  1  0
0 -1  1 -1  0
0  1  0  0 -1
�����true
 */
import java.util.*;
public class Board {

	public static boolean checkWon(int[][] board){
		
		int row=board.length;
		int col=board[0].length;
		
		for(int i=0;i<row;i++){//�жϺ�
			for(int j=1;j<col-1;j++){
				if(board[i][j-1]+board[i][j]+board[i][j+1]==3){
					return true;
				}
			}
		}
		
		for(int j=0;j<col;j++){
			for(int i=1;i<row-1;i++){
				if(board[i-1][j]+board[i][j]+board[i+1][j]==3){//�ж���
					return true;
				}
			}
		}
		
		for(int i=1;i<row-1;i++){
			for(int j=1;j<col-1;j++){
				boolean d3=board[i-1][j-1]+board[i][j]+board[i+1][j+1]==3;//��б
				boolean d4=board[i+1][j-1]+board[i][j]+board[i-1][j+1]==3;//��б
				if(d3||d4){
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int r=in.nextInt();
		int c=in.nextInt();
		int[][] s=new int[r][c];
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
				s[i][j]=in.nextInt();
		
		System.out.println(checkWon(s));
	}

}
