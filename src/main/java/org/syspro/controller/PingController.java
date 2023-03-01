package org.syspro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/p/i/n/g")
public class PingController {
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    private Map<?, ?> ping() {
        return Collections.singletonMap("status", "ok");
    }
}
