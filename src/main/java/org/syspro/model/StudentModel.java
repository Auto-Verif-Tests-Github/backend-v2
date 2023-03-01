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

@Component
public class StudentModel {
    private final StudentRepos studentRepos;

    @Autowired
    public StudentModel(StudentRepos studentRepos) {
        this.studentRepos = studentRepos;
    }

    public List<StudentEntity> addStudentsFromCSV(long streamId, MultipartFile file) throws IOException {
        List<StudentEntity> students = new ArrayList<>();
        StringReader reader = new StringReader(new String(file.getBytes(), StandardCharsets.UTF_8));
        try(CSVReader csvReader = new CSVReader(reader)) {
            for (String[] strings : csvReader) {
                if(!strings[0].isEmpty() && !strings[1].isEmpty() && strings[2].matches("\\d+")) {
                    students.add(new StudentEntity(streamId, strings[0], strings[1]));
                }
            }
        }
        return studentRepos.saveAll(students);
    }
}
