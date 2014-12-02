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

package com.liferay.portal.workflow.kaleo.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.NoSuchDefinitionException;
import com.liferay.portal.workflow.kaleo.definition.Definition;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinition;
import com.liferay.portal.workflow.kaleo.service.base.KaleoDefinitionLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoDefinitionLocalServiceImpl
	extends KaleoDefinitionLocalServiceBaseImpl {


	public void activateKaleoDefinition(
			long kaleoDefinitionId, long startKaleoNodeId,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDefinition kaleoDefinition =
			kaleoDefinitionPersistence.findByPrimaryKey(kaleoDefinitionId);

		try {
			KaleoDefinition previousKaleoDefinition = getLatestKaleoDefinition(
				kaleoDefinition.getName(), serviceContext);

			previousKaleoDefinition.setModifiedDate(new Date());
			previousKaleoDefinition.setActive(false);

			kaleoDefinitionPersistence.update(previousKaleoDefinition);
		}
		catch (NoSuchDefinitionException nsde) {
		}

		kaleoDefinition.setStartKaleoNodeId(startKaleoNodeId);
		kaleoDefinition.setModifiedDate(new Date());
		kaleoDefinition.setActive(true);

		kaleoDefinitionPersistence.update(kaleoDefinition);
	}


	public void activateKaleoDefinition(
			long kaleoDefinitionId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDefinition kaleoDefinition =
			kaleoDefinitionPersistence.findByPrimaryKey(kaleoDefinitionId);

		kaleoDefinition.setModifiedDate(new Date());
		kaleoDefinition.setActive(true);

		kaleoDefinitionPersistence.update(kaleoDefinition);
	}


	public void activateKaleoDefinition(
			String name, int version, ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDefinition kaleoDefinition =
			kaleoDefinitionPersistence.findByC_N_V(
				serviceContext.getCompanyId(), name, version);

		kaleoDefinition.setModifiedDate(new Date());
		kaleoDefinition.setActive(true);

		kaleoDefinitionPersistence.update(kaleoDefinition);
	}


	public KaleoDefinition addKaleoDefinition(
			String name, String title, String description, String content,
			int version, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getGuestOrUserId());
		Date now = new Date();

		long kaleoDefinitionId = counterLocalService.increment();

		KaleoDefinition kaleoDefinition = kaleoDefinitionPersistence.create(
			kaleoDefinitionId);

		kaleoDefinition.setCompanyId(user.getCompanyId());
		kaleoDefinition.setUserId(user.getUserId());
		kaleoDefinition.setUserName(user.getFullName());
		kaleoDefinition.setCreateDate(now);
		kaleoDefinition.setModifiedDate(now);
		kaleoDefinition.setName(name);
		kaleoDefinition.setTitle(title);
		kaleoDefinition.setDescription(description);
		kaleoDefinition.setContent(content);
		kaleoDefinition.setVersion(version);
		kaleoDefinition.setActive(false);

		kaleoDefinitionPersistence.update(kaleoDefinition);

		return kaleoDefinition;
	}


	public void deactivateKaleoDefinition(
			String name, int version, ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDefinition kaleoDefinition =
			kaleoDefinitionPersistence.findByC_N_V(
				serviceContext.getCompanyId(), name, version);

		kaleoDefinition.setModifiedDate(new Date());
		kaleoDefinition.setActive(false);

		kaleoDefinitionPersistence.update(kaleoDefinition);
	}


	public void deleteCompanyKaleoDefinitions(long companyId)
		throws SystemException {

		// Kaleo definitions

		kaleoDefinitionPersistence.removeByCompanyId(companyId);

		// Kaleo condition

		kaleoConditionLocalService.deleteCompanyKaleoConditions(companyId);

		// Kaleo instances

		kaleoInstanceLocalService.deleteCompanyKaleoInstances(companyId);

		// Kaleo nodes

		kaleoNodeLocalService.deleteCompanyKaleoNodes(companyId);

		// Kaleo tasks

		kaleoTaskLocalService.deleteCompanyKaleoTasks(companyId);

		// Kaleo transitions

		kaleoTransitionLocalService.deleteCompanyKaleoTransitions(companyId);
	}


	public void deleteKaleoDefinition(
			String name, int version, ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Kaleo definition

		KaleoDefinition kaleoDefinition = getKaleoDefinition(
			name, version, serviceContext);

		if (kaleoDefinition.isActive()) {
			throw new WorkflowException(
				"Cannot delete active workflow definition " +
					kaleoDefinition.getKaleoDefinitionId());
		}

		if (kaleoDefinition.hasIncompleteKaleoInstances()) {
			throw new WorkflowException(
				"Cannot delete incomplete workflow definition " +
					kaleoDefinition.getKaleoDefinitionId());
		}

		kaleoDefinitionPersistence.remove(kaleoDefinition);

		// Kaleo condition

		kaleoConditionLocalService.deleteKaleoDefinitionKaleoCondition(
			kaleoDefinition.getKaleoDefinitionId());

		// Kaleo instances

		kaleoInstanceLocalService.deleteKaleoDefinitionKaleoInstances(
			kaleoDefinition.getKaleoDefinitionId());

		// Kaleo nodes

		kaleoNodeLocalService.deleteKaleoDefinitionKaleoNodes(
			kaleoDefinition.getKaleoDefinitionId());

		// Kaleo tasks

		kaleoTaskLocalService.deleteKaleoDefinitionKaleoTasks(
			kaleoDefinition.getKaleoDefinitionId());

		// Kaleo transitions

		kaleoTransitionLocalService.deleteKaleoDefinitionKaleoTransitions(
			kaleoDefinition.getKaleoDefinitionId());
	}


	public KaleoDefinition getKaleoDefinition(
			String name, int version, ServiceContext serviceContext)
		throws PortalException, SystemException {

		return kaleoDefinitionPersistence.findByC_N_V(
			serviceContext.getCompanyId(), name, version);
	}


	public List<KaleoDefinition> getKaleoDefinitions(
			boolean active, int start, int end,
			OrderByComparator orderByComparator, ServiceContext serviceContext)
		throws SystemException {

		return kaleoDefinitionPersistence.findByC_A(
			serviceContext.getCompanyId(), active, start, end,
			orderByComparator);
	}


	public List<KaleoDefinition> getKaleoDefinitions(
			int start, int end, OrderByComparator orderByComparator,
			ServiceContext serviceContext)
		throws SystemException {

		return kaleoDefinitionPersistence.findByCompanyId(
			serviceContext.getCompanyId(), start, end, orderByComparator);
	}


	public List<KaleoDefinition> getKaleoDefinitions(
			String name, boolean active, int start, int end,
			OrderByComparator orderByComparator, ServiceContext serviceContext)
		throws SystemException {

		return kaleoDefinitionPersistence.findByC_N_A(
			serviceContext.getCompanyId(), name, active, start, end,
			orderByComparator);
	}


	public List<KaleoDefinition> getKaleoDefinitions(
			String name, int start, int end,
			OrderByComparator orderByComparator, ServiceContext serviceContext)
		throws SystemException {

		return kaleoDefinitionPersistence.findByC_N(
			serviceContext.getCompanyId(), name, start, end, orderByComparator);
	}


	public int getKaleoDefinitionsCount(
			boolean active, ServiceContext serviceContext)
		throws SystemException {

		return kaleoDefinitionPersistence.countByC_A(
			serviceContext.getCompanyId(), active);
	}


	public int getKaleoDefinitionsCount(ServiceContext serviceContext)
		throws SystemException {

		return kaleoDefinitionPersistence.countByCompanyId(
			serviceContext.getCompanyId());
	}


	public int getKaleoDefinitionsCount(
			String name, boolean active, ServiceContext serviceContext)
		throws SystemException {

		return kaleoDefinitionPersistence.countByC_N_A(
			serviceContext.getCompanyId(), name, active);
	}


	public int getKaleoDefinitionsCount(
			String name, ServiceContext serviceContext)
		throws SystemException {

		return kaleoDefinitionPersistence.countByC_N(
			serviceContext.getCompanyId(), name);
	}


	public KaleoDefinition getLatestKaleoDefinition(
			String name, ServiceContext serviceContext)
		throws PortalException, SystemException {

		List<KaleoDefinition> kaleoDefinitions =
			kaleoDefinitionPersistence.findByC_N(
				serviceContext.getCompanyId(), name, 0, 1);

		if (kaleoDefinitions.isEmpty()) {
			throw new NoSuchDefinitionException();
		}

		return kaleoDefinitions.get(0);
	}


	public KaleoDefinition incrementKaleoDefinition(
			Definition definition, String title, ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDefinition kaleoDefinition = getLatestKaleoDefinition(
			definition.getName(), serviceContext);

		return addKaleoDefinition(
			definition.getName(), title, definition.getDescription(),
			definition.getContent(), kaleoDefinition.getVersion() + 1,
			serviceContext);
	}


	public KaleoDefinition updateTitle(
			String name, int version, String title,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDefinition kaleoDefinition =
			kaleoDefinitionPersistence.findByC_N_V(
				serviceContext.getCompanyId(), name, version);

		kaleoDefinition.setTitle(title);

		kaleoDefinitionPersistence.update(kaleoDefinition);

		return kaleoDefinition;
	}

}