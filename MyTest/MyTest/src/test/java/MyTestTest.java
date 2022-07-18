import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyTestTest {

    @Test
    void myTest() {
        MyTest myTest = new MyTest();
        String result =  myTest.testMe();
        assertEquals("mytest", result);
    }
}