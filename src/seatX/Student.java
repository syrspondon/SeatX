package seatX;

import javafx.beans.property.SimpleStringProperty;

public class Student {
    private final SimpleStringProperty id;
    private final SimpleStringProperty route;
    private final SimpleStringProperty time;
    private final SimpleStringProperty seat;

    public Student(String id, String route, String time, String seat){
        this.id = new SimpleStringProperty(id);
        this.route = new SimpleStringProperty(route);
        this.time = new SimpleStringProperty(time);
        this.seat = new SimpleStringProperty(seat);
    }

    public String getId() {
        return id.get();
    }


    public String getRoute() {
        return route.get();
    }


    public String getTime() {
        return time.get();
    }


    public String getSeat() {
        return seat.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setRoute(String route) {
        this.route.set(route);
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public void setSeat(String seat) {
        this.seat.set(seat);
    }
}
