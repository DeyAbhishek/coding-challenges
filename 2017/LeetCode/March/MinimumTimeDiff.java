/*
539. Minimum Time Difference 

Difficulty: Medium
Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

Example 1:
Input: ["23:59","00:00"]
Output: 1
Note:
The number of time points in the given list is at least 2 and won't exceed 20000.
The input time is legal and ranges from 00:00 to 23:59.
*/

public class MinimumTimeDiff {
    public int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> list=new ArrayList<>();
        for (String s: timePoints) list.add(gettime(s));
        Collections.sort(list);
        int diff=Integer.MAX_VALUE, len=list.size();
        for (int i=0;i<len;i++) {
            if (i!=len-1) diff=Math.min(diff, list.get(i+1)-list.get(i));
            else diff=Math.min(diff, list.get(0)+24*60-list.get(i));
        }
        return diff;

    }

    private int gettime(String time) {
        String[] s=time.split(":");
        return Integer.parseInt(s[0])*60+Integer.parseInt(s[1]);
    }
}
