class Solution {

    /*
        1 1 6
        3 5 7

        currentInterval = [1,3]
        mergedInteval = [[1,3]]

        i=0
        currentInterval = [1,3]
        mergedInteval = [[1,3]]

        i=1
        currentInterval = [1,5]
        mergedInteval = [[1,5]]

        i=2
        currentInterval = [6,7]
        mergedInteval = [[1,5],[6,7]]
    */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> mergedIntervalsList = new ArrayList<>();
        int[] currentInterval = new int[]{intervals[0][0], intervals[0][1]};
        mergedIntervalsList.add(currentInterval);
        for(int i=0; i<intervals.length; i++) {
            if(currentInterval[1]>=intervals[i][0]) {
                if(currentInterval[1]<intervals[i][1]) {
                    currentInterval[1] = intervals[i][1];
                }
            } else {
                currentInterval = new int[]{intervals[i][0], intervals[i][1]};
                mergedIntervalsList.add(currentInterval);
            }

        }
        return mergedIntervalsList.toArray(int[][]::new);
    }
}
