package DI;

public class TestMain {

    public static void main(String[] args) {
                        //Test 생성될 때 객체 생성을 우리가 하는게 아니라 스프링이 해주는 것이 IOC
    Test test = new Test(new DITestImpl());
    test.show();
    }
}
