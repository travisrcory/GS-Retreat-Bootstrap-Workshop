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

package com.liferay.portal.workflow.kaleo.designer;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo Lundgren
 */
public class KaleoDraftDefinitionNameException extends PortalException {

	public KaleoDraftDefinitionNameException() {
		super();
	}

	public KaleoDraftDefinitionNameException(String msg) {
		super(msg);
	}

	public KaleoDraftDefinitionNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public KaleoDraftDefinitionNameException(Throwable cause) {
		super(cause);
	}

}