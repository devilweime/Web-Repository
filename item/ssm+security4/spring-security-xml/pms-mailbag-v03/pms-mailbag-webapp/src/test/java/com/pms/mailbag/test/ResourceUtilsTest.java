package com.pms.mailbag.test;


import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class ResourceUtilsTest {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "classpath:com\\pms\\mailbag\\messageAndCode\\template\\messageAndcode.properties";

        File file = ResourceUtils.getFile(path);

    }


}
