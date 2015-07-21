package org.rivercode.internal;

import org.rivercode.Snap;
import org.rivercode.Spanner;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Romain Lecomte on 21/07/15.
 * romain.lecomte@valtech.fr
 */
interface DefaultSpanner<T extends Snap> extends Spanner<T> {

    default List<ZonedSnapElement<T>> toTimeZone(List<T> list, ZoneId zoneId) {
        return list.stream().map((e) -> new ZonedSnapElement<>(ZonedDateTime.ofInstant(e.instant(), zoneId), e)).collect(Collectors.toList());
    }

    default List<ZonedSnapElement<T>> sort(List<ZonedSnapElement<T>> list){
        return list.stream().sorted().collect(Collectors.toList());
    }

    default List<ZonedSnapElement<T>> filter(List<ZonedSnapElement<T>> list, Interval interval){
        return list.stream().filter((e) -> interval.contain(e)).collect(Collectors.toList());
    }

    default List<T> extract(List<ZonedSnapElement<T>> list){
        return list.stream().map((e) -> e.object).collect(Collectors.toList());
    }

}
