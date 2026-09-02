import java.util.*;
import java.util.Map;
public class min_heapp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        Map<Integer, List <int []>> g = new HashMap<>();
        while(R-- >0){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int dist = sc.nextInt();
            if(!g.containsKey(src)){
            g.put(src,new ArrayList<>());
            }
            g.get(src).add(new int[]{dest,dist});
            if(!g.containsKey(dest)){
                g.put(dest,new ArrayList<>());
            }
            g.get(dest).add(new int[]{src,dist});
        }
        int st=sc.nextInt();
        int end=sc.nextInt();
        Set<Integer> vis=new HashSet<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{st,0});
        while(!pq.isEmpty()){
            int [] curr= pq.poll();
            int currCity=curr[0];
            int currDist=curr[1];
            if(currCity==end){
                System.out.println(currDist);
                return;
            }
            if (vis.contains(currCity)) continue;
            vis.add(currCity);
            for(int[] ocarr:g.getOrDefault(currCity,new ArrayList<>())){
                if(!vis.contains(ocarr[0])){
                    int oc= ocarr[0],ocd =currDist+ocarr[1];
                    pq.add(new int[]{oc,ocd});
                }
            }
        }

    }
    System.out.println("City"+end+"Cannot be reached");
}
    
