package eu.deswaef.cinderpup.roboinsta.instagram.io;

import eu.deswaef.cinderpup.roboinsta.RoboInstaApplication;
import eu.deswaef.cinderpup.roboinsta.instagram.Instagram;
import eu.deswaef.cinderpup.roboinsta.instagram.io.tags.InstagramSearchTagsRequest;
import eu.deswaef.cinderpup.roboinsta.instagram.io.tags.InstagramSearchTagsResultTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest(classes = RoboInstaApplication.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("integrationtest")
public class Instagram4jTest {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment environment;

    @Value("${roboinsta.credentials.username}")
    private String userName;

    @Value("${roboinsta.credentials.password}")
    private String password;

    @Test
    public void testLogin() throws Exception {
        log.info("trying to login with {}", userName);
        Instagram instagram4j = new Instagram(userName, password);
        instagram4j.setup();
        instagram4j.login();
        List<InstagramSearchTagsResultTag> results = instagram4j.sendRequest(
            new InstagramSearchTagsRequest("#overwatch")
        ).getResults();
        assertThat(results).isNotNull();
    }
}
