package example;

import com.mkyong.ws.HelloWorld;
import com.mkyong.ws.HelloWorldImplService;

import javax.xml.namespace.QName;

/**
 * Created by arthur on 12/24/17.
 */
public class HelloWorldClient {
    public static void main(String[] argv) {
        HelloWorld service = new HelloWorldImplService().getHelloWorldImplPort();
//      HelloWorld service = new HelloWorldImplService().getPort(new QName("http://ws.mkyong.com/", "HelloWorldImplPort"), HelloWorld.class);

        System.out.println(service.getHelloWorldAsString("34"));
    }
}
