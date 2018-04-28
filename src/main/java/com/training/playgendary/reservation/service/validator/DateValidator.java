package com.training.playgendary.reservation.service.validator;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Contains methods for date validation
 */
@Component("dateValidator")
public class DateValidator {
    private static final int FRIDAY = 5;
    private static final int WORKDAY_START_HOUR = 10;
    private static final int WORKDAY_END_HOUR = 18;
    private static final int ZERO = 0;

    public DateValidator() {
    }

    /**
     * Wraps the @start and the @end date into DateTime objects. Checks if the @startTime and the @endTime are consistent. Invokes the additional validation method if needed.
     *
     * @param start Date of the beginning range
     * @param end   Date of the end range
     * @return Positive or negative validation result
     */
    public boolean isValid(Date start, Date end) {
        boolean isValid = false;

        DateTime startTime = new DateTime(start);
        DateTime endTime = new DateTime(end);

        if (startTime.isBefore(endTime) && !endTime.isEqual(startTime)) {
            isValid = isWorkTimePeriod(startTime, endTime);
        }

        return isValid;
    }

    /**
     * Checks if the period from the @startTime till the @endTime contains only workdays. Invokes the additional validation method if needed.
     *
     * @param startTime Date of the beginning range
     * @param endTime   Date of the end range
     * @return Positive or negative validation result
     */
    private boolean isWorkTimePeriod(DateTime startTime, DateTime endTime) {
        boolean isValid = false;

        int daysPeriod = Days.daysBetween(startTime, endTime).getDays();
        int startDayOfWeek = startTime.getDayOfWeek();

        if (startDayOfWeek + daysPeriod <= FRIDAY) {
            boolean isStartTimeValid = isWorkTimeHour(startTime);
            boolean isEndTimeValid = isWorkTimeHour(endTime);

            isValid = isStartTimeValid && isEndTimeValid;
        }

        return isValid;
    }

    /**
     * Checks if date satisfies following requirement:
     * 1) Hour of the day is in between 10 and 18 o'clock.
     *
     * @param dateTime Date that should be validated
     * @return Positive or negative validation result
     */
    private boolean isWorkTimeHour(DateTime dateTime) {
        boolean isValid = true;

        int hourOfDay = dateTime.getHourOfDay();
        int minuteOfHour = dateTime.getMinuteOfHour();

        if (hourOfDay < WORKDAY_START_HOUR || hourOfDay > WORKDAY_END_HOUR || (hourOfDay == WORKDAY_END_HOUR && minuteOfHour > ZERO)) {
            isValid = false;
        }

        return isValid;
    }
}
