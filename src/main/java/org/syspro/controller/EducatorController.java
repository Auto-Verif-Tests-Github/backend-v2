package org.syspro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.syspro.entity.EducatorEntity;
import org.syspro.model.EducatorModel;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "${api.start}/educators")
public class EducatorController {
    private final EducatorModel educatorModel;

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

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    private List<EducatorEntity> educators(@RequestParam(required = false, defaultValue = "1") long offset,
                                           @RequestParam(required = false, defaultValue = "10") int count) {
        return educatorModel.educators(offset, count);
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    private Map<?, ?> delete(@PathVariable long id) {
        return educatorModel.delete(id);
    }
}
