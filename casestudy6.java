public class Knapsack {

    static int knapsack(int W, int wt[], int val[], int n) {

        int K[][] = new int[n + 1][W + 1];

        for(int i=0;i<=n;i++) {

            for(int w=0;w<=W;w++) {

                if(i==0 || w==0)
                    K[i][w]=0;

                else if(wt[i-1] <= w)

                    K[i][w] = Math.max(
                            val[i-1] + K[i-1][w-wt[i-1]],
                            K[i-1][w]);

                else

                    K[i][w] = K[i-1][w];
            }
        }

        return K[n][W];
    }

    public static void main(String[] args) {

        int values[] = {60,100,120};
        int credits[] = {10,20,30};

        int maxCredits = 50;

        System.out.println(
                "Maximum Learning Value = "
                + knapsack(maxCredits,
                credits,
                values,
                values.length));
    }
}
