public class JavaProg_Debug_Ex {
    public int add(int a, int b) {
        int result = a+b;
        return result;
    }
    public int mul(int a, int b) {
        int result = a*b;
        return result;
    }

    public static void main(String[] args) {
        int result;
        JavaProg_Debug_Ex jv_dbg_ex = new JavaProg_Debug_Ex();
        for(int a=0; a<5; a++) {
            for(int b=0; b<3; b++) {
                result = jv_dbg_ex.add(a,b);
                System.out.printf("%d + %d = %d\n", a, b, result);
                result = jv_dbg_ex.mul(a,b);
                System.out.printf("%d * %d = %d\n", a, b, result);
            }
        }
    }
}
