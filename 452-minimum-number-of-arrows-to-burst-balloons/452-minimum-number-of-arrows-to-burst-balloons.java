class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        
        HashSet<int[]> bursted = new HashSet<>();
        
        int arrows = 0;
        
        for(int i=0; i<points.length; i++){
            if(bursted.contains(points[i]))
                continue;
            bursted.add(points[i]);
            for(int j=i+1; j<points.length; j++){
                if(points[j][1] >= points[i][1] && points[j][0] <= points[i][1])
                    bursted.add(points[j]);
                else
                    break;
            }
            arrows++;
        }
        return arrows;
    }
}