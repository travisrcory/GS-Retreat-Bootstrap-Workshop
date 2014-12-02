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

package com.liferay.calendar.messaging;

import com.liferay.calendar.service.CalendarImporterLocalServiceUtil;
import com.liferay.calendar.util.PortletPropsValues;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.HotDeployMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.StringBundler;

import org.apache.commons.lang.time.StopWatch;

/**
 * @author Marcellus Tavares
 */
public class CalendarHotDeployMessageListener extends HotDeployMessageListener {

	public CalendarHotDeployMessageListener(String... servletContextNames) {
		super(servletContextNames);
	}


	protected void onDeploy(Message message) throws Exception {
		if (!PortletPropsValues.CALENDAR_SYNC_CALEVENTS_ON_STARTUP) {
			return;
		}

		StopWatch stopWatch = null;

		if (_log.isInfoEnabled()) {
			stopWatch = new StopWatch();

			stopWatch.start();
		}

		CalendarImporterLocalServiceUtil.importCalEvents();

		if (_log.isInfoEnabled()) {
			StringBundler sb = new StringBundler(6);

			sb.append("Calendar events synchronization takes ");
			sb.append(stopWatch.getTime());
			sb.append(" ms. Set the property ");
			sb.append("\"calendar.sync.calevents.on.startup\" ");
			sb.append("to \"false\" to disable calendar events ");
			sb.append("synchronization.");

			_log.info(sb.toString());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		CalendarHotDeployMessageListener.class);

}