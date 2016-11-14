package co.com.mobil.rest;

import javax.ws.rs.client.InvocationCallback;

/**
 *
 * Callback that can be implemented to receive the asynchronous processing
 * events from the invocation processing.
 *
 * @author janez
 * @param <T>
 */
public interface AsynCallBack<T> extends InvocationCallback<T> {

    /**
     * Called when the invocation was successfully completed. Note that this
     * does not necessarily mean the response has bean fully read, which depends
     * on the parameterized invocation callback response type.
     * <p>
     * Once this invocation callback method returns, the underlying
     * {@link javax.ws.rs.core.Response} instance will be automatically closed
     * by the runtime.
     * </p>
     *
     * @param response response data.
     */
    @Override
    public void completed(T response);

    /**
     * Called when the invocation has failed for any reason.
     * <p>
     * Note that the provided {@link Throwable} may be a
     * {@link javax.ws.rs.ProcessingException} in case the invocation processing
     * failure has been caused by a client-side runtime component error. The
     * {@code Throwable} may also be a
     * {@link javax.ws.rs.WebApplicationException} or one of its subclasses in
     * case the response status code is not
     * {@link javax.ws.rs.core.Response.Status.Family#SUCCESSFUL successful} and
     * the generic callback type is not {@link javax.ws.rs.core.Response}. In
     * case a processing of a properly received response fails, the wrapped
     * processing exception will be of {@link ResponseProcessingException} type
     * and will contain the {@link javax.ws.rs.core.Response} instance whose
     * processing has failed. A
     * {@link java.util.concurrent.CancellationException} would be indicate that
     * the invocation has been cancelled. An {@link InterruptedException} would
     * indicate that the thread executing the invocation has been interrupted.
     * </p>
     * <p>
     * Once this invocation callback method returns, the underlying
     * {@link javax.ws.rs.core.Response} instance will be automatically closed
     * by the runtime.
     * </p>
     *
     * @param throwable contains failure details.
     */
    @Override
    public void failed(Throwable throwable);

}
