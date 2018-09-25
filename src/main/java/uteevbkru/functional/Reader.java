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
    private  static String FILE_NAME_ARTISTS = "./src/resources/artists.txt";

    public static void main(String[] args) {
        List<Artist> artists = initArtist();
        artists.stream()
                .flatMap(artist -> artist.getMembers().stream())
                .forEach(System.out::println);
    }

    public static List<String> readFromFile(String file){
        try {
            return Files.lines(Paths.get(file), StandardCharsets.UTF_8)
                    .collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Artist> initArtist(){
        List<String> strings = new ArrayList<>();
        strings.addAll(readFromFile(FILE_NAME_ARTISTS));

        List<Artist> artists = new ArrayList<>();
        for(int i = 0; i < strings.size(); i++) {
            artists.add(workWithLine(strings.get(i)));
        }
        return artists;
    }

    /** Если арстист состоит из нескольких, то он должен создаваться другим образом, через список!! */
    public static Artist workWithLine(String string){
        Artist artist;
        List<Artist> list = new ArrayList<>();
        String []artistsInString = string.split(";");
        if (artistsInString.length > 1) {
            for (int i = 0; i < artistsInString.length; i++) {
                list.add(makeArtist( artistsInString[i]));
            }
            artist = new Artist(list);
        } else {
            artist = makeArtist(string);
        }
        return artist;
    }

    public static Artist makeArtist(String string) {
        String []parameters = string.split(",");
        String name = parameters[0].trim();
        String age = parameters[1].trim();
        String nationality = parameters[2].trim();
        System.out.println(name+", "+age+", "+nationality);
        return new Artist(name, age, nationality);
    }

}
