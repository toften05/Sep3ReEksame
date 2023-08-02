    package Shared;

    import java.util.Date;

    public class FootballPlayer {
        private int id;
        private String name;

        private java.util.Date birthday;
        private String email;
        private String Role;
        private String TeamName;
        private String Position;

        public FootballPlayer(String name, Date birthday , String email, String role, String teamName, String position) {
            this.name = name;
            this.birthday = birthday;
            this.email = email;
            Role = role;
            TeamName = teamName;
            Position = position;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRole() {
            return Role;
        }

        public void setRole(String role) {
            Role = role;
        }

        public String getTeamName() {
            return TeamName;
        }

        public void setTeamName(String teamName) {
            TeamName = teamName;
        }

        public String getPosition() {
            return Position;
        }

        public void setPosition(String position) {
            Position = position;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getBirthday() {
            return birthday;
        }

        public String getEmail() {
            return email;
        }


        @Override
        public String toString() {
            return "FootballPlayer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", birthday=" + birthday +
                    ", email='" + email + '\'' +
                    ", Role='" + Role + '\'' +
                    ", TeamName='" + TeamName + '\'' +
                    ", Position='" + Position + '\'' +
                    '}';
        }
    }
