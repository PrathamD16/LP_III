import java.util.*;

public class GraphColoring {
    static void print(int arr[]) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static boolean isSafe(int src, int g[][], int c, int colors[]){
        for(int i = 0; i < g[src].length; i++){
            if(g[src][i] == 1 && colors[i] == c)return false;
        }
        return true;
    }

    static boolean graphColorUtil(int src, int g[][], int m, int colors[], int totalVertex){
        if(src == totalVertex)return true;

        for(int c = 1; c <= m; c++){
            if(isSafe(src, g, c, colors)){
                colors[src] = c;
                if(graphColorUtil(src+1, g, m, colors, totalVertex) == true){
                    return true;
                }
                colors[src] = 0;
            }
        }

        return false;
    }

    static boolean graphColoring(int g[][], int m, int totalVertex){
        int colors[] = new int[totalVertex];
        if(graphColorUtil(0, g, m, colors, totalVertex)){
            print(colors);
            return true;
        }

        System.out.println("No solution possible!!");
        return false;
    }



    public static void main(String[] args) {
        int g[][] = { { 0, 1, 1, 1 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 1 },
                { 1, 0, 1, 0 } };

        boolean oclo = graphColoring(g, 3, g.length);
    
    }
}