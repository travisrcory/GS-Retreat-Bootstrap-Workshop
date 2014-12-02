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

package com.liferay.portal.workflow.kaleo.service.persistence;

/**
 * @author Brian Wing Shun Chan
 */
public interface KaleoTaskInstanceTokenFinder {
	public int countKaleoTaskInstanceTokens(
		com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskInstanceTokenQuery kaleoTaskInstanceTokenQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken> findKaleoTaskInstanceTokens(
		com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskInstanceTokenQuery kaleoTaskInstanceTokenQuery)
		throws com.liferay.portal.kernel.exception.SystemException;
}