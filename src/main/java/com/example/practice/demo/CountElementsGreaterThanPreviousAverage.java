package com.example.practice.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CountElementsGreaterThanPreviousAverage {

//responseTimes = [50, 60, 40, 100, 30]
//Working through this example:
//
//First element (50): Skip this one (no previous elements)
//Second element (60): Compare with avg([50]) = 50. Since 60 > 50, count = 1
//Third element (40): Compare with avg([50, 60]) = 55. Since 40 < 55, not greater, count stays 1
//Fourth element (100): Compare with avg([50, 60, 40]) = 50. Since 100 > 50, count = 2
//Fifth element (30): Compare with avg([50, 60, 40, 100]) = 62.5. Since 30 < 62.5, not greater, count stays 2
//The final answer would be 2.

	public static void main(String[] args) {
		int arg[] = { 50, 60, 40, 100, 30 };
		List<Integer> responseTimes = new ArrayList<Integer>();
		for (int num : arg) {
			responseTimes.add(num);
		}
		int result = countResponseTimeRegressions(responseTimes);
		System.out.println("Count of elements greater than previous average: " + result);

	}

	public static int countResponseTimeRegressions(List<Integer> responseTimes) {
		int sum = responseTimes.get(0);
		int count = 0;
		for (int i = 1; i < responseTimes.size(); i++) {
			int avg = sum / i;
			if (responseTimes.get(i) > avg)
				count++;
			sum = sum + responseTimes.get(i);
		}
		return count;
	}
	
	public static int countResponseTimeRegressionsjava8(List<Integer> responseTimes) {
		long[] sum = {responseTimes.get(0)};
		return (int)IntStream.range(1, responseTimes.size()).filter(t->{
			double avg =  sum[0]/t;
			boolean isGraterthen = responseTimes.get(t)>avg;
			sum[0]+=responseTimes.get(t);
			return isGraterthen;
		}).count();
	}
}
