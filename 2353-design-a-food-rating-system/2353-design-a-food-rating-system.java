class FoodRatings {
    static class Pair {
        String food;
        int rating;
        
        public Pair(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }
    }
    
    String[] foods;
    String[] cuisines;
    int[] ratings;
    
    Map<String, TreeSet<Pair>> map = new HashMap<>();
    Map<String, Integer> foodIdx = new HashMap<>(); 

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        
        map = new HashMap<>();
        
        for (int i = 0; i < foods.length; i++) {
            foodIdx.put(foods[i], i);
        }
        
        TreeSet<Pair> set;
        
        for (int i = 0; i < cuisines.length; i++) {
            String s = cuisines[i];
            
            set = new TreeSet<>((a, b) -> {
               if (a.rating != b.rating) {
                   return Integer.compare(b.rating, a.rating);
               }

                return a.food.compareTo(b.food);
            });
            
            TreeSet<Pair> curr = map.getOrDefault(s, set);
            
            curr.add(new Pair(foods[i], ratings[i]));
            
            map.put(s, curr);
        }
    }
    
    public void changeRating(String food, int newRating) {
        int idx = foodIdx.get(food);
    
        TreeSet<Pair> set = map.get(cuisines[idx]);
        
        set.remove(new Pair(food, ratings[idx]));
        
        ratings[idx] = newRating;
        
        set.add(new Pair(food, newRating));
        
        map.put(cuisines[idx], set);
    }
    
    public String highestRated(String cuisine) {
        return map.get(cuisine).first().food;
    }
}