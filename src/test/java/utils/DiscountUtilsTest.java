package utils;

import com.leyton.utils.DiscountUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountUtilsTest {

    @Test
    public void calculateDiscountSeniority5Test() {
        //GIVEN
        int seniority = 5;
        //WHEN
        double remise = DiscountUtils.calculateDiscount(seniority);
        //THEN
        Assert.assertEquals(10.0, remise, 0.0);
    }

    @Test
    public void calculateDiscountSmallSeniorityTest() {
        //GIVEN
        int seniority = 1;
        //WHEN
        double remise = DiscountUtils.calculateDiscount(seniority);
        //THEN
        Assert.assertEquals(0.0, remise, 0.0);
    }
}
