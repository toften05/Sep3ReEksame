package Shared;

public class FootballCoach {
    public int Id ;
    public String fullName ;
    public String birthday ;
    public String initials ;
    public String email ;
    public String role;


    public FootballCoach(String fullName, String birthday, String initials, String email, String role) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.initials = initials;
        this.email = email;
        this.role = role;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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

    @Override
    public String toString() {
        return "FootballCoach{" +
                "Id=" + Id +
                ", fullName='" + fullName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", initials='" + initials + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
