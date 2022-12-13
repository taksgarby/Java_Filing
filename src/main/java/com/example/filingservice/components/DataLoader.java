package com.example.filingservice.components;

import com.example.filingservice.models.File;
import com.example.filingservice.models.Folder;
import com.example.filingservice.models.User;
import com.example.filingservice.repositories.FileRepository;
import com.example.filingservice.repositories.FolderRepository;
import com.example.filingservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {}

    public void run(ApplicationArguments args) {

        User user1 = new User("John");
        userRepository.save(user1);

        User user2 = new User("Jarrod");
        userRepository.save(user2);

        Folder hols = new Folder("France_Holiday", user1);
        folderRepository.save(hols);

        Folder doc = new Folder("Script", user2);
        folderRepository.save(doc);

        File photo1 = new File("hols_photo_1", "jpg", 2.3, hols);
        fileRepository.save(photo1);

        File photo2 = new File("hols_photo_2", "jpg", 2.4, hols);
        fileRepository.save(photo2);

        File doc1 = new File("chapter_1", "doc", 5.3, doc);
        fileRepository.save(doc1);

        File doc2 = new File("chapter_2", "doc", 7.3, doc);
        fileRepository.save(doc2);

    }
}
