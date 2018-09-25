package uteevbkru.struct;

import java.util.ArrayList;
import java.util.List;

/**
 *  Артист может быть один, а может быть несколько!
 */
public class Artist {
    private Artist self;
    private String name;
    private String age;
    private String nationality;
    private List<Artist> artists;

    public Artist(String name, String age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        self = this;
    }

    public Artist(List<Artist> artists) {
        this.artists = artists;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<Artist> getMembers() {
        if (artists != null) {
            return artists;
        } else {
            artists = new ArrayList<>();
            artists.add(self);
            return artists;
        }
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    public static int getCountOfArtists1(List<Artist> artists){
        return artists.stream()
                .map(artist -> artist.getMembers().size())
                .reduce(0, Integer::sum)
                .intValue();
    }

    public static int getCountOfArtists2(List<Artist> artists) {
        return (int) artists.stream().flatMap(artist -> artist.getMembers().stream()).count();
    }
}
