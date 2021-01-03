package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "No file selected";
        }

        String fileName = file.getOriginalFilename();
        String filePath = "/Users/homan/temp/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return "Upload success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Upload failed";
    }
}
