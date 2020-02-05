package framework;

import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test() {

        String str1 = Singleton.getWord();
        System.out.println("str1: " + str1);
        String str2 = Singleton.getWord();
        System.out.println("str2: " + str2);



    }

}
