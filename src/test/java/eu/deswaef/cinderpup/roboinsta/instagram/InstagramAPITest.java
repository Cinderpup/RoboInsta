package eu.deswaef.cinderpup.roboinsta.instagram;

import eu.deswaef.cinderpup.roboinsta.RoboInstaApplication;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RoboInstaApplication.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("integrationtest")
public class InstagramAPITest {

    private Instagram api;

    @Value("${roboinsta.credentials.username}")
    private String userName;

    @Value("${roboinsta.credentials.password}")
    private String password;

    @Before
    public void setUp() throws Exception {
        api = new Instagram();
        api.login(getUserName(), getPassword()).execute();
    }

    protected Instagram getApi() {
        return api;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
