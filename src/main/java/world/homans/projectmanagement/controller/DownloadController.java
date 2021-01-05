package world.homans.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class DownloadController {

    @GetMapping("/download")
    public String fileDownLoad(HttpServletResponse response, @RequestParam("path") String path) {
        File file = new File(path);
        if (!file.exists())
            return "redirect:/management?result=FileNonExist";

        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            byte[] buff = new byte[1024];
            OutputStream os  = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/management?result=DownloadFailed";
        }
        return "redirect:/management?result=DownloadSuccess";
    }
}
