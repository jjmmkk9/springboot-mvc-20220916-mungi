package DI;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Test {

    private DITest diTest;  //interface를 생성해두고
   //private T1 t1;

    public Test(DITest diTest) { //Test가 생성될 때 DITest 생성되어야하는 종속성 주입
        //diTest = new DITestImpl2();
        //t1 = new T1();
    }

    public void show() {
        //종속성 주입된 후 인터페이스 메소드 실행
        diTest.testPrint();
        //t1.t1print();
    }
}