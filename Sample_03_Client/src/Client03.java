import com.mkyong.ws.HelloWorld;
import com.mkyong.ws.HelloWorldService;

public class Client03 {

    public static void main(String[] args) {
        testSOAPFromClient();
    }

    private static void testSOAPFromClient() {
        HelloWorldService service = new HelloWorldService();
        HelloWorld port = service.getHelloWorldPort();

        System.out.println(port.getHelloWorld("Arthur"));
    }
}
