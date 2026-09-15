/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparing(interval -> interval.start));
        int end = 0;
        for(Interval interval : intervals) {
            if(interval.start < end) {
                return false;
            }
            end = interval.end;
        }
        return true;
    }
}
