package project.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestShort {

    private int tId;

    private int hId;

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }
}
