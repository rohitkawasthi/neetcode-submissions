class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        // System.out.println(Arrays.toString(intervals));
        // System.out.println(Arrays.deepToString(intervals));
        // System.out.println(Arrays.stream(intervals).map(interval -> Arrays.toString(interval)).collect(Collectors.joining(",","[","]")));
        int prevEnd = intervals[0][1];
        int removedIntervalCount = 0;
        // List<int[]> removedIntervals = new ArrayList<>();
        int[] prev = new int[]{intervals[0][0],intervals[0][1]};
        for(int i=1; i<intervals.length; i++) {
            if(prevEnd <= intervals[i][0]) {
                prevEnd = intervals[i][1];
                continue;
            }
            removedIntervalCount++;
            if(prevEnd > intervals[i][1]) {
                prevEnd = intervals[i][1];
                // removedIntervals.add(prev);
            } else {
                // removedIntervals.add(intervals[i]);
            }
        }
        // System.out.println("removedIntervals size :: "+removedIntervals.size());
        // System.out.println("removedIntervals :: "+removedIntervals.stream().map(interval -> Arrays.toString(interval)).collect(Collectors.joining(",","[","]")));
        return removedIntervalCount;
    }
}
