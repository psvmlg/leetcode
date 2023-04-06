import java.util.ArrayList;
import java.util.List;

public class TestingVariancesJava {

    SomeJavaClass<SubCat> g = new SomeJavaClass();

    public static void main(String[] args) {
        Integer[] x = {2, 3, 4, 4, -5, 4, 6, 2};
        Object[] object = x;
        object[2] = "DD";

        List<Cat> sc = new ArrayList<>();
        TestingVariancesJava f = new TestingVariancesJava();
        //f.append(sc);


    }
    public void append(List<Object> list) {
        list.add(new SubCat());
    }
}

class Cat{}

class SubCat extends Cat{}

class SomeJavaClass<T>{}



