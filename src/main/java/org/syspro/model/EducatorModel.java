package org.syspro.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.syspro.entity.EducatorEntity;
import org.syspro.repository.EducatorRepos;
import org.syspro.utils.crypto.SHA256;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class EducatorModel {
    private final EducatorRepos educatorRepos;
    private final SHA256 sha256;

    @Autowired
    public EducatorModel(EducatorRepos educatorRepos, SHA256 sha256) {
        this.educatorRepos = educatorRepos;
        this.sha256 = sha256;
    }

    public EducatorEntity create(String login, String password, String fullName) {
        return educatorRepos.save(new EducatorEntity(login, sha256.encode(password), fullName));
    }

    public List<EducatorEntity> educators(long offset, int count) {
        if(offset < 1 || count < 2 || count > 200) {
            throw new IllegalArgumentException();
        }
        return educatorRepos.findByIdBetween(offset, offset + count - 1);
    }

    public Map<?,?> delete(long id) {
        educatorRepos.deleteById(id);
        return Collections.singletonMap("status", "ok");
    }
}
