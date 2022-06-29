class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int arr[][] = new int[intervals.length+1][2];
        for(int i=0;i<intervals.length;i++)
        {
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
        }
        arr[intervals.length][0] = newInterval[0];
        arr[intervals.length][1] = newInterval[1];
        return merge(arr);
        
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}