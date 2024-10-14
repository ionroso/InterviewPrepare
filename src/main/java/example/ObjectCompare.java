package org.example;

import java.util.Comparator;

public class ObjectCompare {

    public static class Person {
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person that = (Person) o;
            return firstName.equals(that.firstName) &&
                    lastName.equals(that.lastName);
        }
    }


    public static class Person1 implements Comparable<Person1> {
        private String firstName;
        private String lastName;

        public Person1(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName(){
            return firstName;
        }

        public String getLastName(){
            return lastName;
        }

//        @Override
//        public int compareTo(Person o) {
//            return this.lastName.compareTo(o.lastName);
//        }

        @Override
        public int compareTo(Person1 o) {
            return Comparator.comparing(Person1::getLastName)
                    .thenComparing(Person1::getFirstName)
                    .compare(this, o);
        }

    }
    public boolean isGreater(int num1, int num2){
        return num1 > num2;
    }
}
