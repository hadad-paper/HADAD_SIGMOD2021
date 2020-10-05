package hadad.base.compiler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Represents the supported storage system data types.
 *
 * Used to construct elements for a given data row.
 */
public enum DataType {
    STRING(String.class.getClass()),
    INT(Integer.class);

    /* The correspondent Java class for the data type. */
    private final Class<?> klass;

    /**
     * Constructs a new data type with the specified correspondent Java class.
     *
     * @param klass
     *            the correspondent Java class for the data type.
     */
    private DataType(final Class<?> klass) {
        this.klass = klass;
    }

    /**
     * The correspondent class for this data type.
     *
     * @return the correspondent class for this data type.
     */
    public Class<?> classOf() {
        return klass;
    }

    /**
     * The value of the given object correspondent for this data type.
     *
     * @param o
     *            an object
     * @return the value of the given object correspondent for this data type.
     */
    public Object valueOf(final Object o) throws RuntimeException {
        try {
            final Method m = klass.getMethod("valueOf", o.getClass());
            return m.invoke(null, o);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            throw new RuntimeException("Cannot get the value of the given object.");
        }

    }
}
