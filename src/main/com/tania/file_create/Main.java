package com.tania.file_create;

import com.google.common.io.Files;
import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        byte[] bytes = new String("test").getBytes();
        String path = "/home/tania/edu/create/File/";
        String name = "Test.txt";
        File file = Paths.get(path, name).toFile();
//        writeWithGuvava(bytes, file);

        try {
            File parentFile = file.getCanonicalFile().getParentFile();
            if (parentFile != null) {
                System.out.println(parentFile.mkdirs());
            }
        } catch (IOException e) {
            System.out.println("mkdirs fail");
        }
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeWithGuvava(byte[] bytes, File file) {
        /**
         * with google commons creations
         * guava
         * */
        try {
            Files.createParentDirs(file);
            try (OutputStream os = new FileOutputStream(file)) {
                os.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
