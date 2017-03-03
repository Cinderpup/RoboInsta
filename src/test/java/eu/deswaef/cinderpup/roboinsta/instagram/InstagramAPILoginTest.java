package eu.deswaef.cinderpup.roboinsta.instagram;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class InstagramAPILoginTest extends InstagramAPITest {

    @Test
    public void loginAndSuccess() throws Exception {
        getApi().login(getUserName(), getPassword())
            .onResult(result -> {
                assertThat(result.getStatus()).isEqualToIgnoringCase("ok");
                assertThat(result.getLogged_in_user().get("username")).isEqualTo(getUserName());
            })
            .onError(exception -> fail(exception.getMessage())).execute();
    }
}
