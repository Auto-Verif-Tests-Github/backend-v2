package org.syspro.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.syspro.entity.EducatorEntity;
import org.syspro.repository.EducatorRepos;
import org.syspro.utils.crypto.SHA256;

@Component
public class EducatorModel {
    private EducatorRepos educatorRepos;
    private SHA256 sha256;

    @Autowired
    public EducatorModel(EducatorRepos educatorRepos, SHA256 sha256) {
        this.educatorRepos = educatorRepos;
        this.sha256 = sha256;
    }

    public EducatorEntity create(String login, String password, String fullName) {
        return educatorRepos.save(new EducatorEntity(login, sha256.encode(password), fullName));
    }
}
