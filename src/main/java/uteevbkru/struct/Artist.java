package uteevbkru.struct;

import java.util.ArrayList;
import java.util.List;

/**
 *  Артист может быть один, а может быть несколько!
 */
public class Artist {
    private String name;
    private int age;
    private List<Artist> artists;

    public Artist(String name, int age) {
        this.name = name;
        this.age = age;
        artists = new ArrayList<>();
    }

    public Artist(List<Artist> artists) {
        this.artists = artists;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<Artist> getMembers() {
        return artists;
    }
}
