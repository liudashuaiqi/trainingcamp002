package class10数组累加和问题三连;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class test {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public String f;
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        test test = (test) o;
        return a == test.a && b == test.b && c == test.c && d == test.d && e == test.e && Objects.equals(f, test.f);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e, f);
    }


}
