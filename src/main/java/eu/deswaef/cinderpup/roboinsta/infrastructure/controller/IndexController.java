package eu.deswaef.cinderpup.roboinsta.infrastructure.controller;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class IndexController {

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @RequestMapping(method = RequestMethod.GET)
    public String index(WebRequest request) {
        return "index";
    }
}
