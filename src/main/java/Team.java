import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Team {

    String name;
    List<Player> players;
    int totalSalary = 0, numOfPlayers;

    Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
        for (Player player : players) {
            totalSalary += player.salary;
        }
        numOfPlayers = players.size();
    }

    void addPlayer(String s) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        String[] strings = s.split("@");
        if (strings.length < 7) {
            return;
        }
        String number = strings[0], name = strings[1], position = strings[2], height = strings[4], college = strings[6];
        int age = Integer.parseInt(strings[3]), weight = Integer.parseInt(strings[5].split(" ")[0]);
        long salary = 0;
        try {
            if (strings.length >= 8 && !strings[7].equals("-")) {
                salary = (long) NumberFormat.getNumberInstance(Locale.US).parse(strings[7].substring(1));
            }
            players.add(new Player(number, name, position, age, height, weight, college, salary));
            totalSalary += salary;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        String result = "";
        result += this.name + "\n";
        result += players.toString() + "\n";
        return result;
    }

    String getName() {
        return name;
    }

    List<Player> getPlayers() {
        return players;
    }

    int getTotalSalary() {
        return totalSalary;
    }

    int getNumOfPlayers() {
        return numOfPlayers;
    }
}
