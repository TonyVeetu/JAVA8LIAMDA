package uteevbkru.struct;

import java.security.acl.Group;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

public class Album {
    private String name;
    private List<Artist> artists;
    private List<Song> songs;
    private String date;

    public Album(String name, List<Artist> artists, List<Song> songs, String date) {
        this.name = name;
        this.artists = artists;
        this.songs = songs;
        this.date = date;
    }

    public int getCountOfSongs() {
        return songs.size();
    }

    public Stream<Song> getSongs() {
        return songs.stream();
    }

    public static int AddUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, x) -> acc + x);
    }

    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
        return input.stream()
                .filter(album -> album.getCountOfSongs() <= 3)
                .collect(toList());
    }

    public static Song getMostLongSong(List<Album> input) {
         return input.stream()
            .flatMap(album -> album.getSongs())
            .max(Comparator.comparing(song -> song.getLength()))
            .get();
    }

    public static List<String> getNamesAndAge(List<Artist> artists) {
        return artists.stream()
                .flatMap(artist -> Stream.of(String.valueOf(artist.getAge()), artist.getName()))
                .collect(toList());
    }

    public static Long getCountOfArtist(List<Artist> artists) {
        return artists.stream()
                .map(artist -> (long) artist.getMembers().size())
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        List<Artist> artists = Stream.of(new Artist("Anton", 30),new Artist("Max", 25))
                                     .collect(toList());
        List<Song> songs1 = Stream.of(new Song("a",12L), new Song("b", 45L), new Song("c", 34L))
                                 .collect(toList());
        Album a1 = new Album("The First", artists, songs1, "2017-08-08");

        List<Song> songs2 = Stream.of(new Song("a",12L), new Song("c", 34L), new Song("fg", 342L))
                .collect(toList());
        Album a2 = new Album("The Second", artists, songs2, "2018-01-01");

        List<Song> songs3 = Stream.of(new Song("a",12L), new Song("c", 34L), new Song("g", 67L))
                .collect(toList());
        Album a3 = new Album("The Third", artists, songs3, "2000-05-05");

        List<Album> albums = Stream.of(a1, a2, a3)
                                   .collect(toList());

        List<Album> songsWithThree = getAlbumsWithAtMostThreeTracks(albums);
        System.out.println(songsWithThree.size());

        Song songLong = getMostLongSong(albums);
        System.out.println("name: "+songLong.getName()+", length: " +songLong.getLength());

        List<String> allAboutArtist = getNamesAndAge(artists);
        allAboutArtist.stream()
                .forEach(value -> System.out.println(value));

        List<Artist> artists1 = Stream.of(new Artist("A", 30),new Artist("V", 25))
                .collect(toList());
        List<Artist> artists2 = Stream.of(new Artist("R", 30),new Artist("D", 25))
                .collect(toList());

        List<Artist> list = Stream.of( ( new Artist("T", 21)), ( new Artist("L",24) ))
                                .collect(toList());
        Artist a4 = new Artist(list);
        List<Artist> artists3 = Stream.of(a4,new Artist("S", 25))
                .collect(toList());

        long a = getCountOfArtist(artists3);
        System.out.println(a);

    }

    public static void main1(String[] args) {
        List<Integer> ints = Stream.of(1,2,3,4,5)
                                   .collect(toList());
        int sym = AddUp(ints.stream());
        System.out.println(sym);

    }
}
