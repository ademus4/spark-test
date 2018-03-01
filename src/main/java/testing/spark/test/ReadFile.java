/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.spark.test;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext; 

/**
 *
 * @author adam thornton
 */
public class ReadFile implements DataFrameInterface {
    
    private String datasource;
    
    public void configure(String datasource) {
        this.datasource = datasource;
    }
    
    public DataFrame getNextDataFrame() {
        SparkConf conf = new SparkConf()
                .setMaster("local[2]")
                .setAppName("spark-test");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);
        DataFrame df = sqlContext.read().json(this.datasource);   
        return df;
    }
   
    public static void main(String args[]) { 
        ReadFile rf = new ReadFile();
        rf.configure("./test.txt");
        DataFrame df = rf.getNextDataFrame();
        df.show();
    }
} 
