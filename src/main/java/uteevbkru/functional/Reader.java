package uteevbkru.functional;

import uteevbkru.struct.Artist;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Reader {
    private  static String FILE_NAME = "./src/resources/artists.txt";

    public static void main(String[] args) {
        List<List<Artist>> artists = initArtist();
        artists.stream()
                .flatMap(artist -> artist.stream())
                .forEach(System.out::println);
    }

    public static List<String> readFromFile(){
        try {
            return Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8)
                    .collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<List<Artist>> initArtist(){
        List<String> strings = new ArrayList<>();
        strings.addAll(readFromFile());

        List<List<Artist>> artists = new ArrayList<>();
        for(int i = 0; i < strings.size(); i++) {
            artists.add(workWithLine(strings.get(i)));
        }
        return artists;
    }


    public static List<Artist> workWithLine(String string){
        List<Artist> list = new ArrayList<>();
        String []artistsInString = string.split(";");
        if (artistsInString.length > 1) {
            for (int i = 0; i < artistsInString.length; i++) {
                makeArtist(list, artistsInString[i]);
            }
        } else {
            makeArtist(list,string);
        }
        return list;
    }

    public static void makeArtist(List<Artist> list, String string) {
        String []parameters = string.split(",");
        String name = parameters[0].trim();
        String age = parameters[1].trim();
        String nationality = parameters[2].trim();

        list.add(new Artist(name, age, nationality));
    }

}
