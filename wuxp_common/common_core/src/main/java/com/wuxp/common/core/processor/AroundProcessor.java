package com.wuxp.common.core.processor;


/**
 * around processor
 *
 * @param <T>
 */
public interface AroundProcessor<T> extends PrevProcessor<T>, PostProcessor<T> {
}
