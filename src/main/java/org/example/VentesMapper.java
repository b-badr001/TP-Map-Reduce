package org.example;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class VentesMapper extends Mapper<LongWritable, Text,Text,DoubleWritable>{

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, DoubleWritable>.Context context) throws IOException, InterruptedException {
        String[] vente = value.toString().split(" ");
        String ville = vente[1];
        double prix = Double.parseDouble(vente[3]);
        context.write(new Text(ville),new DoubleWritable(prix));
    }
}