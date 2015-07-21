package org.rivercode.internal;

import java.time.Instant;

/**
 * Created by Romain Lecomte on 21/07/15.
 * romain.lecomte@valtech.fr
 */
final class Interval {
    public final Instant start;
    public final Instant end;

    private Interval(Instant start, Instant end) {
        this.start = start;
        this.end = end;
    }

    public static Interval maxInterval() {
        return new Interval(Instant.MIN, Instant.MAX);
    }

    public static Interval startInterval(Instant start) {
        return new Interval(start, Instant.MAX);
    }

    public static Interval endInterval(Instant end) {
        return new Interval(Instant.MIN, end);
    }

    public static Interval between(Instant start, Instant end){
        return new Interval(start, end);
    }

    public boolean contain(ZonedSnapElement<?> span) {
        Instant instant = span.object.instant();
        if (start.equals(instant) || end.equals(instant)) return true;
        return start.isBefore(instant) && end.isAfter(instant);
    }

}
