package rabbitmq;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RabbitConfig.class})
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender sender;

    @Test
    public void hello(){
        sender.send();
    }
}
