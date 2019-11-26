package com.ufsc.ine5645.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ExpensesPerPeriodReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
	
	@Override
	public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
			throws IOException, InterruptedException {
		double total = 00;
		
		for (DoubleWritable value : values) {
			total += value.get();
		}
		
//		System.out.println("Total cost by key and period is " + key + " - " + total);

		context.write(key, new DoubleWritable(total));
	}
}