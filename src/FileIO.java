import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
public class FileIO {

    private File usersFile = new File("Documentation/users.txt");
    private File moviesFile = new File("Documentation/movies.txt");
    private File seriesFile = new File("Documentation/series.txt");
    private List<User> userList = Collections.emptyList();

    private static FileIO fileIO = null;

    public static FileIO getInstance() {
        if (fileIO == null)
            fileIO = new FileIO();
        return fileIO;
    }

    public String loadUsers(String username, String password) {
        File file = new File("Documentation/users.txt");
        ArrayList<String> users = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);
            input.nextLine();
            while (input.hasNextLine()) {
                users.add(input.nextLine());
            }
            for (String u : users) {
                String[] values = u.split(";");
                if (Objects.equals(values[1], username) && Objects.equals(values[2], password)) {
                    return u;
                }
            }
        } catch (FileNotFoundException e) {
            users = null;
        }
        return "";
    }
    public void writeUser(User u){ //Skriver UserCredentials ind i users.txt med "Create User Button"
        try{
            FileWriter writer = new FileWriter("Documentation/users.txt", true);
            writer.write("\n" + u.getUsername() + ";" + u.getPassword());
            writer.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public void updateUserData(User u) {
        File file = new File("Documentation/users.txt");
        ArrayList<String> rows = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                rows.add(input.nextLine());
            }

            FileWriter writer = new FileWriter(file);
            writer.write(rows.get(0) + "\n");
            for (int i = 1; i < rows.size(); i++) {
                String[] values = rows.get(i).split(";");
                if (Integer.parseInt(values[0]) == u.getID()) {
                    String watchedMovieStr = "";
                    for (int j = 0; j < u.getWatchedMovies().size(); j++) {
                        watchedMovieStr += u.getWatchedMovies().get(j) + ",";
                    }
                    if (watchedMovieStr.equalsIgnoreCase("")) {
                        watchedMovieStr = ",";
                    }
                    String savedMoviestr = ",";
                    for (int j = 0; j < u.getSavedMovies().size(); j++) {
                        savedMoviestr += u.getSavedMovies().get(j) + ",";
                    }
                    if (savedMoviestr.equalsIgnoreCase("")) {
                        savedMoviestr = ",";
                    }
                    String watchedSeriesStr = "";
                    for (int j = 0; j < u.getSavedSeries().size(); j++) {
                        watchedSeriesStr += u.getWatchedSeries().get(j) + ",";
                    }
                    if (watchedMovieStr.equalsIgnoreCase("")) {
                        watchedSeriesStr = ",";
                    }
                    String savedSeriesStr = "";
                    for (int j = 0; j < u.getSavedSeries().size(); j++) {
                        savedSeriesStr += u.getSavedSeries().get(j) + ",";
                    }
                    if (savedSeriesStr.equalsIgnoreCase("")) {
                        savedSeriesStr = ",";
                    }
                    rows.set(i, "" + u.getID() + ";" + u.getUsername() + ";" + u.getPassword() + ";" + watchedMovieStr + ";" + savedMoviestr + ";" + watchedSeriesStr + ";" + savedSeriesStr + ";");
                }
                writer.write(rows.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getRow(String rowType) {
        File file = new File("Documentation/Systeminfo.txt");
        ArrayList<String> rows = new ArrayList<>();
        int index = 0;
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                rows.add(input.nextLine());
            }
            FileWriter writer = new FileWriter(file);
            writer.write(rows.get(0) + "\n");
            for (int i = 1; i < rows.size(); i++) {
                String[] values = rows.get(i).split(";");
                if (values[0].equalsIgnoreCase(rowType)) {
                    index = Integer.parseInt(values[1]);
                    rows.set(i, "" + values[0] + ";" + (index + 1) + ";");
                }
                writer.write(rows.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            rows = null;
        }
        return index;
    }

    public boolean hasUser(String username, String password) { //Skal kigges på, genkender ikke user
        for (User user : userList) {
            if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;

    }
}
