import java.time.LocalTime;

public class Train {
    private String destination;
    private int number;
    private LocalTime departTime;

    public Train(String destination, int number, LocalTime departTime) {
        this.destination = destination;
        this.number = number;
        this.departTime = departTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalTime getDepartTime() {
        return departTime;
    }

    public void setDepartTime(LocalTime departTime) {
        this.departTime = departTime;
    }
}
