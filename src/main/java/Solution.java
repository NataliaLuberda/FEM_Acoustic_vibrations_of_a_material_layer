import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.IterativeLegendreGaussIntegrator;
import org.apache.commons.math3.linear.*;
import org.apache.commons.math3.util.FastMath;


import static com.sun.marlin.FloatMath.max;
import static org.apache.commons.math3.util.FastMath.*;

public class Solution {

    private final IterativeLegendreGaussIntegrator integrate =new IterativeLegendreGaussIntegrator(2, 1e-5, 1e-5);
    public final int n;

    private final double h;

    public Solution(int n) {
        this.n = n;
        this.h = 2.0 / n;
    }


    public double base(int i, double x) {
        double xp = h * (i - 1);//xp - przed v
        double v = h * i;//mid
        double xa = h * (i + 1);//xa - po v

        if (x >= FastMath.max(0,xp) && x <= v) return (x - xp) / h;
        else if (x > v && x <= min(xa,2)) return (xa - x) / h;
        return 0;
    }

    public double basePrim(int i, Double x) {
        if (x >= FastMath.max(h * (i - 1),0) && x <= h * i) {
            return 1 / h;
        } else if (x > h * i && x <= min(h * (i + 1),2)) {
            return -1 / h;
        } else {
            return 0;
        }
    }


    public double[] coefficients() {
        Array2DRowRealMatrix bMatrix = (Array2DRowRealMatrix) getBMatrix();
        ArrayRealVector vectorL = getLMatrix();
        RealVector vectorW = new LUDecomposition(bMatrix).getSolver().solve(vectorL);
        double[] result = vectorW.toArray();
        return result;
    }

    public ArrayRealVector getLMatrix() {
        ArrayRealVector vectorL = new ArrayRealVector(n);
        for (int i = 1; i < n + 1; i++) {
            int finalI = i;
            UnivariateFunction ej = x -> sin(x)*base(finalI,x);
            double l = 0.0;
            l += integrate.integrate(Integer.MAX_VALUE, ej, FastMath.max(h * (i - 1),0), min(2,h * (i)));
            if(h*(i+1) <= 2) {
                l += integrate.integrate(Integer.MAX_VALUE, ej, FastMath.max(h * (i), 0), min(2, h * (i + 1)));
            }
            vectorL.addToEntry(i - 1, l);
        }
        return vectorL;
    }

    public RealMatrix getBMatrix() {
        RealMatrix bMatrix = new Array2DRowRealMatrix(n, n);

        for (int i=1;i<n+1;i++) {
            for (int j = 1; j < n + 1; j++) {
                double b = 0;
                if (i == j) {
                    int finalI = i;
                    UnivariateFunction ei = x -> base(finalI, x) * base(finalI, x);
                    UnivariateFunction eiPrim = x -> basePrim(finalI, x) * basePrim(finalI, x);
                    b = integrate.integrate(Integer.MAX_VALUE, eiPrim, FastMath.max(0, h * (finalI - 1)), min(2, h * (finalI + 1))) - integrate.integrate(Integer.MAX_VALUE, ei, FastMath.max(0, h * (finalI - 1)), min(2, h * (finalI + 1))) - base(i, 2) * base(j, 2);
                } else if (i == j + 1) {
                    int finalI1 = i;
                    int finalJ = j;
                    UnivariateFunction ei = x -> base(finalI1, x) * base(finalJ, x);
                    UnivariateFunction eiPrim = x -> basePrim(finalI1, x) * basePrim(finalJ, x);

                    b = integrate.integrate(Integer.MAX_VALUE, eiPrim, FastMath.max(0, h * (max(finalI1, finalJ) - 1)), min(2, h * (min(finalI1, finalJ) + 1))) - integrate.integrate(Integer.MAX_VALUE, ei, FastMath.max(0, h * (max(finalI1, finalJ) - 1)), min(2, h * (min(finalI1, finalJ) + 1))) - base(i, 2) * base(j, 2);
                } else if (i + 1 == j) {
                    int finalI1 = i;
                    int finalJ = j;
                    UnivariateFunction ei = x -> base(finalI1, x) * base(finalJ, x);
                    UnivariateFunction eiPrim = x -> basePrim(finalI1, x) * basePrim(finalJ, x);

                    b = integrate.integrate(Integer.MAX_VALUE, eiPrim, FastMath.max(0, h * (max(finalI1, finalJ) - 1)), min(2, h * (min(finalI1, finalJ) + 1))) - integrate.integrate(Integer.MAX_VALUE, ei, FastMath.max(0, h * (max(finalI1, finalJ) - 1)), min(2, h * (min(finalI1, finalJ) + 1))) - base(i, 2) * base(j, 2);
                }
                bMatrix.addToEntry(i - 1, j - 1, b);
            }
        }
        return bMatrix;
    }
}

