package org.sst.cart.services;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

public abstract class HttpService {
    RestTemplate client;
    public void init(String baseUrl) {
        this.client = new RestTemplate();
        client.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
    }
}