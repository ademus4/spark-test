package testing.spark.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.apache.spark.sql.DataFrame;

/**
 *
 * @author adam
 */
public interface DataFrameInterface {
    void configure(String datasource);
    DataFrame getNextDataFrame();
}
