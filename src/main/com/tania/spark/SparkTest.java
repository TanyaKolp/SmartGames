package com.tania.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Created by tanya on 29.08.17.
 */
public  class SparkTest {
    public static void main(String[] args) {
        SparkConf conf1 = new SparkConf().setAppName("com.WordCount")
                .setMaster("spark://127.0.0.1:7077")
                .set("spark.akka.heartbeat.interval", "100")
                .set("spark.local.ip", "127.0.0.1");
        JavaSparkContext spark = new JavaSparkContext(conf1);

        JavaRDD<String> textFile = spark.textFile("/home/tanya/Рабочий стол/jor.txt");
        JavaPairRDD<String, Integer> counts = textFile
                .flatMap(s -> Arrays.asList(s.split(" ")).iterator())
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a, b) -> a + b);
        counts.saveAsTextFile("/home/tanya/Рабочий стол/result.txt");
        spark.close();
    }

}
