package com.dairy.service;

import com.dairy.model.Images;
import com.dairy.repository.ImageRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadService {

    @Autowired
    ImageRepository imageRepository;


    public String addImage(String title, MultipartFile file) throws IOException {
        Images photo = new Images();
        photo.setTitle(title);
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photo = imageRepository.save(photo);
        return photo.getId();
    }

    public Images getImage(String id) {
        return imageRepository.findById(id);
    }

    public boolean removeImage(String id){
        imageRepository.deleteById(id);
        return true;
    }

}
