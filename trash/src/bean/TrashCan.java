package bean;

/**
 * @author cyz
 * @create 2020-11-24 14:28
 */
public class TrashCan {
    private Integer id;
    private String name;
    private String location;
    private String state;
    private Integer t1;
    private Integer t2;
    private Integer t3;
    private Integer t4;

    public TrashCan() {
    }

    public TrashCan(Integer id, String name, String location, String state, Integer t1, Integer t2, Integer t3, Integer t4) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.state = state;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getT1() {
        return t1;
    }

    public void setT1(Integer t1) {
        this.t1 = t1;
    }

    public Integer getT2() {
        return t2;
    }

    public void setT2(Integer t2) {
        this.t2 = t2;
    }

    public Integer getT3() {
        return t3;
    }

    public void setT3(Integer t3) {
        this.t3 = t3;
    }

    public Integer getT4() {
        return t4;
    }

    public void setT4(Integer t4) {
        this.t4 = t4;
    }

    @Override
    public String toString() {
        return "TrashCan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", state=" + state +
                ", t1=" + t1 +
                ", t2=" + t2 +
                ", t3=" + t3 +
                ", t4=" + t4 +
                '}';
    }
}
