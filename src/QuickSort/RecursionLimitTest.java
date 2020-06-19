package QuickSort;

import cs1c.MillionSongDataSubset;
import cs1c.SongEntry;

import java.util.Random;

public class RecursionLimitTest {
    public static SongEntry[] readSongsFromDataFile(String jsonFile)
    {
        // parses the JSON input file
        MillionSongDataSubset msd = new MillionSongDataSubset(jsonFile);

        // retrieves the parsed objects
        SongEntry [] allSongs = msd.getArrayOfSongs();

        // displays the number of songs read from the input file
        System.out.printf("Total number of songs read %d \n", allSongs.length);

        return allSongs;
    }
    public static < E extends Comparable< ? super E > >
    void printArray(E arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+ "\n");
        System.out.println();
    }

    public static void main(String[] args) {
        Integer [] arr = new Integer[10000000];
        for (int n=0; n<10000000; n++){
            arr[n] = new Random().nextInt(20000000);
        }
        for (int i= 0; i<10000000; i=i+500000){
            long startTime = System.nanoTime();
            FHsort.quickSort(arr, 0, i);
            long duration = System.nanoTime() - startTime;
            System.out.println("Time:" + duration + " for element " + i);
        }

        final String DATAFILE = "resources/music_genre_subset.json";
        SongEntry [] allSongs = readSongsFromDataFile(DATAFILE);
        int n = allSongs.length;

        for (int i=2; i<=300; i=i+2){
            long startTime = System.nanoTime();
            FHsort.setRecursionLimit(i);
            FHsort.quickSort(allSongs, 0, n-1);
            long duration = System.nanoTime() - startTime;
            System.out.println("Time:"+ duration + " for recursion limit " + i);
        }

    }
}
