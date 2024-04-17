/***********************************************************************************************************************

 File        : Song.java

 Date        : Wednesday 17th April

 @author      : Chanel Morgan

 Description : Class that represnts a song that can be added to an album

 History     : 17/04/2024 - v1.00

 Copyright   : (c) Chanel Morgan, April 2024.

 **********************************************************************************************************************/
public class Song {

    // Variables
    String title;
    double duration;

    // Constructor
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    // Default constructor
    public Song() {
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }


    /**
     * method to print the song object out
     * @return string
     */
    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
