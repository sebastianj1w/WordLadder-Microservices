package sebastianj1w.wordladder.controller;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sebastianj1w.wordladder.entity.WordLadder;

@RestController
@RequestMapping("/word_ladder")
public class WordLadderController {

    private Set<String> dict = loadDict("static/dictionary.txt");

    @RequestMapping("/get")
    public WordLadder wordladder(@RequestParam(value="start", defaultValue="word") String start, @RequestParam(value="end", defaultValue="lade") String end) {
        return new WordLadder(start, end, dict);
    }

    @RequestMapping("/error")
    public String wl_error() {
        return "error";
    }


    public static Set<String> loadDict(String path) {
        Set<String> wordSet = new TreeSet<>();
        try {
//            System.out.println("loading");
            org.springframework.core.io.Resource resource = new ClassPathResource(path);
            InputStream in = resource.getInputStream();
//            File dictFile = resource.getFile();

//            if (!in.available()) {
//                System.out.println("dict not exits");
//                return new TreeSet<>();
//            }

//            System.out.println("dict exits");


            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String tempString;
//        int line = 1;

            while ((tempString = reader.readLine()) != null) {
                wordSet.add(tempString);
//            line++;
            }

            reader.close();
        } catch (java.io.IOException E) {
            System.out.println("ERROR");
        }
        return wordSet;
    }
}