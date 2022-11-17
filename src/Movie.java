import java.util.ArrayList;

public class Movie extends Media {
    private int year;

    Movie(String title, ArrayList genres, float rating, int year, int ID){
        super(title, genres, rating, ID);
        this.year = year;
    }

    public int getYear(){
        return year;
    }
    public void play(){

    }
}
