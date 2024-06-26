/***********************************************************************************************************************

 File        : Main.java

 Date        : Wednesday 17th April

 @author      : Chanel Morgan

 Description : Main class for running and testing, but also methodds to print out the menu and play songs from the album

 History     : 17/04/2024 - v1.00

 Copyright   : (c) Chanel Morgan, April 2024.

 **********************************************************************************************************************/
import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        // Creating album
        Album album = new Album("Album1", "AC/DC");
        // Adding songs
        album.addSong("TNT", 4.5);
        album.addSong("Highway to hell", 3.5);
        album.addSong("ThunderStruck", 5.0);

        // adding the album to an arraylist
        albums.add(album);

        // Creating another album
         album = new Album("Album2", "Eminem");
        // Adding songs
        album.addSong("Rap god", 4.5);
        album.addSong("Not Afraid", 3.5);
        album.addSong("Lose yourself", 5.0);

        // Adding an album
        albums.add(album);

        // Creating a playlist
        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlayList("TNT", playList_1);
        albums.get(0).addToPlayList("Highway to hell", playList_1);
        albums.get(0).addToPlayList("Rap god", playList_1);
        albums.get(0).addToPlayList("Lose yourself", playList_1);

        play(playList_1);

    }


    /**
     *Method to play the songs in the playlist
     * @param  playList of the song
     *
     */
    private static void play(LinkedList<Song> playList){
       Scanner sc = new Scanner(System.in);
       boolean quit = false;
       boolean forward = true;
       ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0) {
            System.out.println("This playlist has no songs.");
        } else {
            System.out.println("Now playing: " + listIterator.next().toString());
            printMenu();
        }

        while(!quit) {
            int action = sc.nextInt();
            sc.nextLine();
            switch (action) {
                case 0:
                    System.out.println("playList complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing: " + listIterator.next().toString());
                    } else{
                        System.out.println("No song available. Reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasNext()){
                            listIterator.previous();
                        }
                        forward = true;
                    }
                    if(listIterator.hasPrevious()){
                    System.out.println("Now playing: " + listIterator.previous().toString());
                    } else{
                        System.out.println("We are at the first song");
                        forward = false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now playing: " + listIterator.previous().toString());
                            forward = true;
                        } else{
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()){
                            System.out.println("Now playing: " + listIterator.next().toString());
                            forward = true;
                        } else{
                            System.out.println("We have reached to the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing: " + listIterator.next().toString());
                        } else{
                            if(listIterator.hasPrevious()){
                                System.out.println("Now playing: " + listIterator.previous().toString());
                            }

                        }
                    }
                    break;
                default:
                    printMenu();
                    break;


            }

        }
    }
    /**
     * Method to print out a menu of options to the user
     */
    private static void printMenu(){
        System.out.println("Available option\n press: ");
        System.out.println("0 - to quit\n" +
                "1 - to play the next song\n" +
                "2 - to play the previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list all songs" +
                "5 - print all available options\n" +
                "6 - delete current song");
    }


    /**
     *Method to print out a list of songs
     */
    public static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("------------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("------------------------");

    }
}
