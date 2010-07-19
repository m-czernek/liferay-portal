/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.wiki.translators;

import com.liferay.portal.kernel.util.DigesterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jorge Ferrer
 */
public abstract class BaseTranslator {

	public String translate(String content) {
		_protectedMap.clear();

		content = preProcess(content);
		content = runRegexps(content);
		content = postProcess(content);

		return content;
	}

	protected String postProcess(String content) {
		return unprotectNowikiText(content);
	}

	protected String preProcess(String content) {
		content = _normalizeLineBreaks(content);

		for (String regexp : nowikiRegexps) {
			content = protectText(content, regexp);
		}

		return content;
	}

	protected String protectText(String content, String markupRegex) {
		Matcher matcher = Pattern.compile(
			markupRegex, Pattern.MULTILINE | Pattern.DOTALL).matcher(content);

		StringBuffer sb = new StringBuffer();

		while (matcher.find()) {
			String protectedText = matcher.group();

			String hash = DigesterUtil.digest(protectedText);

			matcher.appendReplacement(sb, "$1" + hash + "$3");

			_protectedMap.put(hash, matcher.group(2));
		}

		matcher.appendTail(sb);

		return sb.toString();
	}

	protected String runRegexps(String content) {
		for (Map.Entry<String, String> entry : regexps.entrySet()) {
			content = runRegexp(content, entry.getKey(), entry.getValue());
		}

		return content;
	}

	protected String runRegexp(
		String content, String regexp, String replacement) {

		Matcher matcher = Pattern.compile(
			regexp, Pattern.MULTILINE).matcher(content);

		StringBuffer sb = new StringBuffer();

		while (matcher.find()) {
			matcher.appendReplacement(sb, replacement);
		}

		matcher.appendTail(sb);

		return sb.toString();
	}

	protected String unprotectNowikiText(String content) {
		for (Map.Entry<String, String> enrty : _protectedMap.entrySet()) {
			content = content.replace(enrty.getKey(), enrty.getValue());
		}
		return content;
	}

	private String _normalizeLineBreaks(String content) {
		content = StringUtil.replace(
			content,
			new String[] {StringPool.RETURN_NEW_LINE, StringPool.RETURN},
			new String[] {StringPool.NEW_LINE, StringPool.NEW_LINE});

		return content;
	}

	protected Map<String, String> regexps =
		new LinkedHashMap<String, String>();
	protected List<String> nowikiRegexps = new LinkedList<String>();

	private Map<String, String> _protectedMap =
		new LinkedHashMap<String, String>();

}