package put;

import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;

@javax.jws.WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface WebService {

    /**
     * Saying hello to you by name.
     *
     * @return helloMessage with name
     */
    @WebMethod
    String sayHello(String name);
}
