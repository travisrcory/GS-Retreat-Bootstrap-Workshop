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

package com.liferay.sync.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.GroupPersistence;
import com.liferay.portal.service.persistence.RepositoryPersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.sync.model.SyncDLObject;
import com.liferay.sync.service.SyncDLObjectService;
import com.liferay.sync.service.persistence.SyncDLObjectFinder;
import com.liferay.sync.service.persistence.SyncDLObjectPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the sync d l object remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.sync.service.impl.SyncDLObjectServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.sync.service.impl.SyncDLObjectServiceImpl
 * @see com.liferay.sync.service.SyncDLObjectServiceUtil
 * @generated
 */
public abstract class SyncDLObjectServiceBaseImpl extends BaseServiceImpl
	implements SyncDLObjectService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.sync.service.SyncDLObjectServiceUtil} to access the sync d l object remote service.
	 */

	/**
	 * Returns the sync d l object local service.
	 *
	 * @return the sync d l object local service
	 */
	public com.liferay.sync.service.SyncDLObjectLocalService getSyncDLObjectLocalService() {
		return syncDLObjectLocalService;
	}

	/**
	 * Sets the sync d l object local service.
	 *
	 * @param syncDLObjectLocalService the sync d l object local service
	 */
	public void setSyncDLObjectLocalService(
		com.liferay.sync.service.SyncDLObjectLocalService syncDLObjectLocalService) {
		this.syncDLObjectLocalService = syncDLObjectLocalService;
	}

	/**
	 * Returns the sync d l object remote service.
	 *
	 * @return the sync d l object remote service
	 */
	public com.liferay.sync.service.SyncDLObjectService getSyncDLObjectService() {
		return syncDLObjectService;
	}

	/**
	 * Sets the sync d l object remote service.
	 *
	 * @param syncDLObjectService the sync d l object remote service
	 */
	public void setSyncDLObjectService(
		com.liferay.sync.service.SyncDLObjectService syncDLObjectService) {
		this.syncDLObjectService = syncDLObjectService;
	}

	/**
	 * Returns the sync d l object persistence.
	 *
	 * @return the sync d l object persistence
	 */
	public SyncDLObjectPersistence getSyncDLObjectPersistence() {
		return syncDLObjectPersistence;
	}

	/**
	 * Sets the sync d l object persistence.
	 *
	 * @param syncDLObjectPersistence the sync d l object persistence
	 */
	public void setSyncDLObjectPersistence(
		SyncDLObjectPersistence syncDLObjectPersistence) {
		this.syncDLObjectPersistence = syncDLObjectPersistence;
	}

	/**
	 * Returns the sync d l object finder.
	 *
	 * @return the sync d l object finder
	 */
	public SyncDLObjectFinder getSyncDLObjectFinder() {
		return syncDLObjectFinder;
	}

	/**
	 * Sets the sync d l object finder.
	 *
	 * @param syncDLObjectFinder the sync d l object finder
	 */
	public void setSyncDLObjectFinder(SyncDLObjectFinder syncDLObjectFinder) {
		this.syncDLObjectFinder = syncDLObjectFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the group local service.
	 *
	 * @return the group local service
	 */
	public com.liferay.portal.service.GroupLocalService getGroupLocalService() {
		return groupLocalService;
	}

	/**
	 * Sets the group local service.
	 *
	 * @param groupLocalService the group local service
	 */
	public void setGroupLocalService(
		com.liferay.portal.service.GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

	/**
	 * Returns the group remote service.
	 *
	 * @return the group remote service
	 */
	public com.liferay.portal.service.GroupService getGroupService() {
		return groupService;
	}

	/**
	 * Sets the group remote service.
	 *
	 * @param groupService the group remote service
	 */
	public void setGroupService(
		com.liferay.portal.service.GroupService groupService) {
		this.groupService = groupService;
	}

	/**
	 * Returns the group persistence.
	 *
	 * @return the group persistence
	 */
	public GroupPersistence getGroupPersistence() {
		return groupPersistence;
	}

	/**
	 * Sets the group persistence.
	 *
	 * @param groupPersistence the group persistence
	 */
	public void setGroupPersistence(GroupPersistence groupPersistence) {
		this.groupPersistence = groupPersistence;
	}

	/**
	 * Returns the repository local service.
	 *
	 * @return the repository local service
	 */
	public com.liferay.portal.service.RepositoryLocalService getRepositoryLocalService() {
		return repositoryLocalService;
	}

	/**
	 * Sets the repository local service.
	 *
	 * @param repositoryLocalService the repository local service
	 */
	public void setRepositoryLocalService(
		com.liferay.portal.service.RepositoryLocalService repositoryLocalService) {
		this.repositoryLocalService = repositoryLocalService;
	}

	/**
	 * Returns the repository remote service.
	 *
	 * @return the repository remote service
	 */
	public com.liferay.portal.service.RepositoryService getRepositoryService() {
		return repositoryService;
	}

	/**
	 * Sets the repository remote service.
	 *
	 * @param repositoryService the repository remote service
	 */
	public void setRepositoryService(
		com.liferay.portal.service.RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	/**
	 * Returns the repository persistence.
	 *
	 * @return the repository persistence
	 */
	public RepositoryPersistence getRepositoryPersistence() {
		return repositoryPersistence;
	}

	/**
	 * Sets the repository persistence.
	 *
	 * @param repositoryPersistence the repository persistence
	 */
	public void setRepositoryPersistence(
		RepositoryPersistence repositoryPersistence) {
		this.repositoryPersistence = repositoryPersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the d l app local service.
	 *
	 * @return the d l app local service
	 */
	public com.liferay.portlet.documentlibrary.service.DLAppLocalService getDLAppLocalService() {
		return dlAppLocalService;
	}

	/**
	 * Sets the d l app local service.
	 *
	 * @param dlAppLocalService the d l app local service
	 */
	public void setDLAppLocalService(
		com.liferay.portlet.documentlibrary.service.DLAppLocalService dlAppLocalService) {
		this.dlAppLocalService = dlAppLocalService;
	}

	/**
	 * Returns the d l app remote service.
	 *
	 * @return the d l app remote service
	 */
	public com.liferay.portlet.documentlibrary.service.DLAppService getDLAppService() {
		return dlAppService;
	}

	/**
	 * Sets the d l app remote service.
	 *
	 * @param dlAppService the d l app remote service
	 */
	public void setDLAppService(
		com.liferay.portlet.documentlibrary.service.DLAppService dlAppService) {
		this.dlAppService = dlAppService;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */

	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */

	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}


	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return SyncDLObject.class;
	}

	protected String getModelClassName() {
		return SyncDLObject.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = syncDLObjectPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.sync.service.SyncDLObjectLocalService.class)
	protected com.liferay.sync.service.SyncDLObjectLocalService syncDLObjectLocalService;
	@BeanReference(type = com.liferay.sync.service.SyncDLObjectService.class)
	protected com.liferay.sync.service.SyncDLObjectService syncDLObjectService;
	@BeanReference(type = SyncDLObjectPersistence.class)
	protected SyncDLObjectPersistence syncDLObjectPersistence;
	@BeanReference(type = SyncDLObjectFinder.class)
	protected SyncDLObjectFinder syncDLObjectFinder;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.GroupLocalService.class)
	protected com.liferay.portal.service.GroupLocalService groupLocalService;
	@BeanReference(type = com.liferay.portal.service.GroupService.class)
	protected com.liferay.portal.service.GroupService groupService;
	@BeanReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@BeanReference(type = com.liferay.portal.service.RepositoryLocalService.class)
	protected com.liferay.portal.service.RepositoryLocalService repositoryLocalService;
	@BeanReference(type = com.liferay.portal.service.RepositoryService.class)
	protected com.liferay.portal.service.RepositoryService repositoryService;
	@BeanReference(type = RepositoryPersistence.class)
	protected RepositoryPersistence repositoryPersistence;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = com.liferay.portlet.documentlibrary.service.DLAppLocalService.class)
	protected com.liferay.portlet.documentlibrary.service.DLAppLocalService dlAppLocalService;
	@BeanReference(type = com.liferay.portlet.documentlibrary.service.DLAppService.class)
	protected com.liferay.portlet.documentlibrary.service.DLAppService dlAppService;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SyncDLObjectServiceClpInvoker _clpInvoker = new SyncDLObjectServiceClpInvoker();
}