package com.sparkex

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

class WordCount(sc: SparkContext) {

  def run(fileName: String, outputName: String): Unit = {

    val textFile = sc.textFile(fileName, 4)

    val counts = textFile.flatMap(line =>
      line.split(" "))
        .map(word => (word, 1))
        .reduceByKey((v1,v2) => v1 + v2)

    counts.saveAsTextFile(outputName)
  }

}

object WordCount {
  def main(args: Array[String]) {
    if (args.size != 2) {
      println("usage: <input-file> <output-file>")
      println(s"called as: WordCount.main(${args.mkString(" ")})")
      sys.exit(1)
    }
    val inputFilename = args(0)
    val outputFilename = args(1)
    val spark = SparkSession
      .builder
      .appName("WordCount")
      .getOrCreate()
    val wc = new WordCount(spark.sparkContext)
    wc.run(inputFilename, outputFilename)
  }
}

