
Given a matrix of size n*m. Every cell of matrix contains either 'A' or 'B'. 

Exchange is defined as swaping the characters between two cells. 

Your task is to find the minimum number of exchange needed to rearrange the given matrix such that no adjacent cell contains the same characters.

Two cells are adjacent if they share one of their common sides (left,right,front or back if exists). 

Java Code 

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] matrix = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    matrix[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.MinimumExchange(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int MinimumExchange(char[][] matrix) {
        int a = 0, b = 0;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == 'A'){
                    a++;
                } else {
                    b++;
                }
            }
        }
        if(a > b){
            return Count('A', 'B', matrix);
        } else if(a < b){
            return Count('B', 'A', matrix) ;
        } else {
            return Math.min(Count('A', 'B', matrix), Count('B', 'A', matrix));
        }
    }

    private int Count(char x, char y, char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int cnt = 0;
        for(int i = 0; i < m; ++i){
            char ch = x;
            if(i % 2 == 1){
                ch = y;
            }
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] != ch){
                    cnt++;
                }
                if(ch == x){
                    ch = y;
                } else {
                    ch = x;
                }
            }
        }
        return cnt / 2;
    }
}
