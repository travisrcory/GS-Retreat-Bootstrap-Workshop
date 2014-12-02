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

package com.liferay.portal.workflow.kaleo.definition;

/**
 * @author Michael C. Han
 */
public class DelayDuration {

	public DelayDuration(double duration, DurationScale durationScale) {
		_duration = duration;
		_durationScale = durationScale;
	}

	public double getDuration() {
		return _duration;
	}

	public DurationScale getDurationScale() {
		return _durationScale;
	}

	private double _duration;
	private DurationScale _durationScale;

}