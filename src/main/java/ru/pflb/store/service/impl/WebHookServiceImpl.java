package ru.pflb.store.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.pflb.store.service.WebHookService;

@Service
public class WebHookServiceImpl implements WebHookService {

    private RestTemplate restTemplate;

    @Autowired
    public WebHookServiceImpl(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    @Override
    @Async
    public String getWebHook() {
        String url = "https://webhook.site/ee211f33-e9a4-412b-94b9-6ff620c34c51";
        return this.restTemplate.getForObject(url,String.class);

    }
}
