package com.dairy.api;

import com.dairy.model.Images;
import com.dairy.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
public class ImageController {


    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam("title") String title,
                           @RequestParam("image") MultipartFile image)
        throws IOException {
        String id = fileUploadService.addImage(title, image);
        return "redirect:/photos/" + id;
    }

    @GetMapping("/photos/{id}")
    public Model getPhoto(@PathVariable String id, Model model) {
        Images photo = fileUploadService.getImage(id);
        model.addAttribute("title", photo.getTitle());
        model.addAttribute("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
        return model;
    }

    @DeleteMapping("/photo/{id}")
    public boolean deletePhoto(@PathVariable String id){
        fileUploadService.removeImage(id);
        return true;
    }
}
