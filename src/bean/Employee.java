package bean;

/**
 * @author quiet
 * @create 2021-01-13  20:03
 */

public class Employee {

    private Integer id;
    private String lastName;
    private String gender;
    private String email;
    private Integer did;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", did=" + did +
                '}';
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee() {
    }

    public Employee(Integer id, String lastName, String gender, String email, Integer did) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.did = did;
    }
}
