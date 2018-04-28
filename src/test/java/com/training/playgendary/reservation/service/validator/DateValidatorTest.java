package com.training.playgendary.reservation.service.validator;

import com.training.playgendary.reservation.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.TestResources;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebAppConfiguration
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
public class DateValidatorTest extends AbstractTestNGSpringContextTests {

    private static DateFormat dateFormat;

    @Autowired
    private DateValidator underTest;

    @DataProvider(name = "validDates")
    public static Object[][] validStartAndEndTime() throws ParseException {
        return new Object[][]{
                {dateFormat.parse("2018-01-18 10:00:00"), dateFormat.parse("2018-01-18 10:30:00"), true},
                {dateFormat.parse("2018-05-18 14:00:00"), dateFormat.parse("2018-05-18 17:30:00"), true},
                {dateFormat.parse("2018-04-18 10:00:01"), dateFormat.parse("2018-04-18 17:59:59"), true},
                {dateFormat.parse("2018-04-18 15:30:00"), dateFormat.parse("2018-04-18 18:00:00"), true},
                {dateFormat.parse("2018-04-23 15:30:00"), dateFormat.parse("2018-04-27 18:00:00"), true}
        };
    }

    @DataProvider(name = "invalidEndTime")
    public static Object[][] validStartTimeAndInvalidEndTime() throws ParseException {
        return new Object[][]{
                {dateFormat.parse("2018-01-18 10:00:00"), dateFormat.parse("2018-01-18 18:01:00")},
                {dateFormat.parse("2018-05-18 14:00:00"), dateFormat.parse("2018-05-19 17:30:00")},
                {dateFormat.parse("2018-04-18 10:01:59"), dateFormat.parse("2018-04-18 23:59:59")},
                {dateFormat.parse("2018-04-18 15:30:00"), dateFormat.parse("2018-04-18 15:29:59")},
                {dateFormat.parse("2018-04-27 15:30:00"), dateFormat.parse("2018-04-30 18:00:00")}
        };
    }

    @DataProvider(name = "invalidStartTime")
    public static Object[][] invalidStartTimeAndValidEndTime() throws ParseException {
        return new Object[][]{
                {dateFormat.parse("2018-01-18 09:59:59"), dateFormat.parse("2018-01-18 10:30:00")},
                {dateFormat.parse("2018-05-18 17:50:00"), dateFormat.parse("2018-05-18 17:30:00")},
                {dateFormat.parse("2018-04-14 10:00:01"), dateFormat.parse("2018-04-18 17:59:59")},
                {dateFormat.parse("2018-04-18 18:01:00"), dateFormat.parse("2018-04-18 18:00:00")},
                {dateFormat.parse("2018-04-27 17:00:00"), dateFormat.parse("2018-04-27 17:00:00")}
        };
    }

    @DataProvider(name = "invalidStartTimeInvalidEndTime")
    public static Object[][] invalidStartTimeAndInvalidEndTime() throws ParseException {
        return new Object[][]{
                {dateFormat.parse("2018-01-18 09:59:59"), dateFormat.parse("2018-01-18 18:01:00")},
                {dateFormat.parse("2018-04-22 17:50:00"), dateFormat.parse("2018-04-21 17:30:00")},
                {dateFormat.parse("2018-04-14 10:00:01"), dateFormat.parse("2018-04-15 17:59:59")},
                {dateFormat.parse("2018-04-18 09:59:59"), dateFormat.parse("2018-04-18 18:01:00")},
                {dateFormat.parse("2018-04-27 18:30:00"), dateFormat.parse("2018-04-28 17:00:00")}
        };
    }

    @BeforeSuite
    public void doSetup() {
        dateFormat = new SimpleDateFormat(TestResources.DATE_TIME_FORMAT);
    }

    private void verifyNegativeCase(Date startTime, Date endTime) {
        boolean actualResult = underTest.isValid(startTime, endTime);

        Assert.assertFalse(actualResult);
    }

    @Test(dataProvider = "validDates")
    public void shouldReturnTrueWhenStartTimeAndEndTimeValid(Date startTime, Date endTime, boolean expectedResult) {
        boolean actualResult = underTest.isValid(startTime, endTime);

        Assert.assertTrue(actualResult && expectedResult);
    }

    @Test(dataProvider = "invalidEndTime")
    public void shouldReturnFalseWhenStartTimeValidAndEndTimeInvalid(Date startTime, Date endTime) {
        verifyNegativeCase(startTime, endTime);
    }

    @Test(dataProvider = "invalidStartTime")
    public void shouldReturnFalseWhenStartTimeInvalidAndEndTimeValid(Date startTime, Date endTime) {
        verifyNegativeCase(startTime, endTime);
    }

    @Test(dataProvider = "invalidStartTimeInvalidEndTime")
    public void shouldReturnFalseWhenStartTimeInvalidAndEndTimeInvalid(Date startTime, Date endTime) {
        verifyNegativeCase(startTime, endTime);
    }
}
