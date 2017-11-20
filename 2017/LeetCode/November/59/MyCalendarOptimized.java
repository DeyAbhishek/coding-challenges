/* https://leetcode.com/problems/my-calendar-i/description/
729. My Calendar I

Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.

Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)

For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.

Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
Example 1:
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true
Explanation: 
The first event can be booked.  The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, but not including 20.
Note:

The number of calls to MyCalendar.book per test case will be at most 1000.
In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
*/

/*
Intuition

If we maintained our events in sorted order, we could check whether an event could be booked in 
O(logN) time (where N is the number of events already booked) by 
binary searching for where the event should be placed. We would also have to insert the 
event in our sorted structure.

Algorithm

We need a data structure that keeps elements sorted and supports fast insertion. 
In Java, a TreeMap is the perfect candidate. In Python, we can build our own binary tree structure.

For Java, we will have a TreeMap where the keys are the start of each interval, 
and the values are the ends of those intervals. When inserting the interval [start, end), we check if there is a conflict on each side with neighboring intervals: we would like calendar.get(prev)) <= start <= end <= next for the booking to be valid (or for prev or next to be null respectively.)

*/
class MyCalendarOptimized {
    TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}

/*
Complexity Analysis

Time Complexity (Java): O(NlogN), where N is the number of events booked. For each new event, 
we search that the event is legal in O(logN) time, then insert it in O(1) time.

Space Complexity: O(N), the size of the data structures used.
*/
