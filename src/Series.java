import java.util.ArrayList;
public class Series extends Media {
    private int LaunchDate;
    private int endDate;
    private ArrayList<String> season;

    public Series(String title, ArrayList genres, float rating, int startDate, int endDate, ArrayList<String> season, int ID){
        super(title, genres, rating, ID);

    }
    public String getYear(){
        return LaunchDate + " " + endDate;
    }
}
