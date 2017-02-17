package user;

/**
 * Created by yy on 17-Feb-17.
 */
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name ="users")
final class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    @Column(name = "email")
    private String email;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "nationality")
    private String nationality;

    @Column (name = "nationalID")
    private String nationalID;

    @Column(name = "password")
    private String password;

    @Version
    private long version;

    User(){}

    public User(String firstName, String secondName, String email, Date dateOfBirth, String address,
                String nationality, String nationalID) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.nationality = nationality;
        this.nationalID = nationalID;
    }

    public Long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (version != user.version) return false;
        if (!id.equals(user.id)) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!secondName.equals(user.secondName)) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(user.dateOfBirth) : user.dateOfBirth != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (nationality != null ? !nationality.equals(user.nationality) : user.nationality != null) return false;
        return nationalID.equals(user.nationalID);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + nationalID.hashCode();
        result = 31 * result + (int) (version ^ (version >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", nationality='" + nationality + '\'' +
                ", nationalID='" + nationalID + '\'' +
                ", version=" + version +
                '}';
    }
}
