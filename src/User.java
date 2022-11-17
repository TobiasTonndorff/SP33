
import java.util.ArrayList;

public class User {
    private int ID;
    private String username;
    private String password;
    private ArrayList<Integer> watchedMovies = new ArrayList<>();
    private ArrayList<Integer> savedMovies = new ArrayList<>();

    private ArrayList<Integer> watchedSeries = new ArrayList<>();
    private ArrayList<Integer> savedSeries = new ArrayList<>();










    public User(String username, String password, int ID, ArrayList watchedMovies, ArrayList savedMovies, ArrayList watchedSeries, ArrayList savedSeries){
        this.username = username;
        this.password = password;
        this.ID = ID;
        this.watchedMovies = watchedMovies;
        this.savedMovies = savedMovies;
        this.watchedSeries = watchedSeries;
        this.savedSeries = savedSeries;
    }
    public void setWatchedMovies(Integer watchedMov) {
        watchedMovies.add(watchedMov);
    }
    public void setSavedMovies(Integer savedMov){
        savedMovies.add(savedMov);
    }
    public ArrayList<Integer> getWatchedMovies(){
        return watchedMovies;
    }
    public ArrayList<Integer> getSavedMovies(){
        return savedMovies;
    }
    public void removeSavedMovie(int ID){
        System.out.println(ID);
        System.out.println(savedMovies);
        savedMovies.remove(Integer.valueOf(ID));
        System.out.println(savedMovies);
    }
    public void setWatchedSeries(Integer watchedSer) {
        watchedSeries.add(watchedSer);
    }
    public void setSavedSeries(Integer savedSer) {
        savedSeries.add(savedSer);
    }


    public ArrayList<Integer> getWatchedSeries() {
        return watchedSeries;
    }
    public ArrayList<Integer> getSavedSeries(){
        return savedSeries;
    }
    public void removeSaveSeries(int ID){
        System.out.println(ID);
        System.out.println(savedSeries);
        savedSeries.remove(Integer.valueOf(ID));
        System.out.println(savedSeries);
    }
    public String getUsername(){
        return username;

    }
    public String getPassword(){
        return password;
    }
    public int getID(){
        return ID;
    }
}
