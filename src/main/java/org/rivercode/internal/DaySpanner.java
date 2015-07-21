package org.rivercode.internal;

import org.rivercode.Snap;
import org.rivercode.Spanner;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import static org.rivercode.internal.Interval.*;

/**
 * Created by Romain Lecomte on 21/07/15.
 * romain.lecomte@valtech.fr
 */
final class DaySpanner<T extends Snap> implements DefaultSpanner<T> {

    private final ZoneId zoneId;
    private final List<ZonedSnapElement<T>> list;

    public DaySpanner(ZoneId zoneId, List<T> list) {
        this.zoneId = zoneId;
        this.list = sort(filter(toTimeZone(list, zoneId), maxInterval()));
    }

    @Override
    public Spanner<T> toTimeZone(ZoneId zoneId) {
        return new DaySpanner<>(zoneId, extract(list));
    }

    @Override
    public Spanner<T> filterFrom(Instant start) {
        return new DaySpanner<>(zoneId, extract(filter(list, startInterval(start))));
    }

    @Override
    public Spanner<T> filterTo(Instant end) {
        return new DaySpanner<>(zoneId, extract(filter(list, endInterval(end))));
    }

    @Override
    public Spanner<T> filterBeetween(Instant start, Instant end) {
        return new DaySpanner<>(zoneId, extract(filter(list, between(start, end))));
    }

    @Override
    public Spanner<T> filterDay(ZonedDateTime dateTime) {
        return null;
    }

    @Override
    public Spanner<T> filterWeek(ZonedDateTime dateTime) {
        return null;
    }

    @Override
    public Spanner<T> filterMonth(ZonedDateTime dateTime) {
        return null;
    }

    @Override
    public List<Optional<T>> asList() {
        return null;
    }

    @Override
    public List<T> asList(T defaultValue) {
        return null;
    }

}
