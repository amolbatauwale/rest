package restful;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class GreetingController {

  private static final String template = "Hello, %s!, price %s";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping(method = RequestMethod.POST,value="/hello")
  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name, 
                           @RequestParam(value="price", defaultValue="100") String price ) {
    return new Greeting(counter.incrementAndGet(),
              String.format(template, name,price));
  }


}