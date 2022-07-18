import org.junit.jupiter.api.*;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {

    private Greeting greeting;
    @BeforeAll
    public static void beforeClass(){
        System.out.println("B4 all-----only called once");
    }


    @BeforeEach
    void setUp() {
        System.out.println("beforeEach  --->");
        greeting = new Greeting();
    }

    @Test
    void helloWorld() {
        System.out.println(greeting.helloWorld());
    }

    @Test
    void testHelloWorld() {
        System.out.println(greeting.helloWorld("Gokul"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("afterEach --->");
    }

    @AfterAll
    public static void afterClass(){
        System.out.println("After all-----only called once");
    }
}