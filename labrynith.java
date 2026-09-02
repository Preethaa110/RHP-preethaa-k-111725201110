import java.util.*;
public class labrynith{
	private static String getPath(int pr, int pc, char g[][]){
		StringBuilder sb=new StringBuilder();
		char ch=g[pr][pc];
		while(ch!='A'){
			sb.append(ch);
			if(ch=='U') pr++;
			else if(ch == 'L') pc++;
			else if(ch=='R') pc--;
			else if(ch=='D') pr--;
			ch=g[pr][pc];
		}
		return sb.reverse().toString();
	}
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int R=sc.nextInt();
		int C=sc.nextInt();
		sc.nextLine();
		char[][] g=new char[R][C];
		for(int r=0; r<R; r++){
			g[r]=sc.nextLine().toCharArray();
		}
		Queue<int[]> q=new LinkedList<>();
		for(int row=0; row<R;row++){
			for(int col=0; col<C;col++){
				if(g[row][col]=='A'){
					q.add(new int[]{row,col});
					row=R;
					break;
				}
			}
		}
		int hops=-1, br=-1, bc=-1;
		boolean found=false;
		int diff[]={0,1,0,-1,0};
		final String dir="RDLU";
		while(!q.isEmpty()){
			int qsize=q.size();
			hops++;
			if(found){
				System.out.println("YES");
				System.out.println(hops);
				System.out.println(getPath(br,bc, g));
				return;
			}
			while(qsize-->0){
				int []cell=q.poll();
				int row=cell[0], col=cell[1];
				for(int i=0; i<4; i++){
					int ar=row+diff[i];
					int ac=col+diff[i+1];
					if(ar>=0 && ar<R && ac>=0 && ac<C){
						char ch=g[ar][ac];
						if(ch=='.'){
							q.add(new int[]{ar,ac});
							g[ar][ac]=dir.charAt(i);
						}
						else if(ch=='B'){
							found=true;
							br=ar;bc=ac;
							q.add(new int[]{ar,ac});
							g[ar][ac]=dir.charAt(i);
						}
					}
				}
			}
		}
		System.out.println("NO");
	}
}
