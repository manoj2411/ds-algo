import java.util.*;

class DesignUndergroundSystem {
    public static void main(String[] args) {

    }
}


class UndergroundSystem {

    Map<String, Stat> stats;
    Map<Integer, Checkin> checkins;

    public UndergroundSystem() {
        stats = new HashMap<>();
        checkins = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkins.put(id, new Checkin(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Checkin checkin = checkins.remove(id);

        String key = getKey(checkin.station, stationName);
        Stat avg = stats.getOrDefault(key, new Stat(checkin.station, stationName));
        avg.totalTime += t - checkin.time;
        avg.count++;
        stats.put(key, avg);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = getKey(startStation, endStation);
        Stat avg = stats.get(key);

        return (double)avg.totalTime / (double)avg.count;
    }

    private String getKey(String startStation, String endStation) {
        return startStation + ":" + endStation;
    }
}

class Checkin {
    String station;
    int time;
    Checkin(String st, int t) {
        station = st;
        time = t;
    }
}

class Stat {
    String st1;
    String st2;
    long totalTime;
    int count;
    Stat(String s1, String s2) {
        st1 = s1;
        st2 = s2;
        totalTime = 0l;
        count = 0;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
