package eu.deswaef.cinderpup.roboinsta.instagram.io.tags;

import eu.deswaef.cinderpup.roboinsta.instagram.io.InstagramOperations;
import eu.deswaef.cinderpup.roboinsta.instagram.io.login.InstagramLoginResult;
import eu.deswaef.cinderpup.roboinsta.instagram.io.login.LoginOperations;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class TagOperations extends InstagramOperations {

    private List<Consumer<InstagramSearchTagsResult>> resultConsumers;
    private List<Consumer<Exception>> exceptionConsumers;

    private String searchTerm = "";


    public TagOperations() {
        this.resultConsumers = new LinkedList<>();
        this.exceptionConsumers = new LinkedList<>();
    }

    public TagOperations withSearchTerm(final String searchTerm) {
        this.searchTerm = searchTerm;
        return this;
    }

    public TagOperations onResult(Consumer<InstagramSearchTagsResult> resultConsumer) {
        this.resultConsumers.add(resultConsumer);
        return this;
    }

    public TagOperations onError(Consumer<Exception> consumer) {
        this.exceptionConsumers.add(consumer);
        return this;
    }

    public void execute() {
        try {
            final InstagramSearchTagsRequest instagramSearchTagsRequest = new InstagramSearchTagsRequest(searchTerm);
            final InstagramSearchTagsResult instagramSearchTagsResult = sendRequest(instagramSearchTagsRequest);
            resultConsumers.forEach(consumer -> consumer.accept(instagramSearchTagsResult));
        } catch (Exception ex) {
            this.exceptionConsumers.forEach(consumer -> consumer.accept(ex));
        }
    }


}
