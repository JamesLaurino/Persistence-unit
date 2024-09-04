package org.fotova;


import org.fotova.config.FondationUtil;
import org.fotova.dao.JpaUtil;
import org.fotova.entity.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try
        {
            JpaUtil jpaUtil = new JpaUtil();
            Customer customer = new Customer(1,"James");
            jpaUtil.insertEntity(customer);
            System.out.println("Insertion réussie");

        } finally {
            FondationUtil.close();
        }
    }
}
