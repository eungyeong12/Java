import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App_Mtrx_MtrxArray_FIleIO {
    public static void main(String[] args) throws IOException {
        final String fin_name = "mtrx_data.txt";
        final String fout_name = "mtrx_operation_result.txt";
        Scanner fin = new Scanner(new File(fin_name));
        FileWriter fout = new FileWriter(fout_name);
        Mtrx[] mtrxs = new Mtrx[6];
        mtrxs[0] = Mtrx.fget_Mtrx(fin);
        mtrxs[1] = Mtrx.fget_Mtrx(fin);
        mtrxs[2] = Mtrx.fget_Mtrx(fin);
        mtrxs[0].printMtrx();
        mtrxs[0].fprintMtrx(fout);
        mtrxs[1].printMtrx(); mtrxs[1].fprintMtrx(fout);
        mtrxs[2].printMtrx(); mtrxs[2].fprintMtrx(fout);
        mtrxs[3] = mtrxs[0].addMtrx(mtrxs[1]);
        mtrxs[3].setMtrxName("mAdd_AB");
        mtrxs[3].printMtrx(); mtrxs[3].fprintMtrx(fout);
        mtrxs[4] = mtrxs[0].subMtrx(mtrxs[1]);
        mtrxs[4].setMtrxName("mSub_AB");
        mtrxs[4].printMtrx(); mtrxs[4].fprintMtrx(fout);
        mtrxs[5] = mtrxs[0].mulMtrx(mtrxs[2]);
        mtrxs[5].setMtrxName("mMul_AC");
        mtrxs[5].printMtrx(); mtrxs[5].fprintMtrx(fout);
        fout.close();
    }

}
