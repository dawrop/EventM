package com.example.backend.controllers;

import com.example.backend.utils.JsonResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/files")
public class FileController {
    @PostMapping("/eventPics")
    public Object addEventPic(@RequestBody MultipartFile file) {
        String uuid  = UUID.randomUUID().toString();
        File myFile = new File("frontend/src/assets/eventPhotos/" + uuid + ".png");

        return getObject(file, uuid, myFile);
    }

    @PostMapping("/avatars")
    public Object addAvatar(@RequestBody MultipartFile file) {
        String uuid  = UUID.randomUUID().toString();
        File myFile = new File("frontend/src/assets/avatars/" + uuid + ".png");

        return getObject(file, uuid, myFile);
    }

    private Object getObject(@RequestBody MultipartFile file, String uuid, File myFile) {
        try {
            FileOutputStream fw = new FileOutputStream(myFile);
            fw.write(file.getBytes());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return JsonResponse.internalServerError(e.getMessage());
        }

        return JsonResponse.ok(uuid);
    }
}
