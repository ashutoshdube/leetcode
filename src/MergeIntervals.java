import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Created by Ashutosh on 1/2/17.
 */
public class MergeIntervals {

    public static class Interval {
             int start;
             int end;
             Interval() { start = 0; end = 0; }
             Interval(int s, int e) { start = s; end = e; }
    }

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {

            return new Integer(o1.start).compareTo(new Integer(o2.start));
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        if(intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, new IntervalComparator());

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> output = new ArrayList<>();


        for(Interval interval : intervals) {

            if(interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                output.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }

        }

        output.add(new Interval(start ,end));
        return output;
        /*Stack<Interval> stack = new Stack<>();
        for(int i = 0; i < intervals.size(); i++) {
            if(stack.size() == 0) {
                stack.push(intervals.get(0));
            } else {
                Interval temp = stack.pop();
                if((intervals.get(i).start >= temp.start && intervals.get(i).start <= temp.end) ||
                    (intervals.get(i).end >= temp.start && intervals.get(i).end <= temp.end)) {
                    Interval newInterval = new Interval();
                    newInterval.start = Math.min(temp.start, intervals.get(i).start);
                    newInterval.end = Math.max(temp.end, intervals.get(i).end);
                    stack.push(newInterval);
                } else {
                    stack.push(temp);
                    stack.push(intervals.get(i));
                }
            }

        }

        List<Interval> output = new ArrayList<>();
        while (stack.size() != 0) {
            output.add(stack.pop());
        }

        return output;*/
    }

    public static void main(String[] args) {

        MergeIntervals obj = new MergeIntervals();

        Interval i1 = new Interval(1,4);
        Interval i2 = new Interval(1,5);

        List<Interval> test = new ArrayList<>();
        test.add(i1);
        test.add(i2);

        List<Interval> output = obj.merge(test);
        for(Interval i : output) {
            System.out.println("start : " + i.start + " end : " + i.end);
        }

    }

}
