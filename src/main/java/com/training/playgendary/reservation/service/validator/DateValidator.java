package com.training.playgendary.reservation.service.validator;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("dateValidator")
public class DateValidator {
    private static final int FRIDAY = 5;
    private static final int WORKDAY_START_HOUR = 10;
    private static final int WORKDAY_END_HOUR = 18;

    public DateValidator() {
    }

    public boolean isValid(Date start, Date end) {
        boolean isValid = false;

        DateTime startTime = new DateTime(start);
        DateTime endTime = new DateTime(end);

        if (startTime.isBefore(endTime) && !endTime.isEqual(startTime)) {
            isValid = isWorkTimePeriod(startTime, endTime);
        }

        return isValid;
    }

    private boolean isWorkTimePeriod(DateTime startTime, DateTime endTime) {
        boolean isValid = false;

        int daysPeriod = Days.daysBetween(startTime, endTime).getDays();
        int startDayOfWeek = startTime.getDayOfWeek();

        if (startDayOfWeek + daysPeriod <= FRIDAY) {
            boolean isStartTimeValid = isWorkTimeValue(startTime);
            boolean isEndTimeValid = isWorkTimeValue(endTime);

            isValid = isStartTimeValid && isEndTimeValid;
        }

        return isValid;
    }

    private boolean isWorkTimeValue(DateTime dateTime) {
        boolean isValid = true;

        int dayOfWeek = dateTime.getDayOfWeek();

        if (dayOfWeek > FRIDAY) {
            isValid = false;
        } else {
            int hourOfDay = dateTime.getHourOfDay();
            int minuteOfHour = dateTime.getMinuteOfHour();

            if (hourOfDay < WORKDAY_START_HOUR || hourOfDay > WORKDAY_END_HOUR || (hourOfDay == WORKDAY_END_HOUR && minuteOfHour > 0)) {
                isValid = false;
            }
        }

        return isValid;
    }
}
