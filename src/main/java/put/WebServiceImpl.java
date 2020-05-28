package put;

@javax.jws.WebService(endpointInterface = "put.WebService")
public class WebServiceImpl implements WebService {

    @Override
    public String sayHello(String name) {
        return "Hello, "+name;
    }

    // manual starting endpoint
//    public static void main(String[] args) {
//        WebServiceImpl ws = new WebServiceImpl();
//        Endpoint.publish("http://localhost:9000/WebService", ws);
//    }
}
