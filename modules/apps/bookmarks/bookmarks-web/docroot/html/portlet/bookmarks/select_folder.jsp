<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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
--%>

<%@ include file="/html/portlet/bookmarks/init.jsp" %>

<%
BookmarksFolder folder = (BookmarksFolder)request.getAttribute(BookmarksWebKeys.BOOKMARKS_FOLDER);

long folderId = BeanParamUtil.getLong(folder, request, "folderId", BookmarksFolderConstants.DEFAULT_PARENT_FOLDER_ID);

String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectFolder");

String folderName = LanguageUtil.get(request, "home");

if (folder != null) {
	folderName = folder.getName();

	BookmarksUtil.addPortletBreadcrumbEntries(folder, request, renderResponse);
}
%>

<aui:form method="post" name="selectFolderFm">
	<liferay-ui:header
		title="home"
	/>

	<liferay-ui:breadcrumb showGuestGroup="<%= false %>" showLayout="<%= false %>" showParentGroups="<%= false %>" />

	<%
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("struts_action", "/bookmarks/select_folder");
	portletURL.setParameter("folderId", String.valueOf(folderId));
	portletURL.setParameter("eventName", eventName);
	%>

	<br />

	<liferay-ui:search-container
		iteratorURL="<%= portletURL %>"
		total="<%= BookmarksFolderServiceUtil.getFoldersCount(scopeGroupId, folderId) %>"
	>
		<liferay-ui:search-container-results
			results="<%= BookmarksFolderServiceUtil.getFolders(scopeGroupId, folderId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.bookmarks.model.BookmarksFolder"
			modelVar="curFolder"
		>

			<%
			AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(BookmarksFolder.class.getName());

			AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(curFolder.getFolderId());
			%>

			<portlet:renderURL var="viewFolderURL">
				<portlet:param name="struts_action" value="/bookmarks/select_folder" />
				<portlet:param name="folderId" value="<%= String.valueOf(curFolder.getFolderId()) %>" />
			</portlet:renderURL>

			<liferay-ui:search-container-column-text
				name="folder"
			>
				<liferay-ui:icon
					iconCssClass="<%= assetRenderer.getIconCssClass() %>"
					label="<%= true %>"
					localizeMessage="<%= false %>"
					message="<%= HtmlUtil.escape(curFolder.getName()) %>"
					url="<%= viewFolderURL %>"
				/>
			</liferay-ui:search-container-column-text>

			<%
			List<Long> subfolderIds = new ArrayList<Long>();

			subfolderIds.add(curFolder.getFolderId());

			BookmarksFolderServiceUtil.getSubfolderIds(subfolderIds, scopeGroupId, curFolder.getFolderId(), true);

			int foldersCount = subfolderIds.size() - 1;
			int entriesCount = BookmarksEntryServiceUtil.getFoldersEntriesCount(scopeGroupId, subfolderIds);
			%>

			<liferay-ui:search-container-column-text
				href="<%= viewFolderURL %>"
				name="num-of-folders"
				value="<%= String.valueOf(foldersCount) %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= viewFolderURL %>"
				name="num-of-entries"
				value="<%= String.valueOf(entriesCount) %>"
			/>

			<liferay-ui:search-container-column-text>

				<%
				Map<String, Object> data = new HashMap<String, Object>();

				data.put("folderid", curFolder.getFolderId());
				data.put("name", curFolder.getName());
				%>

				<aui:button cssClass="selector-button" data="<%= data %>" value="choose" />
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<aui:button-row>
			<c:if test="<%= BookmarksFolderPermission.contains(permissionChecker, scopeGroupId, folderId, ActionKeys.ADD_FOLDER) %>">
				<portlet:renderURL var="editFolderURL">
					<portlet:param name="struts_action" value="/bookmarks/edit_folder" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="parentFolderId" value="<%= String.valueOf(folderId) %>" />
				</portlet:renderURL>

				<aui:button href="<%= editFolderURL %>" value='<%= (folder == null) ? "add-folder" : "add-subfolder" %>' />
			</c:if>

			<%
			Map<String, Object> data = new HashMap<String, Object>();

			data.put("folderid", folderId);
			data.put("name", folderName);
			%>

			<aui:button cssClass="selector-button" data="<%= data %>" value="choose-this-folder" />
		</aui:button-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	Liferay.Util.selectEntityHandler('#<portlet:namespace />selectFolderFm', '<%= HtmlUtil.escapeJS(eventName) %>');
</aui:script>