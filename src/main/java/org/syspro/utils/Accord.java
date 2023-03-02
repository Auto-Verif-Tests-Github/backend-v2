package org.syspro.utils;

import org.springframework.stereotype.Component;

@Component
public class Accord {
    public void repositoryGetAllChecker(long offset, int count) {
        if(offset < 1 || count < 1 || count > 200) {
            throw new IllegalArgumentException("args not match pattern");
        }
    }
}