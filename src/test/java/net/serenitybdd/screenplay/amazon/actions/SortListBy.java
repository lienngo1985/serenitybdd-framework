package net.serenitybdd.screenplay.amazon.actions;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SortListBy {

    //Sort List By Latest Date
    public static boolean isSortedByLatestDate (List<Date> listOfDates) {
        if (listOfDates == null || listOfDates.size() == 1) {
            return true;
        }
        Iterator<Date> iter = listOfDates.iterator();
        Date current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (current.after(previous)) {
                return false;
            }
            current = previous;
        }
        return true;
    }
}
