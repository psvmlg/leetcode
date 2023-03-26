import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

    public static void main(String[] args) {
        PrimeNumbers p = new PrimeNumbers();
        System.out.println(p.primeDecompose(9));
    }

    protected List<Integer> primeDecompose(int num) {
        List<Integer> primeFactors = new ArrayList<Integer>();
        int factor = 2;
        while (num >= factor * factor) {
            if (num % factor == 0) {
                primeFactors.add(factor);
                num = num / factor;
            } else {
                factor += 1;
            }
        }
        primeFactors.add(num);
        return primeFactors;
    }
}
