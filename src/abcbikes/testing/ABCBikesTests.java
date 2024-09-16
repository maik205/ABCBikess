package abcbikes.testing;

import java.util.ArrayList;
import java.util.List;

import abcbikes.testing.tests.FileLoadTest;

public class ABCBikesTests {
    public static void main(String[] args) {
        List<Test> tests = new ArrayList<>();
        tests.add(new FileLoadTest());

        for (int i = 0; i < tests.size(); i++) {
            System.out.printf("Test number %d/%d: %s \n", i + 1, tests.size(), tests.get(i).testName());
            tests.get(i).test();
        }
    }
}
