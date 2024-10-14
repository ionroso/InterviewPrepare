package org.example;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsTest {
    public static void main(String[] args) {
        test1();
    }

    private static class TestEquals {
        int id;
        int dummy;

        public TestEquals(int id, int dummy) {
            this.id = id;
            this.dummy = dummy;
        }

        @Override
        public boolean equals(O  bject o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestEquals test1 = (TestEquals) o;
            return id == test1.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, dummy);
        }
    }

    private static void test1() {
        Set<TestEquals> set = new HashSet<>();

        TestEquals te10 = new TestEquals(1,0);
        TestEquals te11 = new TestEquals(1,1);
        TestEquals te20 = new TestEquals(2,0);
        set.add(te10);
        set.add(te11);
        set.add(te20);

        System.out.println(te10.equals(te11));
        System.out.println(te10.equals(te20));




    }
}
