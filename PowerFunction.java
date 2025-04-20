package interviewQA.Recursion;

public class PowerFunction {

    //Partially accepted due to stack overflow
    public double myPow(double x, int n) {
        double ans = calcPow(x,n);
        if(n < 0){
            ans = 1/ans;
        }
        return ans;
    }
    public double calcPow(double x, int n){
        if(Math.abs(n) == 1){
            return x;
        }
        return x * myPow(x, Math.abs(n)-1);
    }

    public double myPowOptimised(double x, int n) {
        long nn = n;
        if(nn < 0){
            nn = -1 * nn;
        }
        double ans = 1.0;
        while(nn > 0){
            if(nn % 2 == 0){
                x = x*x;
                nn = nn/2;
            }else if(nn % 2 == 1){
                ans = ans * x;
                nn = nn - 1;
            }
        }
        if(n < 0){
            ans = (double)(1.0)/(double)(ans);
        }
        return ans;
    }
}
