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

package com.liferay.portal.workflow.kaleo.designer.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.kernel.workflow.WorkflowDefinitionManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.designer.DuplicateKaleoDraftDefinitionNameException;
import com.liferay.portal.workflow.kaleo.designer.KaleoDraftDefinitionContentException;
import com.liferay.portal.workflow.kaleo.designer.KaleoDraftDefinitionNameException;
import com.liferay.portal.workflow.kaleo.designer.NoSuchKaleoDraftDefinitionException;
import com.liferay.portal.workflow.kaleo.designer.model.KaleoDraftDefinition;
import com.liferay.portal.workflow.kaleo.designer.service.base.KaleoDraftDefinitionLocalServiceBaseImpl;
import com.liferay.portal.workflow.kaleo.designer.util.KaleoDesignerUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Eduardo Lundgren
 * @author Marcellus Tavares
 */
public class KaleoDraftDefinitionLocalServiceImpl
	extends KaleoDraftDefinitionLocalServiceBaseImpl {

	public KaleoDraftDefinition addKaleoDraftDefinition(
			long userId, String name, Map<Locale, String> titleMap,
			String content, int version, int draftVersion,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		validate(user.getCompanyId(), name, version, draftVersion);

		long kaleoDraftDefinitionId = counterLocalService.increment();

		KaleoDraftDefinition kaleoDraftDefinition =
			kaleoDraftDefinitionPersistence.create(kaleoDraftDefinitionId);

		kaleoDraftDefinition.setCompanyId(user.getCompanyId());
		kaleoDraftDefinition.setUserId(user.getUserId());
		kaleoDraftDefinition.setUserName(user.getFullName());
		kaleoDraftDefinition.setCreateDate(now);
		kaleoDraftDefinition.setModifiedDate(now);
		kaleoDraftDefinition.setName(name);
		kaleoDraftDefinition.setTitleMap(titleMap);
		kaleoDraftDefinition.setContent(content);
		kaleoDraftDefinition.setVersion(version);
		kaleoDraftDefinition.setDraftVersion(draftVersion);

		kaleoDraftDefinitionPersistence.update(kaleoDraftDefinition);

		return kaleoDraftDefinition;
	}

	public KaleoDraftDefinition deleteKaleoDraftDefinition(
			String name, int version, int draftVersion,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDraftDefinition kaleoDraftDefinition = getKaleoDraftDefinition(
			name, version, draftVersion, serviceContext);

		return kaleoDraftDefinitionPersistence.remove(kaleoDraftDefinition);
	}

	public void deleteKaleoDraftDefinitions(
			String name, int version, ServiceContext serviceContext)
		throws SystemException {

		List<KaleoDraftDefinition> kaleoDraftDefinitions =
			kaleoDraftDefinitionPersistence.findByC_N_V(
				serviceContext.getCompanyId(), name, version);

		for (KaleoDraftDefinition kaleoDraftDefinition :
				kaleoDraftDefinitions) {

			deleteKaleoDraftDefinition(kaleoDraftDefinition);
		}
	}

	public KaleoDraftDefinition getKaleoDraftDefinition(
			String name, int version, int draftVersion,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		return kaleoDraftDefinitionPersistence.findByC_N_V_D(
			serviceContext.getCompanyId(), name, version, draftVersion);
	}

	public List<KaleoDraftDefinition> getKaleoDraftDefinitions(
			String name, int version, int start, int end,
			OrderByComparator orderByComparator, ServiceContext serviceContext)
		throws SystemException {

		return kaleoDraftDefinitionPersistence.findByC_N_V(
			serviceContext.getCompanyId(), name, version, start, end,
			orderByComparator);
	}

	public int getKaleoDraftDefinitionsCount(
			String name, int version, ServiceContext serviceContext)
		throws SystemException {

		return kaleoDraftDefinitionPersistence.countByC_N_V(
			serviceContext.getCompanyId(), name, version);
	}

	public KaleoDraftDefinition getLatestKaleoDraftDefinition(
			String name, int version, ServiceContext serviceContext)
		throws PortalException, SystemException {

		List<KaleoDraftDefinition> kaleoDraftDefinitions =
			kaleoDraftDefinitionPersistence.findByC_N_V(
				serviceContext.getCompanyId(), name, version, 0, 1);

		if (kaleoDraftDefinitions.isEmpty()) {
			throw new NoSuchKaleoDraftDefinitionException();
		}

		return kaleoDraftDefinitions.get(0);
	}

	public List<KaleoDraftDefinition> getLatestKaleoDraftDefinitions(
			long companyId, int version, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		List<Object> kaleoDraftDefinitioIds = getKaleoDraftDefinitionIds(
			companyId, version);

		if (kaleoDraftDefinitioIds.isEmpty()) {
			return Collections.emptyList();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			KaleoDraftDefinition.class, getClassLoader());

		Property property = PropertyFactoryUtil.forName(
			"kaleoDraftDefinitionId");

		dynamicQuery.add(property.in(kaleoDraftDefinitioIds));

		return dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public int getLatestKaleoDraftDefinitionsCount(long companyId, int version)
		throws SystemException {

		List<Object> kaleoDraftDefinitioIds = getKaleoDraftDefinitionIds(
			companyId, version);

		if (kaleoDraftDefinitioIds.isEmpty()) {
			return 0;
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			KaleoDraftDefinition.class, getClassLoader());

		Property property = PropertyFactoryUtil.forName(
			"kaleoDraftDefinitionId");

		dynamicQuery.add(property.in(kaleoDraftDefinitioIds));

		return (int)dynamicQueryCount(dynamicQuery);
	}

	public KaleoDraftDefinition incrementKaleoDraftDefinitionDraftVersion(
			long userId, String name, int version,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDraftDefinition kaleoDraftDefinition =
			getLatestKaleoDraftDefinition(name, version, serviceContext);

		return addKaleoDraftDefinition(
			userId, kaleoDraftDefinition.getName(),
			kaleoDraftDefinition.getTitleMap(),
			kaleoDraftDefinition.getContent(),
			kaleoDraftDefinition.getVersion(),
			kaleoDraftDefinition.getDraftVersion() + 1, serviceContext);
	}

	public KaleoDraftDefinition publishKaleoDraftDefinition(
			long userId, String name, Map<Locale, String> titleMap,
			String content, ServiceContext serviceContext)
		throws PortalException, SystemException {

		validate(content);

		WorkflowDefinition workflowDefinition =
			KaleoDesignerUtil.deployWorkflowDefinition(
				serviceContext.getCompanyId(), serviceContext.getUserId(),
				titleMap, content);

		int version = workflowDefinition.getVersion();

		KaleoDraftDefinition kaleoDraftDefinition =
			addKaleoDraftDefinition(
				userId, name, titleMap, content, version, 1, serviceContext);

		if (version == 1) {
			deleteKaleoDraftDefinitions(name, 0, serviceContext);
		}

		return kaleoDraftDefinition;
	}

	public KaleoDraftDefinition updateKaleoDraftDefinition(
			long userId, String name, Map<Locale, String> titleMap,
			String content, int version, ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDraftDefinition kaleoDraftDefinition =
			incrementKaleoDraftDefinitionDraftVersion(
				userId, name, version, serviceContext);

		kaleoDraftDefinition.setTitleMap(titleMap);
		kaleoDraftDefinition.setContent(content);

		kaleoDraftDefinitionPersistence.update(kaleoDraftDefinition);

		return kaleoDraftDefinition;
	}

	protected List<Object> getKaleoDraftDefinitionIds(
			long companyId, int version)
		throws SystemException {

		List<Object> kaleoDraftDefinitionIds = new ArrayList<Object>();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			KaleoDraftDefinition.class, getClassLoader());

		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();

		projectionList.add(ProjectionFactoryUtil.max("kaleoDraftDefinitionId"));
		projectionList.add(ProjectionFactoryUtil.groupProperty("name"));

		dynamicQuery.setProjection(projectionList);

		dynamicQuery.add(
			PropertyFactoryUtil.forName("companyId").eq(companyId));
		dynamicQuery.add(PropertyFactoryUtil.forName("version").eq(version));

		List<Object[]> results = dynamicQuery(dynamicQuery);

		for (Object[] result : results) {
			kaleoDraftDefinitionIds.add(result[0]);
		}

		return kaleoDraftDefinitionIds;
	}

	protected void validate(
			long companyId, String name, int version, int draftVersion)
		throws PortalException, SystemException {

		if (Validator.isNull(name)) {
			throw new KaleoDraftDefinitionNameException();
		}

		if (kaleoDraftDefinitionPersistence.countByC_N_V_D(
				companyId, name, version, draftVersion) > 0) {

			throw new DuplicateKaleoDraftDefinitionNameException();
		}
	}

	protected void validate(
			long companyId, String name, String content, int version,
			int draftVersion)
		throws PortalException, SystemException {

		validate(companyId, name, version, draftVersion);
		validate(content);
	}

	protected void validate(String content) throws PortalException {
		try {
			WorkflowDefinitionManagerUtil.validateWorkflowDefinition(
				content.getBytes());
		}
		catch (WorkflowException we) {
			throw new KaleoDraftDefinitionContentException(we);
		}
	}

}