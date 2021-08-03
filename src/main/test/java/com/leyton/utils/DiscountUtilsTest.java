package com.leyton.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DisplayName(value = "discount utils test")
public class DiscountUtilsTest {

    //------------- OK TEST -------------

    @Test
    public void calculate_discount_seniority_5_OK_Test() {
        //GIVEN
        int seniority = 5;
        //WHEN
        double remise = DiscountUtils.calculateDiscount(seniority);
        //THEN
        assertEquals(10.0, remise, 0.0);
    }

    @Test
    public void calculate_discount_small_seniority_OK_test() {
        //GIVEN
        int seniority = 1;
        //WHEN
        double remise = DiscountUtils.calculateDiscount(seniority);
        //THEN
        assertEquals(0.0, remise, 0.0);
    }

    @Test
    public void calculate_discount_big_seniority_OK_test() {
        //GIVEN
        int seniority = 20;
        //WHEN
        double remise = DiscountUtils.calculateDiscount(seniority);
        //THEN
        assertEquals(10.0,remise,0.0);
    }

    @Test
    public void calculate_discount_seniority_between_3_and_5_OK_test() {
        //GIVEN
        int seniority = 3;
        //WHEN
        double remise = DiscountUtils.calculateDiscount(seniority);
        //THEN
        assertEquals(5.0,remise,0.0);
    }

    //------------ KO TEST -------------

    @Test
    public void calculate_discount_seniority_5_KO_Test() {
        //GIVEN
        int seniority = 5;
        //WHEN
        double remise = DiscountUtils.calculateDiscount(seniority);
        //THEN
        assertNotEquals(5.0, remise);
    }

    @Test
    public void calculate_discount_small_seniority_KO_test() {
        //GIVEN
        int seniority = 1;
        //WHEN
        double remise = DiscountUtils.calculateDiscount(seniority);
        //THEN
        assertNotEquals(10.00, remise, 0.0);
    }
}
