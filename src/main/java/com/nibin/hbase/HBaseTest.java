package com.nibin.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;

/**
 * Hello world!
 *
 */
public class HBaseTest 
{
	public static void main(String[] args) throws IOException {

    // Instantiating configuration class
    Configuration con = HBaseConfiguration.create();

    // Instantiating HbaseAdmin class
    HBaseAdmin admin = new HBaseAdmin(con);

    // Instantiating table descriptor class
    HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf("emp_nibin"));

    // Adding column families to table descriptor
    tableDescriptor.addFamily(new HColumnDescriptor("personal_nibin"));
    tableDescriptor.addFamily(new HColumnDescriptor("professional_nibin"));

    // Execute the table through admin
    admin.createTable(tableDescriptor);
    System.out.println(" Table created ");
    System.out.println("listing the table now....");
    
    HTableDescriptor[] tables = admin.listTables();   
    
    for (int i=0; i<tables.length;i++ ){
      System.out.println(tables[i].getNameAsString());
   }
 }
}
