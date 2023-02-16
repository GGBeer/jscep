package org.jscep.transport;

import java.net.MalformedURLException;
import java.net.URL;

import org.jscep.transport.request.Operation;

/**
 * This class represents an abstract transport method for sending a message to a
 * SCEP server.
 */
public abstract class AbstractTransport implements Transport {
    private final URL url;

    /**
     * Creates a new {@code AbstractTransport} for the given URL.
     * 
     * @param url
     *            the {@code URL} used for sending requests.
     */
    public AbstractTransport(final URL url) {
        this.url = url;
    }

    /**
     * Returns the {@code URL} for the given operation.
     * 
     * @param op
     *            the operation.
     * @return the {@code URL} for the given operation.
     * @throws TransportException
     *             if the generated {@code URL} is malformed.
     */
    public final URL getUrl(final Operation op) throws TransportException {
        try {
            return new URL(url.toExternalForm() + "?operation=" + op.getName());
        } catch (MalformedURLException e) {
            throw new TransportException(e);
        }
    }

    /**
     * Converts the given object varargs to an object array.
     * 
     * @param objects
     *            the objects to convert.
     * @return the object array.
     */
    protected final Object[] varargs(final Object... objects) {
        return objects;
    }
}
