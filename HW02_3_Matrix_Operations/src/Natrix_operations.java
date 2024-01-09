public class Natrix_operations {
    public static void printMtrx(String mtrx_name, double mtrx_data[][]) {
        System.out.printf("%s = \n", mtrx_name);
        for(int r=0; r<mtrx_data.length; r++) {
            for(int c=0; c<mtrx_data[r].length; c++) {
                System.out.printf("%7.2f", mtrx_data[r][c]);
            }
            System.out.printf("\n");
        }
    }
    public static double[][] addMtrx(double mA_data[][], double mB_data[][]) {
        double mR_data[][];
        int n_row = mA_data.length;
        int n_col = mA_data[0].length;
        mR_data = new double[n_row][n_col];

        for(int r = 0; r<n_row; r++) {
            for(int c=0; c<n_col; c++) {
                mR_data[r][c] = mA_data[r][c] + mB_data[r][c];
            }
        }
        return mR_data;
    }
    public static double[][] subMtrx(double mA_data[][], double mB_data[][]) {
        double mR_data[][];
        int n_row = mA_data.length;
        int n_col = mA_data[0].length;
        mR_data = new double[n_row][n_col];
        mR_data = new double[n_row][n_col];

        for(int r=0; r<n_row; r++) {
            for(int c=0; c<n_col; c++) {
                mR_data[r][c] = mA_data[r][c] - mB_data[r][c];
            }
        }
        return mR_data;
    }
    public static double[][] mulMtrx(double mA_data[][], double mB_data[][]) {
        double mR_data[][];
        int nA_row = mA_data.length;
        int nB_col = mB_data[0].length;
        int nA_col = mA_data[0].length;
        double temp_sum;
        mR_data = new double[nA_row][nB_col];

        for(int r=0; r<nA_row; r++) {
            for(int c=0; c<nB_col; c++) {
                temp_sum = 0.0;
                for(int k=0; k<nA_col; k++) {
                    temp_sum += mA_data[r][k] * mB_data[k][c];
                }
                mR_data[r][c] = temp_sum;
            }
        }
        return mR_data;
    }

    public static void main(String[] args) {
        double mA[][] = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}};
        double mB[][] = {{1,0,0,0,0}, {0,1,0,0,0}, {0,0,1,0,0}};
        double mAddAB[][];
        double mSubAB[][];
        printMtrx("mA", mA);
        printMtrx("mB", mB);
        mAddAB = addMtrx(mA, mB);
        printMtrx("mAddAB", mAddAB);
        mSubAB = subMtrx(mA, mB);
        printMtrx("mSubAB", mSubAB);
        double mC[][] = {{1,0,0}, {0,1,0}, {0,0,1}, {0,0,0}, {0,0,0}};
        double mMulAC[][];
        printMtrx("mA", mA);
        printMtrx("mC", mC);
        mMulAC = mulMtrx(mA, mC);
        printMtrx("mMulAC", mMulAC);
    }
}