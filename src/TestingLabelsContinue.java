public class TestingLabelsContinue {


    public static void main(String[] args) {


        int[] in = new int[]{1, 2, 3, 4, 5, 6, 7};
        int num = 90000;
        System.out.println("DD");
        out: for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in.length; j++) {
                if (in[j] > 2) {
                    break;
                }
            }
            System.out.println(in[i]);
        }
    }
}
