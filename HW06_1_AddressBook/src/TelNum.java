public class TelNum {
    int nation_code;
    int reg_no;
    int sw_no;
    int line_no;
    public TelNum(int nc, int reg_no, int sw_no, int line_no) {
        this.nation_code = nc;
        this.reg_no = reg_no;
        this.sw_no = sw_no;
        this.line_no = line_no;
    }

    public String toString() {
        String telNumString = String.format("%03d-%3d-%04d-%04d", this.nation_code, this.reg_no, this.sw_no, this.line_no);
        return telNumString;
    }
}
