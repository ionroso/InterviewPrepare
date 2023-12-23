package medium;

import java.util.*;

public class DesignAFoodRatingSystem {
    public static void main(String[] args) {
        FoodRatings foodRatings =
                new FoodRatings(
                        new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                        new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                        new int[]{9, 12, 8, 15, 14, 7});

        foodRatings.highestRated("korean"); // return "kimchi"
        // "kimchi" is the highest rated korean food with a rating of 9.
        foodRatings.highestRated("japanese"); // return "ramen"
        // "ramen" is the highest rated japanese food with a rating of 14.
        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
        foodRatings.highestRated("japanese"); // return "sushi"
        // "sushi" is the highest rated japanese food with a rating of 16.
        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
        foodRatings.highestRated("japanese"); // return "ramen"
        // Both "sushi" and "ramen" have a rating of 16.
        // However, "ramen" is lexicographically smaller than "sushi".
    }

    static
    class FoodRatings {
        private class Food {
            String name;

            int rating;

            Kitchen kitchen;

            public Food(String name, Kitchen kitchen, int rating) {
                this.name = name;
                this.kitchen = kitchen;
                this.rating = rating;
            }
        }

        private class Kitchen {
            private String name;

            PriorityQueue<Food> pq;
            public Kitchen(String name) {
                this.name = name;
                this.pq = new PriorityQueue<>((o1, o2) -> o2.rating-o1.rating);
            }
        }


        Map<String, Kitchen> kitchenRepo;
        Map<String, Food> foodRepo;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            kitchenRepo = new HashMap<>();
            foodRepo = new HashMap<>();

            int i=0;
            for (String cuisine : cuisines) {
                int finalI = i;
                Kitchen cuisineEntity = kitchenRepo.computeIfAbsent(cuisine, k->new Kitchen(cuisine));
                Food foodEntity = foodRepo.computeIfAbsent(foods[i], f->new Food(foods[finalI], cuisineEntity, ratings[finalI]));
                cuisineEntity.pq.offer(foodEntity);
                i++;
            }
        }

        public void changeRating(String food, int newRating) {
            if(!foodRepo.containsKey(food)){
                return;
            }
            Food f = foodRepo.get(food);
            f.rating = newRating;
            f.kitchen.pq.remove(f);
            f.kitchen.pq.offer(f);
        }

        public String highestRated(String cuisine) {
            if(!kitchenRepo.containsKey(cuisine)){
                return null;
            }

            Kitchen k = kitchenRepo.get(cuisine);
            if(k.pq.isEmpty()) {
                return null;
            }

            Food highestRatedSoFar = k.pq.peek();
            List<Food> foodsToPutBack = new ArrayList<>();
            while (!k.pq.isEmpty() && highestRatedSoFar.rating == k.pq.peek().rating){
                Food poll = k.pq.poll();
                foodsToPutBack.add(poll);
            }

            if(foodsToPutBack.isEmpty()){
                return null;
            }


            String output = null;
            for (Food food : foodsToPutBack) {
                output = output == null ? food.name : (output.compareTo(food.name) > 0 ? food.name : output);
                k.pq.offer(food);
            }
            return output;
        }
    }
}
