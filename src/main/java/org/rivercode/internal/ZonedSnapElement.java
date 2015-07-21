package org.rivercode.internal;

import org.rivercode.Snap;

import java.time.ZonedDateTime;

/**
 * Created by Romain Lecomte on 21/07/15.
 * romain.lecomte@valtech.fr
 */
final class ZonedSnapElement<T extends Snap> {

    public final ZonedDateTime zonedDateTime;
    public final T object;

    public ZonedSnapElement(ZonedDateTime zonedDateTime, T object) {
        this.zonedDateTime = zonedDateTime;
        this.object = object;
    }
}
