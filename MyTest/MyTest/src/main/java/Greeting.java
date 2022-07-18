public class Greeting {
    private static final String HELLO = "hello";
    private static final String WORLD = "world";

    public String helloWorld(){
        return HELLO + " " + WORLD;
    }

    public String helloWorld(String name){
        return HELLO + " " + name;
    }

}
