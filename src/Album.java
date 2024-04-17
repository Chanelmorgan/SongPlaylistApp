/***********************************************************************************************************************

 File        : Album.java

 Date        : Wednesday 17th April

 @author      : Chanel Morgan

 Description : Class that represnts a collection of songs, and has methods to interact with the album

 History     : 17/04/2024 - v1.00

 Copyright   : (c) Chanel Morgan, April 2024.

 **********************************************************************************************************************/
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    //Variables
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    // Constructor
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    // Default Constructor
    public Album(){

    }

    /**
     *Method to find a song given its title
     * @param  title of the song
     * @return Song
     *
     */
    public Song findSong(String title){
        for(Song checkedSong : songs) {
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }

    /**
     *Method to add new song to an ablum
     * @param  title of the song
     * @param duration of the song
     * @return boolean
     *
     */
    public boolean addSong(String title, double duration){
        // checking if the song can be found on the album already
        if(findSong(title) == null) {
            songs.add(new Song(title, duration));
           // System.out.println(title + " successfully added to the list");
            return true;
        } else {
            //System.out.println("Song with name " + title + " already exists in the list");
            return false;
        }
    }

    /**
     *Method to add new song to an playlist based of the track number
     * @param  trackNumber of the song
     * @param playList a linked list of the song
     * @return boolean
     *
     */
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber - 1;
        if(index > 0 && index <= this.songs.size()) {
            playList.add(this.songs.get(index));
            return true;
        }
        //System.out.println("This alum does not have a song with this track number: " + trackNumber);
        return false;
    }
    /**
     *Method to add new song to an playlist based of the title of a song
     * @param  title of the song
     * @param playList a linked list of the song
     * @return boolean
     *
     */
    public boolean addToPlayList(String title, LinkedList<Song> playList){
        for(Song checkedSong : this.songs) {
            if(checkedSong.getTitle().equals(title)){
                playList.add(checkedSong);
                return true;
            }
        }
       //System.out.println(title + " There is no such song in album");
        return false;
    }
}
