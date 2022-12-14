package com.waybill.waybillapp.model;

import androidx.room.TypeConverter;

import java.util.Date;

/**
 * The type Converters.
 */
public class Converters {
    /**
     * From timestamp date.
     *
     * @param value the value
     * @return the date
     */
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    /**
     * Date to timestamp long.
     *
     * @param date the date
     * @return the long
     */
    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}

