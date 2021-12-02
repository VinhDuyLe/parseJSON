package com.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

public class ParseJson {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            File file = new File("src/com/json/file.json");
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;
            String name = (String) jsonObject.get("Name");
            String course = (String) jsonObject.get("Course");
            JSONArray subjects = (JSONArray) jsonObject.get("Subject");
            System.out.println("Name: " + name);
            System.out.println("Course: " + course);
            System.out.println("Subjects:");
            Iterator iterator = subjects.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
