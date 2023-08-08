package Shared;

import java.util.Date;

public class FootballCoach {
    public int Id;
    public String fullName;
    public java.util.Date birthday;
    public String initials;
    public String email;
    public String role;
    public String teamName;


    public FootballCoach(String fullName, Date birthday, String initials, String email, String role, String teamName) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.initials = initials;
        this.email = email;
        this.role = role;
        this.teamName = teamName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "FootballCoach{" +
                "Id=" + Id +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", initials='" + initials + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
