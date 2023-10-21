public class Assignment3 {
    static int f1(int ind, int wt[], int val[], int W){
        if(ind == 0){
            if(wt[0] <= W)return val[0];
            return 0;
        }
        if(wt[ind] <= W){
            int include = val[ind] + f1(ind-1, wt, val, W-wt[ind]);
            int not_include = 0 + f1(ind-1, wt, val, W);
            return Math.max(include, not_include);
        }
        return 0 + f1(ind-1, wt, val, W);
    }
    static int findMax(int wt[], int val[], int W){
        int n = wt.length;
        // return f1(n-1, wt, val, W);
        int dp[][] = new int[n][W+1];
        for(int w = 0; w <= W; w++){
            if(wt[0] <= w){
                dp[0][w] = val[0];
            }
        }

        for(int i = 1; i < n; i++){
            for(int w = 0; w <= W; w++){
                if(wt[i] <= w){
                    int include = val[i] + dp[i-1][w-wt[i]];
                    int not_include = 0 + dp[i-1][w];
                    dp[i][w] = Math.max(include, not_include);
                }
                else{
                    dp[i][w] = 0 + dp[i-1][w];
                }
            }
        }

        return dp[n-1][W];
    }
    public static void main(String[] args) {
        int wt[] = { 1, 2, 3, 5 };
        int val[] = { 20, 40, 30, 10 };
        int W = 5;
        System.out.println(findMax(wt, val, W));
    }

}
