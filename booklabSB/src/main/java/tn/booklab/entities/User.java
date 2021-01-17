package tn.booklab.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column
    private String userName;

    @Column
    private String firstName;

    @Column
    private String profilimage;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String questionVerif;

    @Column
    private String answerVerif;


    public User() {
    }

    public User(int userid, String userName, String firstName, String profilimage, String lastName, String email, String password, String questionVerif, String answerVerif) {
        this.userid = userid;
        this.userName = userName;
        this.firstName = firstName;
        this.profilimage = profilimage;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.questionVerif = questionVerif;
        this.answerVerif = answerVerif;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getProfilimage() {
        return profilimage;
    }

    public void setProfilimage(String profilimage) {
        this.profilimage = profilimage;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestionVerif() {
        return questionVerif;
    }

    public void setQuestionVerif(String questionVerif) {
        this.questionVerif = questionVerif;
    }

    public String getAnswerVerif() {
        return answerVerif;
    }

    public void setAnswerVerif(String answerVerif) {
        this.answerVerif = answerVerif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userid == user.userid && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", profilimage='" + profilimage + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", questionVerif='" + questionVerif + '\'' +
                ", answerVerif='" + answerVerif + '\'' +
                '}';
    }
}
