package org.rivercode;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by Romain Lecomte on 21/07/15.
 * romain.lecomte@valtech.fr
 */
public interface Spanner<T extends Snap> {
    Spanner<T> toTimeZone(ZoneId zoneId);

    Spanner<T> filterFrom(Instant start);

    Spanner<T> filterTo(Instant end);

    Spanner<T> filterBeetween(Instant start, Instant end);

    Spanner<T> filterDay(ZonedDateTime dateTime);

    Spanner<T> filterWeek(ZonedDateTime dateTime);

    Spanner<T> filterMonth(ZonedDateTime dateTime);

    List<Optional<T>> asList();

    List<T> asList(T defaultValue);
}
