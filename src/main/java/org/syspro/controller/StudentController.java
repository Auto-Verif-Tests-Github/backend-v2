package org.syspro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.syspro.entity.StudentEntity;
import org.syspro.model.StudentModel;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.util.List;

@MultipartConfig(maxFileSize = 3_000_000L)
@RestController()
@RequestMapping(value = "${api.start}/students")
public class StudentController {
    private final StudentModel studentModel;

    @Autowired
    public StudentController(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    @PostMapping("/{streamId}")
    private List<StudentEntity> addStudentsFromCSV(@PathVariable long streamId,
                                                   @RequestParam("file") MultipartFile file) throws IOException {
        return studentModel.addStudentsFromCSV(streamId, file);
    }
}
