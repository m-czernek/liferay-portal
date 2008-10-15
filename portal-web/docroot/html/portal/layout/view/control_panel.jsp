<%
/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>

<%@ include file="/html/portal/init.jsp" %>

<%
String ppid = ParamUtil.getString(request, "p_p_id");

if (ppid.equals(PortletKeys.PORTLET_CONFIGURATION)) {
	ppid = ParamUtil.getString(request, PortalUtil.getPortletNamespace(ppid) + "portletResource");
}

String category = PortalUtil.getControlPanelCategory(ppid);

if (Validator.isNull(category)) {
	category = PortletCategoryKeys.CONTENT;
}
%>

<c:if test="<%= !themeDisplay.isStateExclusive() && !themeDisplay.isStatePopUp() %>">

	<%
	String panelCategory = StringPool.BLANK;

	if (category.equals(PortletCategoryKeys.CONTENT)) {
		panelCategory = "panel-manage-content";
	}
	else if (category.equals(PortletCategoryKeys.MY)) {
		panelCategory = "panel-manage-my";
	}
	else if (category.equals(PortletCategoryKeys.PORTAL)) {
		panelCategory = "panel-manage-portal";
	}
	else if (category.equals(PortletCategoryKeys.SERVER)) {
		panelCategory = "panel-manage-server";
	}
	%>

	<div id="content-wrapper">
		<table class="lfr-ctrl-panel <%= panelCategory %>">
		<tr>
			<td class="panel-page-menu" valign="top">
				<liferay-portlet:runtime portletName="87" />
			</td>
			<td class="panel-page-content <%= (!layoutTypePortlet.hasStateMax()) ? "panel-page-frontpage" : "panel-page-application" %>" valign="top">
				<table class="panel-page-content-menu">
				<tr>
					<td>
						<c:if test="<%= category.equals(PortletCategoryKeys.CONTENT) %>">

							<%
							Group scopeGroup = themeDisplay.getScopeGroup();

							String currentGroupLabel = "current-community";

							if (scopeGroup.isOrganization()) {
								currentGroupLabel = "current-organization";
							}
							else if (scopeGroup.isUser()) {
								currentGroupLabel = "current-user";
							}
							%>

							<h4 class="current-community">
								<liferay-ui:message key="<%= currentGroupLabel %>" />: <span><%= scopeGroup.getDescriptiveName() %></span>
							</h4>
						</c:if>
					</td>
					<td align="right">
						<c:if test="<%= !category.equals(PortletCategoryKeys.SERVER) %>">
							<liferay-ui:message key="current-portal-instance" />: <a href="javascript: ;"><b><%= company.getWebId() %></b></a>
						</c:if>
					</td>
				</tr>
				</table>
</c:if>

<%
if (themeDisplay.isStateExclusive() || themeDisplay.isStatePopUp() || layoutTypePortlet.hasStateMax()) {
	String content = null;

	if (themeDisplay.isStateExclusive()) {
		content = LayoutTemplateLocalServiceUtil.getContent("exclusive", true, theme.getThemeId());
	}
	else if (themeDisplay.isStatePopUp()) {
		content = LayoutTemplateLocalServiceUtil.getContent("pop_up", true, theme.getThemeId());
	}
	else {
		ppid = StringUtil.split(layoutTypePortlet.getStateMax())[0];

		content = LayoutTemplateLocalServiceUtil.getContent("max", true, theme.getThemeId());
	}
%>

	<%= RuntimePortletUtil.processTemplate(application, request, response, pageContext, ppid, content) %>

<%
}
else {
	String description = StringPool.BLANK;

	if (Validator.isNull(description)) {
		description = LanguageUtil.get(pageContext, "please-select-a-tool-from-the-left-menu");
	}
%>

	<div class="portlet-msg-info">
		<%= description %>
	</div>

<%
}
%>

<c:if test="<%= !themeDisplay.isStateExclusive() && !themeDisplay.isStatePopUp() %>">
			</td>
		</tr>
		</table>
	</div>
</c:if>