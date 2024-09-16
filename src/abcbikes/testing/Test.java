package abcbikes.testing;

public abstract class Test {

    protected abstract String testName();

    protected abstract boolean doTest();

    public void test(){
        System.out.println("Performing test...");
        System.out.print("Result: ");
        if (doTest()){
            System.out.print("Success \n");
        }
        else {
            System.out.println("Failed.");
        }
    }
}
