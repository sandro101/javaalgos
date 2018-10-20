package algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

class IntervalsMergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0){
            return intervals;
        }
		Collections.sort(intervals, (x, y) -> Integer.compare(x.start, y.start));
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		List<Interval> res = new ArrayList<>();
		res.add(new Interval(start, end));
		for (Interval interval : intervals) {
			if(end >= interval.start) {
				end = Math.max(end, interval.end);
				res.get(res.size() - 1).end = end;
			} else {
				start = interval.start;
				end = interval.end;
				res.add(new Interval(start, end));					
			}
		}
		return res;
	}

}