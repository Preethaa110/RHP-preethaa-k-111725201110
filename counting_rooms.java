import java.util.Scanner;
public class counting_rooms_cses{
        final static int diff[][]={{0,-1},{-1,0},{1,0},{0,1}};
        public static void dfs(char grid[][],int R,int C,int row,int col){
            grid[row][col]='#';
            for (int i=0;i<4;i++){
            int ar=row+diff[i][0];
            int ac=col+diff[i][1];
            if (ar>=0 && ar<R && ac>=0 && ac<C && grid[ar][ac]=='.'){
                dfs(grid,R,C,ar,ac);
            }

            }
        }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m= sc.nextInt();
        int rooms=0;
        char grid[][]= new char [n][m];
        for (int i=0;i<n;i++){
             String a=sc.next();
            for (int j=0;j<m;j++){
                grid[i][j]= a.charAt(j);
            }
        }

        for(int row=0;row<n;row++){
            for (int col=0;col<m;col++){
                if (grid[row][col]=='.'){
                    rooms++;
                    dfs(grid,n,m,row,col);
                }
            }
        }
        
    System.out.println(rooms);
        
    sc.close();
    }

    }
