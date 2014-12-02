/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.sync.servlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.SerialDestination;
import com.liferay.portal.kernel.util.BasePortalLifecycle;
import com.liferay.portlet.documentlibrary.model.DLSyncEvent;
import com.liferay.portlet.documentlibrary.service.DLSyncEventLocalServiceUtil;
import com.liferay.sync.messaging.SyncMessageListener;
import com.liferay.sync.service.SyncDLObjectLocalServiceUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Brian Wing Shun Chan
 * @author Dennis Ju
 */
public class SyncServletContextListener
	extends BasePortalLifecycle implements ServletContextListener {


	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		portalDestroy();
	}


	public void contextInitialized(ServletContextEvent servletContextEvent) {
		registerPortalLifecycle();
	}


	protected void doPortalDestroy() throws Exception {
		DLSyncEventLocalServiceUtil.deleteDLSyncEvents();

		MessageBusUtil.unregisterMessageListener(
			DestinationNames.DOCUMENT_LIBRARY_SYNC_EVENT_PROCESSOR,
			_messageListener);
	}


	protected void doPortalInit() {
		_messageListener = new SyncMessageListener();

		SerialDestination serialDestination = new SerialDestination();

		serialDestination.setName(
			DestinationNames.DOCUMENT_LIBRARY_SYNC_EVENT_PROCESSOR);

		serialDestination.afterPropertiesSet();

		MessageBusUtil.addDestination(serialDestination);

		MessageBusUtil.registerMessageListener(
			DestinationNames.DOCUMENT_LIBRARY_SYNC_EVENT_PROCESSOR,
			_messageListener);

		try {
			long latestModifiedTime =
				SyncDLObjectLocalServiceUtil.getLatestModifiedTime();

			List<DLSyncEvent> dlSyncEvents = null;

			if (latestModifiedTime == 0) {
				dlSyncEvents =
					DLSyncEventLocalServiceUtil.getLatestDLSyncEvents();
			}
			else {
				dlSyncEvents = DLSyncEventLocalServiceUtil.getDLSyncEvents(
					latestModifiedTime);
			}

			for (DLSyncEvent dlSyncEvent : dlSyncEvents) {
				Message message = new Message();

				Map<String, Object> values = new HashMap<String, Object>(4);

				values.put("event", dlSyncEvent.getEvent());
				values.put("modifiedTime", dlSyncEvent.getModifiedTime());
				values.put("type", dlSyncEvent.getType());
				values.put("typePK", dlSyncEvent.getTypePK());

				message.setValues(values);

				MessageBusUtil.sendMessage(
					DestinationNames.DOCUMENT_LIBRARY_SYNC_EVENT_PROCESSOR,
					message);
			}

			DLSyncEventLocalServiceUtil.deleteDLSyncEvents();
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		SyncServletContextListener.class);

	private MessageListener _messageListener;

}