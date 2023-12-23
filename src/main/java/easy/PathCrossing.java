package easy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PathCrossing {
    public static void main(String[] args) {
        System.out.println(new PathCrossing().isPathCrossing("NESWW"));
    }
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean isPathCrossing(String path) {
        Set<Point> set = new HashSet<>();
        int x = 0;
        int y = 0;

        for(int i=0; i < path.length(); i++){
            if(path.charAt(i)=='N'){
                y--;
            } else if(path.charAt(i)=='S'){
                y++;
            } if(path.charAt(i)=='W'){
                x--;
            } else if(path.charAt(i)=='E'){
                x++;
            }

            Point p = new Point(x,y);
            if(set.contains(p)) return true;
            set.add(p);
        }


        return false;
    }
}
