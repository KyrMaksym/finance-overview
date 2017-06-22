package route;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 * Created by Администратор on 17.06.2017.
 */
@Component
public class CamelRouteBuilder extends  AbstractBuilder{
    {
        System.out.println("CamelRouteBuilder is set up");

    }
    @Override
    public void configure() throws Exception {
        from("jms:testQueue")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println(exchange.getIn().getBody().toString());
                    }
                });

    }
}
