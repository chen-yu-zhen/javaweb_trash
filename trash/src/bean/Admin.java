package bean;

/**
 * @author cyz
 * @create 2020-11-24 14:27
 */
public class Admin {
    private Integer id;
    private String name;
    private Integer age;
    private String jobId;
    private String sex;
    private Integer salary;
    private String state;

    public Admin() {
    }

    public Admin(Integer id, String name, Integer age, String jobId, String sex, Integer salary, String state) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.jobId = jobId;
        this.sex = sex;
        this.salary = salary;
        this.state = state;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", jobId=" + jobId +
                ", sex=" + sex +
                ", salary=" + salary +
                ", state=" + state +
                '}';
    }
}
