// https://leetcode.com/problems/my-calendar-ii/description/

/*
The big idea is pretty simple:
Each time of book, instead of fail a book when there is 1 or more overlap with existing books as in MyCalendar I, 
we just want to make sure these overlaps does not overlap - having overlap is now ok, 
but overlapped period cannot be overlapped again.
So we just need to keep track of all the overlaps with any previous books

MyCalendar I can be reused to track the overlaps during each book.

How to calculate overlap of 2 intervals
Assume a start earlier than b, (if not reverse), there could be 3 case, but in any case, an overlap(either positive or negative) 
can always be represented as:
(max(a0, b0), min(a1, b1))

case 1: b ends before a ends:
a: a0 |-------------| a1
b:     b0 |-----| b1

case 2: b ends after a ends:
a: a0 |--------| a1
b:     b0 |--------| b1

case 3: b starts after a ends: (negative overlap, so it is not actually an overlap)
a: a0 |----| a1
b:              b0 |----| b1
*/

class MyCalendarTwo {
    private List<int[]> books = new ArrayList<>();    
    public boolean book(int s, int e) {
        MyCalendar overlaps = new MyCalendar();
        for (int[] b : books)
            if (Math.max(b[0], s) < Math.min(b[1], e)) // positive overlap exist
                if (!overlaps.book(Math.max(b[0], s), Math.min(b[1], e))) return false; // overlaps overlapped
        books.add(new int[]{ s, e });
        return true;
    }

    private static class MyCalendar {
        List<int[]> books = new ArrayList<>();
        public boolean book(int start, int end) {
            for (int[] b : books)
                if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
            books.add(new int[]{ start, end });
            return true;
        }
    }
}
