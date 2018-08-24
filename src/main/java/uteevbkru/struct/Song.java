package uteevbkru.struct;

public class Song {
    private String name;
    private Long musicTime;

    public Song(String name, Long musicTime) {
        this.name = name;
        this.musicTime = musicTime;
    }

    public Long getLength(){
        return musicTime;
    }

    public String getName() {
        return name;
    }
}
