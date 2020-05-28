package get.interfaces;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This DataFlex Web Service opens up country information. 2 letter ISO codes are used for Country code. There are functions to retrieve the used Currency, Language, Capital City, Continent and Telephone code.
 * <p>
 * <p>
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01
 * Generated source version: 2.2
 */
@WebServiceClient(name = "CountryInfoService", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", wsdlLocation = "file:/D:/web_service/src/main/resources/CountryInfoService.wsdl")
public class CountryInfoService extends Service {

    private final static URL COUNTRYINFOSERVICE_WSDL_LOCATION;
    private final static WebServiceException COUNTRYINFOSERVICE_EXCEPTION;
    private final static QName COUNTRYINFOSERVICE_QNAME = new QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        COUNTRYINFOSERVICE_WSDL_LOCATION = url;
        COUNTRYINFOSERVICE_EXCEPTION = e;
    }

    private CountryInfoServiceSoapType infoServiceSoapType;

    public CountryInfoService() {
        super(__getWsdlLocation(), COUNTRYINFOSERVICE_QNAME);
    }

    public CountryInfoService(WebServiceFeature... features) {
        super(__getWsdlLocation(), COUNTRYINFOSERVICE_QNAME, features);
    }

    public CountryInfoService(URL wsdlLocation) {
        super(wsdlLocation, COUNTRYINFOSERVICE_QNAME);
    }

    public CountryInfoService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, COUNTRYINFOSERVICE_QNAME, features);
    }

    public CountryInfoService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CountryInfoService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (COUNTRYINFOSERVICE_EXCEPTION != null) {
            throw COUNTRYINFOSERVICE_EXCEPTION;
        }
        return COUNTRYINFOSERVICE_WSDL_LOCATION;
    }


//        return super.getPort(new QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoServiceSoap"), CountryInfoServiceSoapType.class);
//    }

    /**
     * Получение порта сервиса в отдельном потоке.
     * Решение для устранения NPE от JAX-RS в Java 8
     * web resource: http://www.jcraftsmen.com/workaround-for-jax-ws-nullpointerexception-when-calling-web-service-from-embedded-java-8-jvm/
     *
     * @return returns CountryInfoServiceSoapType
     */
    @WebEndpoint(name = "CountryInfoServiceSoap")
    public CountryInfoServiceSoapType getCountryInfoServiceSoap() {
        if (infoServiceSoapType == null) {
            // We create a thread so that we can set the ClassLoader
            Thread thread = new Thread() {
                public void run() {
                    synchronized (this) {
                        QName qName = new QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoService");
                        Service service = Service.create(__getWsdlLocation(), qName);
                        infoServiceSoapType = service.getPort(CountryInfoServiceSoapType.class);
                        notify();
                    }
                }
            };

            // Thread.currentThread().getContextClassloader()
            // returns null in com.sun.xml.internal.ws.client.ClientContainer.
            // (See http://hg.openjdk.java.net/jdk8/jdk8/jaxws/file/d03dd22762db/src/share/jaxws_classes/com/sun/xml/internal/ws/client/ClientContainer.java, lines 39-47)
            // To work around that, I force setting of the ContextClassLoader
            // on this thread (in which the Service.getPort() method will run) so
            // that when ClientContainer calls Thread.currentThread().getContextClassLoader(), it doesn't get a null
            // (i.e., the bootstrap classloader).
            //
            thread.setContextClassLoader(CountryInfoService.class.getClassLoader());
            thread.start();
            // Wait until above thread completes in order to return yourWebService
            synchronized (thread) {
                try {
                    thread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return infoServiceSoapType;
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CountryInfoServiceSoapType
     */
    @WebEndpoint(name = "CountryInfoServiceSoap")
    public CountryInfoServiceSoapType getCountryInfoServiceSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoServiceSoap"), CountryInfoServiceSoapType.class, features);
    }

    /**
     * @return returns CountryInfoServiceSoapType
     */
    @WebEndpoint(name = "CountryInfoServiceSoap12")
    public CountryInfoServiceSoapType getCountryInfoServiceSoap12() {
        return super.getPort(new QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoServiceSoap12"), CountryInfoServiceSoapType.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns CountryInfoServiceSoapType
     */
    @WebEndpoint(name = "CountryInfoServiceSoap12")
    public CountryInfoServiceSoapType getCountryInfoServiceSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoServiceSoap12"), CountryInfoServiceSoapType.class, features);
    }

}
