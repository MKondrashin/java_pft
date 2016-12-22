package ru.stqa.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by User on 22.12.2016.
 */
public class GeoIpServiceTests {
    @Test
    public void testMyIp()
    {
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("91.201.250.5");
        assertEquals(geoIP.getCountryCode(),"RUS");
    }


    @Test
    public void testInvalidIp()
    {
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("91.271.250.5");
        assertEquals(geoIP.getCountryCode(),"RUS");
    }


}
