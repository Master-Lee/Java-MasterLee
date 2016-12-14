package com.lee.asynctask;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public interface TaskFuture extends Future<Object> {
	
	/**
	 * ��������Ƿ����
	 * @return
	 */
	boolean isSuccess();
	
	/**
	 * ��ȡ����ʧ��ԭ��
	 * @return
	 */
	Throwable cause();
	
	/**
	 * ���������ɣ��򷵻����������������ʧ�ܻ���δ�����ֱ�ӷ���null
	 * @return
	 */
	Object getNow();
	
	/**
	 * �ȴ�ֱ���������
	 * @return
	 * @throws InterruptedException
	 */
	TaskFuture await() throws InterruptedException;
	
	/**
	 * ���ȴ���ʱʱ�䣬�������û��ɷ���false���������򷵻�true
	 * @param timeout ���ȴ���ʱʱ��
	 * @param unit   ��ʱʱ�䵥λ
	 * @return
	 * @throws InterruptedException
	 */
	boolean await(long timeout, TimeUnit unit) throws InterruptedException;

	/**
	 * �������ʱ�ص�����
	 * @param callback
	 * @return
	 */
	TaskFuture onComplete(TaskCallback callback);
	
	/**
	 * ����ɹ�ʱ�ص�����
	 * @param callback
	 * @return
	 */
	TaskFuture onSuccess(TaskCallback callback);
	
	/**
	 * ����ʧ��ʱ�ص�����
	 * @param callback
	 * @return
	 */
	TaskFuture onFailure(TaskCallback callback);
	
	boolean hasAttr(String key);
	
	Object getAttr(String key);
	
	TaskFuture addAttr(String key, Object value);
	
	Object removeAttr(String key);
}
