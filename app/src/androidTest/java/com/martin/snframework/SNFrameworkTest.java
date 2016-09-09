package com.martin.snframework;

import android.test.AndroidTestCase;

import com.sn.core.CryptoTools;
import com.sn.core.DES;
import com.sn.core.SNUtility;

import junit.framework.Assert;

import java.net.URLEncoder;

/**
 * Created by xuhui on 16/6/13.
 */
public class SNFrameworkTest extends AndroidTestCase {


    public void testMD5() throws Exception {
        Assert.assertEquals(SNUtility.instance().md5("1").toUpperCase(), "C4CA4238A0B923820DCC509A6F75849B");
    }

    public void testDES() throws Exception {
        // CryptoTools des = new CryptoTools("123123123");
        //Assert.assertEquals(des.encode("中华人民共和国万岁").toUpperCase(), "5ZYVAKYVT70HX94ILXRAF7DTMMM48SVX1HJLYPTL1R8=");
        Assert.assertEquals(SNUtility.instance().desEncrypt("6F60EE9161444F36D187B6BC8081FDAA_4297F44B13955235245B2497399D7A93", "jmdeskey"), "jplxLR8J8pXAL9n0kwNmizgU+7Ds19bJaO0RmuNL8Vz5CaNvAWNcSSX+Y9BPpFaK4QHHVzNwsaP6ILhUYn49u9NaY6KA91U1");
    }
}
