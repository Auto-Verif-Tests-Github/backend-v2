package org.syspro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.syspro.entity.StudentEntity;
import org.syspro.model.StudentModel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    private List<StudentEntity> students(Pageable pageable) {
        return studentModel.students(pageable);
    }

    @RequestMapping(value = "/by.stream.id", method = {RequestMethod.GET, RequestMethod.POST})
    private List<StudentEntity> byStreamId(@RequestParam long streamId, Pageable pageable) {
        return studentModel.byStreamId(streamId, pageable);
    }

    @RequestMapping(value = "/by.github.nickname", method = {RequestMethod.GET, RequestMethod.POST})
    private StudentEntity byGithubNickname(@RequestParam String nickname) {
        return studentModel.byGithubNickname(nickname);
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    private Map<?, ?> delete(@PathVariable long id) {
        return studentModel.delete(id);
    }
}
