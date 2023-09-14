package com.epam.mjc.io;

import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try(BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String str;

            while ((str = br.readLine()) != null) {
                String[] lineArr = str.split(": ");

                String key = lineArr[0];
                String value = lineArr[1];

                switch (key) {
                    case "Name":
                        profile.setName(value);
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(value));
                        break;
                    case "Email":
                        profile.setEmail(value);
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(value));
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return profile;
    }
}
