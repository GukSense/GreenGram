package com.green.greengramver1.common.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class CustomFileUtilsTest {
    @Autowired
    CustomFileUtils utils;

    @Test
    void makeFolders() {
        CustomFileUtils utils = new CustomFileUtils("D:\\download\\greengram_ver1\\");
        String result = utils.makeFolders("ddd4");
        System.out.println("result = " + result);
    }

    @Test
    void makeRandomFileName() {
        String result = utils.makeRandomFileName();
        System.out.println("==============");
        System.out.println("makeRandomFileName:  " + result);
    }

    @Test
    void getExt() {
        String ext = utils.getExt("abcde.ddd.jpg");
        System.out.println("ext: " + ext);
    }
    @Test
    void randomFileNameComplete() {
        String fileName = utils.makeRandomFileName("abcde.ddd.jpg");
        System.out.println("=============");
        System.out.println("fileName: " + fileName);
    }
}