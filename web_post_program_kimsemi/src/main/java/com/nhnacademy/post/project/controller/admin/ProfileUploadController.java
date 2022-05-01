package com.nhnacademy.post.project.controller.admin;

import com.nhnacademy.post.project.command.Command;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;

@MultipartConfig(
    location = "/profile/",
    maxFileSize = -1L,
    maxRequestSize = -1L,
    fileSizeThreshold = 1024
)
@Slf4j
public class ProfileUploadController implements Command {
    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    private static final String UPLOAD_DIR = "/profile/";
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            for (Part part : request.getParts()) {
                String contentDisposition = part.getHeader(CONTENT_DISPOSITION);

                if (contentDisposition.contains("filename=")) {
                    String fileName = extractFileName(contentDisposition);
                    request.setAttribute("fileName",fileName);

                    if (part.getSize() > 0) {
                        part.write("/webapp/WEB-INF/"+UPLOAD_DIR + File.separator + fileName);
                        part.delete();
                    }
                } else {
                    String formValue = request.getParameter(part.getName());
                    log.error("{}={}", part.getName(), formValue);
                }
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
        return "/addUserForm.jsp";
    }

    private String extractFileName(String contentDisposition) {
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                String fileName = token.substring(token.indexOf("=") + 1).trim().replace("\"", "");
                int index = fileName.lastIndexOf(File.separator);
                return fileName.substring(index + 1);
            }
        }

        return null;
    }
}
