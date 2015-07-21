package net.theblackchamber.springmvcsecurity.annotations;

/**
 * Indicates Logger of appropriate type to
 * be supplied at runtime to the annotated field.
 *
 * The injected logger is an appropriate implementation
 * of org.slf4j.Logger.
 * Source: http://jgeeks.blogspot.com/2008/10/auto-injection-of-logger-into-spring.html
 */
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
@Documented
public @interface Logger {
}