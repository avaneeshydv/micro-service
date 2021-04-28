package com.ava.user.controller;

import com.ava.user.entity.Users;
import com.ava.user.service.FileService;
import com.ava.user.service.UserService;
import com.ava.user.utils.FileUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class ApplicationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);

    private final UserService userService;
    private final FileService fileService;

    public ApplicationController(UserService userService, FileService fileService) {
        this.userService = userService;
        this.fileService = fileService;
    }

    @ResponseBody
    @PostMapping("/signup")
    public ResponseEntity<Users> createUser(@RequestBody Users users) {

        LOGGER.info("Signing up user {}", users.getEmail());
        return new ResponseEntity<Users>(userService.createUser(users), HttpStatus.CREATED);

    }

    @ResponseBody
    @GetMapping("/getinfo")
    public Users getUserInfo(@RequestParam("id") int id) {
        LOGGER.info("Fetching user detail for {}", id);
        Users usr = new Users();
        usr.setUserId(id);
        return userService.getUser(usr);
    }

    @ResponseBody
    @GetMapping("/getuserbymail")
    public Users getUserInfoByEmail(@RequestParam("email") String email) {
        LOGGER.info("Fetching user detail for {}", email);
        Users usr = new Users();
        usr.setEmail(email);
        return userService.getUserByEmail(usr);
    }

    @ResponseBody
    @PutMapping("/updateuser")
    public Users getUserInfo(@RequestBody Users users) {
        LOGGER.info("updating user {}", users);
        return userService.updateUser(users);
    }

    @PostMapping("/upload-pic")
    @ResponseBody
    public ResponseEntity<String> uploadProfile(@RequestParam("file") MultipartFile multipartFile) {

        if (!FileUtils.validateFile(multipartFile)) {
            return ResponseEntity.badRequest().body("File is not supported.");
        }

        boolean isUploaded = fileService.uploadFile(multipartFile);
        if (isUploaded) {
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
                    .path(multipartFile.getOriginalFilename()).toUriString());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to uploaded file");
    }

}
