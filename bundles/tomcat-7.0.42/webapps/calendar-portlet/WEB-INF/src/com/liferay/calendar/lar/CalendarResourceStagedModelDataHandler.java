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

package com.liferay.calendar.lar;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.calendar.service.CalendarResourceLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.portal.kernel.lar.ExportImportPathUtil;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.List;
import java.util.Map;

/**
 * @author Andrea Di Giorgi
 * @author Daniel Kocsis
 */
public class CalendarResourceStagedModelDataHandler
	extends BaseStagedModelDataHandler<CalendarResource> {

	public static final String[] CLASS_NAMES =
		{CalendarResource.class.getName()};


	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException, SystemException {

		CalendarResource calendarResource =
			CalendarResourceLocalServiceUtil.
				fetchCalendarResourceByUuidAndGroupId(uuid, groupId);

		if (calendarResource != null) {
			CalendarResourceLocalServiceUtil.deleteCalendarResource(
				calendarResource);
		}
	}


	public String[] getClassNames() {
		return CLASS_NAMES;
	}


	public String getDisplayName(CalendarResource calendarResource) {
		return calendarResource.getNameCurrentValue();
	}


	protected boolean countStagedModel(
		PortletDataContext portletDataContext,
		CalendarResource calendarResource) {

		if (calendarResource.getClassNameId() ==
				PortalUtil.getClassNameId(CalendarResource.class)) {

			return true;
		}

		return false;
	}


	protected void doExportStagedModel(
			PortletDataContext portletDataContext,
			CalendarResource calendarResource)
		throws Exception {

		Element calendarResourceElement =
			portletDataContext.getExportDataElement(calendarResource);

		for (Calendar calendar : calendarResource.getCalendars()) {
			StagedModelDataHandlerUtil.exportReferenceStagedModel(
				portletDataContext, calendarResource, calendar,
				PortletDataContext.REFERENCE_TYPE_STRONG);
		}

		if (calendarResource.getClassNameId() ==
				PortalUtil.getClassNameId(User.class)) {

			User user = UserLocalServiceUtil.getUser(
				calendarResource.getClassPK());

			portletDataContext.addReferenceElement(
				calendarResource, calendarResourceElement, user, User.class,
				PortletDataContext.REFERENCE_TYPE_DEPENDENCY_DISPOSABLE, true);
		}

		portletDataContext.addClassedModel(
			calendarResourceElement,
			ExportImportPathUtil.getModelPath(calendarResource),
			calendarResource);
	}


	protected void doImportStagedModel(
			PortletDataContext portletDataContext,
			CalendarResource calendarResource)
		throws Exception {

		long userId = portletDataContext.getUserId(
			calendarResource.getUserUuid());

		StagedModelDataHandlerUtil.importReferenceStagedModels(
			portletDataContext, calendarResource, Calendar.class);

		ServiceContext serviceContext = portletDataContext.createServiceContext(
			calendarResource);

		long classPK = getClassPK(portletDataContext, calendarResource, userId);

		CalendarResource importedCalendarResource = null;

		if (portletDataContext.isDataStrategyMirror()) {
			CalendarResource existingCalendarResource =
				CalendarResourceLocalServiceUtil.
					fetchCalendarResourceByUuidAndGroupId(
						calendarResource.getUuid(),
						portletDataContext.getScopeGroupId());

			if (existingCalendarResource == null) {
				existingCalendarResource =
					CalendarResourceLocalServiceUtil.fetchCalendarResource(
						calendarResource.getClassNameId(), classPK);
			}

			if (existingCalendarResource == null) {
				serviceContext.setUuid(calendarResource.getUuid());

				importedCalendarResource =
					CalendarResourceLocalServiceUtil.addCalendarResource(
						userId, portletDataContext.getScopeGroupId(),
						calendarResource.getClassNameId(), classPK,
						calendarResource.getClassUuid(),
						calendarResource.getCode(),
						calendarResource.getNameMap(),
						calendarResource.getDescriptionMap(),
						calendarResource.isActive(), serviceContext);
			}
			else {
				importedCalendarResource =
					CalendarResourceLocalServiceUtil.updateCalendarResource(
						existingCalendarResource.getCalendarResourceId(),
						calendarResource.getNameMap(),
						calendarResource.getDescriptionMap(),
						calendarResource.isActive(), serviceContext);
			}
		}
		else {
			importedCalendarResource =
				CalendarResourceLocalServiceUtil.addCalendarResource(
					userId, portletDataContext.getScopeGroupId(),
					calendarResource.getClassNameId(), classPK,
					calendarResource.getClassUuid(), calendarResource.getCode(),
					calendarResource.getNameMap(),
					calendarResource.getDescriptionMap(),
					calendarResource.isActive(), serviceContext);
		}

		updateCalendars(
			portletDataContext, calendarResource, importedCalendarResource);

		portletDataContext.importClassedModel(
			calendarResource, importedCalendarResource);
	}

	protected long getClassPK(
		PortletDataContext portletDataContext,
		CalendarResource calendarResource, long userId) {

		long classPK = 0;

		if (calendarResource.getClassNameId() ==
				PortalUtil.getClassNameId(Group.class)) {

			classPK = portletDataContext.getScopeGroupId();
		}
		else if (calendarResource.getClassNameId() ==
					PortalUtil.getClassNameId(User.class)) {

			classPK = userId;
		}

		return classPK;
	}

	protected void updateCalendars(
			PortletDataContext portletDataContext,
			CalendarResource calendarResource,
			CalendarResource importedCalendarResource)
		throws SystemException {

		Map<Long, Long> calendarIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				Calendar.class);

		List<Element> referenceElements =
			portletDataContext.getReferenceElements(
				calendarResource, Calendar.class);

		for (Element referenceElement : referenceElements) {
			long calendarId = GetterUtil.getLong(
				referenceElement.attributeValue("class-pk"));

			Calendar calendar = CalendarLocalServiceUtil.fetchCalendar(
				MapUtil.getLong(calendarIds, calendarId));

			if (calendar != null) {
				calendar.setCalendarResourceId(
					importedCalendarResource.getCalendarResourceId());

				CalendarLocalServiceUtil.updateCalendar(calendar);
			}
		}
	}

}