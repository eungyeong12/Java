import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Mtrx {
    private String m_name;
    private int n_row;
    private int n_col;
    private double[][] mtrx_data;
    public Mtrx() { }; // default constructor
    public Mtrx(String nm) {
        this.m_name = nm;
        this.n_row = 0;
        this.n_col = 0;
    }
    public Mtrx(String nm, int n_row, int n_col) {
        this.m_name = nm;
        this.n_row = n_row;
        this.n_col = n_col;
        mtrx_data = new double[n_row][n_col];
    }

    public Mtrx(String nm, int n_row, int n_col, double[][] m_data) {
        this.m_name = nm;
        this.n_row = n_row;
        this.n_col = n_col;
        mtrx_data = new double[n_row][n_col];
        for (int r=0; r<n_row; r++) {
            for (int c=0; c<n_col; c++) {
                mtrx_data[r][c] = m_data[r][c];
            }
        }
    }

    public static Mtrx fget_Mtrx(Scanner fin) {
        String m_name = fin.next();
        int n_row = fin.nextInt();
        int n_col = fin.nextInt();
        double[][] mtrx_data = new double[n_row][n_col];
        for (int r=0; r<n_row; r++) {
            for (int c=0; c<n_col; c++) {
                mtrx_data[r][c] = fin.nextFloat();
            }
        }
        Mtrx mtrx = new Mtrx(m_name, n_row, n_col, mtrx_data);
        return mtrx;
    }

    public void setMtrxName(String nm) {
        m_name = nm;
    }

    public void printMtrx() {
        System.out.printf("%s (%d x %d) = \n", this.m_name, this.n_row, this.n_col);
        for(int r=0; r<this.n_row; r++) {
            for(int c=0; c<this.n_col; c++) {
                System.out.printf("%7.2f", this.mtrx_data[r][c]);
            }
            System.out.printf("\n");
        }
    }

    public void fprintMtrx(FileWriter fout) throws IOException {
        String str_data;
        fout.write(this.m_name);
        fout.write("(");
        fout.write(String.format("%3d", this.n_row)); fout.write("  x");
        fout.write(String.format("%3d", this.n_col)); fout.write(" )\n");
        for(int r=0; r<n_row; r++) {
            for(int c=0; c<n_col; c++) {
                str_data = String.format("%7.2f", this.mtrx_data[r][c]);
                fout.write(str_data);
            }
            fout.write("\n");
        }
        fout.flush();
    }

    public Mtrx addMtrx(Mtrx other) {
        Mtrx m_result = new Mtrx("R", this.n_row, this.n_col);

        for(int r=0; r<n_row; r++) {
            for(int c=0; c<n_col; c++) {
                m_result.mtrx_data[r][c] = this.mtrx_data[r][c] + other.mtrx_data[r][c];
            }
        }
        return m_result;
    }

    public Mtrx subMtrx(Mtrx other) {
        Mtrx m_result = new Mtrx("R", this.n_row, this.n_col);

        for(int r=0; r<n_row; r++) {
            for(int c=0; c<n_col; c++) {
                m_result.mtrx_data[r][c] = this.mtrx_data[r][c] - other.mtrx_data[r][c];
            }
        }
        return m_result;
    }

    public Mtrx mulMtrx(Mtrx other) {
        Mtrx m_result = new Mtrx("R", this.n_row, other.n_col);
        double temp_sum = 0.0;

        for(int r=0; r<this.n_row; r++) {
            for(int c=0; c<other.n_col; c++) {
                temp_sum = 0.0;
                for(int k=0; k<this.n_col; k++) {
                    temp_sum += this.mtrx_data[r][k] * other.mtrx_data[k][c];
                }
                m_result.mtrx_data[r][c] = temp_sum;
            }
        }
        return m_result;
    }
}
