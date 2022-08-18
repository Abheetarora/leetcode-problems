class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> countsMap = new HashMap<>();
        for (int num : arr) {
            if (!countsMap.containsKey(num)) {
                countsMap.put(num, 1);
                continue;
            }
            countsMap.put(num, countsMap.get(num) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(countsMap.values());
        Collections.sort(counts);
        Collections.reverse(counts);
        
        int numbersRemovedFromArr = 0;
        int setSize = 0;
        for (int count : counts) {
            numbersRemovedFromArr += count;
            setSize += 1;   
            if (numbersRemovedFromArr >= arr.length / 2) {
                break;
            }
        }
        
        return setSize;
    }
}