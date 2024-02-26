package matdori.matdori_basic.domain.player;

public class Player {
    private Long id;
    private Integer backNumber;
    private Integer salary;
    private String name;
    private String position;

    public Player(Integer backNumber, Integer salary, String name, String position) {
        this.backNumber = backNumber;
        this.salary = salary;
        this.name = name;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBackNumber() {
        return backNumber;
    }

    public void setBackNumber(Integer backNumber) {
        this.backNumber = backNumber;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
