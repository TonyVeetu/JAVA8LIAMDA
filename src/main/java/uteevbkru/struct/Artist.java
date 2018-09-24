package uteevbkru.struct;

import java.util.ArrayList;
import java.util.List;

/**
 *  Артист может быть один, а может быть несколько!
 */
public class Artist {
    private Artist self;
    private String name;
    private int age;
    private String ageString;
    private String nationality;
    private List<Artist> artists;

    public Artist(String name, String age, String nationality) {
        this.name = name;
        ageString = age;
        this.nationality = nationality;
        self = this;
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
        if (artists == null) {
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
                ", ageString='" + ageString + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
