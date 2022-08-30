package project.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolderShort {

    private int hId;

    private String name;

    private String password;

    private boolean role;

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "HolderShort{" +
                "hId=" + hId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
