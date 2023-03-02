package org.syspro.model;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.syspro.entity.StudentEntity;
import org.syspro.repository.StudentRepos;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class StudentModel {
    private final StudentRepos studentRepos;

    @Autowired
    public StudentModel(StudentRepos studentRepos) {
        this.studentRepos = studentRepos;
    }

    public List<StudentEntity> addStudentsFromCSV(long streamId, MultipartFile file) throws IOException {
        if(!"text/csv".equals(file.getContentType())) {
            throw new IllegalArgumentException("this is not csv file");
        }
        List<StudentEntity> students = new ArrayList<>();
        StringReader reader = new StringReader(new String(file.getBytes(), StandardCharsets.UTF_8));
        try(CSVReader csvReader = new CSVReader(reader)) {
            for (String[] strings : csvReader) {
                if(!strings[0].isEmpty() && !strings[1].isEmpty() && strings[2].matches("\\d+")) {
                    try {
                        students.add(studentRepos.save(new StudentEntity(streamId, strings[0], strings[1])));
                    } catch (RuntimeException ignored) {}
                }
            }
        }
        return students;
    }

    public List<StudentEntity> students(Pageable pageable) {
        return studentRepos.findAll(pageable).getContent();
    }

    public List<StudentEntity> byStreamId(long streamId, Pageable pageable) {
        return studentRepos.findByStreamId(streamId, pageable).getContent();
    }

    public StudentEntity byGithubNickname(String nickname) {
        return studentRepos.findByGithubNickname(nickname).orElseThrow(IllegalArgumentException::new);
    }

    public Map<?,?> delete(long id) {
        studentRepos.deleteById(id);
        return Collections.singletonMap("status", "ok");
    }
}
