package eu.deswaef.cinderpup.roboinsta.instagram;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.assertj.core.api.Assertions.assertThat;

public class InstagramAPITagsTest extends InstagramAPITest {

    @Test
    public void gettingApisGetsResult() throws Exception {
        getApi().tags().withSearchTerm("overwatch")
            .onResult(
                result -> {
                    assertThat(result.getStatus()).isEqualToIgnoringCase("ok");
                    assertThat(result.getResults().size()).isEqualTo(50);
                })
            .onError(result -> fail("failed trying to search for tags: " + result))
            .execute();
    }
}
