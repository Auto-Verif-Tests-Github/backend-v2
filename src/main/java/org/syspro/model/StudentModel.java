package org.syspro.model;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<StudentEntity> students(long offset, int count) {
        if(offset < 1 || count < 2 || count > 200) {
            throw new IllegalArgumentException();
        }
        return studentRepos.findByIdBetween(offset, offset + count - 1);
    }

    public List<StudentEntity> byStreamId(long streamId) {
        return studentRepos.findByStreamId(streamId);
    }

    public StudentEntity byGithubNickname(String nickname) {
        return studentRepos.findByGithubNickname(nickname).orElseThrow(IllegalArgumentException::new);
    }

    public Map<?,?> delete(long id) {
        studentRepos.deleteById(id);
        return Collections.singletonMap("status", "ok");
    }
}
