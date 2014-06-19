/*
 * Copyright 2014 Janith Bandara
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.audit4j.core.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


/**
 * The Class AuditAnnotationAttributes.
 * 
 * @author Janith Bandara
 */
public class AsyncAuditAnnotationAttributes {

	private final static String ACTION = "action";

	/**
	 * Checks for annotation.
	 * 
	 * @param clazz
	 *            the clazz
	 * @return the boolean
	 */
	public Boolean hasAnnotation(final Class clazz) {
		final Annotation[] annotations = clazz.getAnnotations();
		for (final Annotation annotation : annotations) {
			if (annotation instanceof AsyncAudit) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks for annotation.
	 * 
	 * @param method
	 *            the method
	 * @return the boolean
	 */
	public Boolean hasAnnotation(final Method method) {
		final Annotation[] annotations = method.getAnnotations();
		for (final Annotation annotation : annotations) {
			if (annotation instanceof AsyncAudit) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the selection.
	 * 
	 * @param clazz
	 *            the clazz
	 * @return the selection
	 */
	public SelectionType getSelection(final Class clazz) {
		final Annotation[] annotations = clazz.getAnnotations();
		return getSelection(annotations);
	}

	/**
	 * Gets the selection.
	 * 
	 * @param method
	 *            the method
	 * @return the selection
	 */
	public SelectionType getSelection(final Method method) {
		final Annotation[] annotations = method.getAnnotations();
		return getSelection(annotations);
	}

	/**
	 * Gets the selection.
	 * 
	 * @param annotations
	 *            the annotations
	 * @return the selection
	 */
	private SelectionType getSelection(final Annotation[] annotations) {
		for (final Annotation annotation : annotations) {
			if (annotation instanceof AsyncAudit) {
				final AsyncAudit audit = (AsyncAudit) annotation;
				return audit.selection();
			}
		}
		return null;
	}

	/**
	 * Gets the action.
	 * 
	 * @param clazz
	 *            the clazz
	 * @return the action
	 */
	public String getAction(final Class clazz, final Method method) {
		final Annotation[] annotations = clazz.getAnnotations();
		return this.getAction(annotations, method);
	}

	/**
	 * Gets the action.
	 * 
	 * @param method
	 *            the method
	 * @return the action
	 */
	public String getAction(final Method method) {
		final Annotation[] annotations = method.getAnnotations();
		return this.getAction(annotations, method);
	}

	/**
	 * Gets the action.
	 * 
	 * @param annotations
	 *            the annotations
	 * @return the action
	 */
	private String getAction(final Annotation[] annotations, final Method method) {
		for (final Annotation annotation : annotations) {
			if (annotation instanceof AsyncAudit) {
				final AsyncAudit audit = (AsyncAudit) annotation;
				String action = audit.action();
				if (ACTION.equals(action)) {
					return method.getName();
				} else {
					return action;
				}
			}
		}
		return null;
	}
}
