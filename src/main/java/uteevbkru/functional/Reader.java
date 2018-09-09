package uteevbkru.functional;

import uteevbkru.struct.Artist;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Reader {
    private  static String FILE_NAME = "./src/resources/artists.txt";

    public static void main(String[] args) {
        List<Artist> artists = initArtist();
        artists.stream()
                .map(artist -> artist.toString())
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

    public static List<Artist> initArtist(){
        List<String> strings = new ArrayList<>();
        strings.addAll(readFromFile());

        List<Artist> artists = new ArrayList<>();
        for(int i = 0; i < strings.size(); i++) {
            artists.add(makeArtist(strings.get(i)));
        }
        return artists;
    }


    public static Artist makeArtist(String string){
        String []parameters = string.split(",");
        String name = parameters[0].trim();
        String age = parameters[1].trim();
        String nationality = parameters[2].trim();

        return new Artist(name, age, nationality);
    }

}
