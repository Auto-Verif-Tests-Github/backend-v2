package org.syspro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.syspro.entity.EducatorEntity;
import org.syspro.model.EducatorModel;

@RestController
@RequestMapping(value = "${api.start}/educators")
public class EducatorController {
    private EducatorModel educatorModel;

    @Autowired
    public EducatorController(EducatorModel educatorModel) {
        this.educatorModel = educatorModel;
    }

    @RequestMapping(value = "/{login}", method = {RequestMethod.GET, RequestMethod.POST})
    private EducatorEntity create(@PathVariable String login,
                                  @RequestParam String password,
                                  @RequestParam(name = "full_name") String fullName) {
        return educatorModel.create(login, password, fullName);
    }
}
