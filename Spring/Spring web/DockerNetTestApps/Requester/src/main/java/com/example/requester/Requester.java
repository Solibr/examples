package com.example.requester;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "Some", url = "${url}")
public interface Requester {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String getString();


}
