// https://leetcode.com/problems/my-calendar-i

private static class MyCalendar2 {

        List<int[]> books = new ArrayList<>();
        
        public boolean book(int start, int end) {
            for (int[] b : books)
                if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
            books.add(new int[]{ start, end });
            return true;
        }
        
 }
