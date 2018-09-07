package uteevbkru.struct;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 *  Артист может быть один, а может быть несколько!
 */
public class Artist {
    private Artist self;
    private String name;
    private int age;
    private List<Artist> artists;

    public Artist(String name, int age) {
        this.name = name;
        this.age = age;
        self = this;
        System.out.println(self.getName());
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
}
