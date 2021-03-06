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

package com.liferay.asset.display.template.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AssetDisplayTemplateLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AssetDisplayTemplateLocalService
 * @generated
 */
@ProviderType
public class AssetDisplayTemplateLocalServiceWrapper
	implements AssetDisplayTemplateLocalService,
		ServiceWrapper<AssetDisplayTemplateLocalService> {
	public AssetDisplayTemplateLocalServiceWrapper(
		AssetDisplayTemplateLocalService assetDisplayTemplateLocalService) {
		_assetDisplayTemplateLocalService = assetDisplayTemplateLocalService;
	}

	/**
	* Adds the asset display template to the database. Also notifies the appropriate model listeners.
	*
	* @param assetDisplayTemplate the asset display template
	* @return the asset display template that was added
	*/
	@Override
	public com.liferay.asset.display.template.model.AssetDisplayTemplate addAssetDisplayTemplate(
		com.liferay.asset.display.template.model.AssetDisplayTemplate assetDisplayTemplate) {
		return _assetDisplayTemplateLocalService.addAssetDisplayTemplate(assetDisplayTemplate);
	}

	@Override
	public com.liferay.asset.display.template.model.AssetDisplayTemplate addAssetDisplayTemplate(
		long groupId, long userId, String name, long classNameId,
		String language, String scriptContent, boolean main,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assetDisplayTemplateLocalService.addAssetDisplayTemplate(groupId,
			userId, name, classNameId, language, scriptContent, main,
			serviceContext);
	}

	/**
	* Creates a new asset display template with the primary key. Does not add the asset display template to the database.
	*
	* @param assetDisplayTemplateId the primary key for the new asset display template
	* @return the new asset display template
	*/
	@Override
	public com.liferay.asset.display.template.model.AssetDisplayTemplate createAssetDisplayTemplate(
		long assetDisplayTemplateId) {
		return _assetDisplayTemplateLocalService.createAssetDisplayTemplate(assetDisplayTemplateId);
	}

	/**
	* Deletes the asset display template from the database. Also notifies the appropriate model listeners.
	*
	* @param assetDisplayTemplate the asset display template
	* @return the asset display template that was removed
	* @throws PortalException
	*/
	@Override
	public com.liferay.asset.display.template.model.AssetDisplayTemplate deleteAssetDisplayTemplate(
		com.liferay.asset.display.template.model.AssetDisplayTemplate assetDisplayTemplate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assetDisplayTemplateLocalService.deleteAssetDisplayTemplate(assetDisplayTemplate);
	}

	/**
	* Deletes the asset display template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assetDisplayTemplateId the primary key of the asset display template
	* @return the asset display template that was removed
	* @throws PortalException if a asset display template with the primary key could not be found
	*/
	@Override
	public com.liferay.asset.display.template.model.AssetDisplayTemplate deleteAssetDisplayTemplate(
		long assetDisplayTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assetDisplayTemplateLocalService.deleteAssetDisplayTemplate(assetDisplayTemplateId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assetDisplayTemplateLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _assetDisplayTemplateLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _assetDisplayTemplateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.asset.display.template.model.impl.AssetDisplayTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _assetDisplayTemplateLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.asset.display.template.model.impl.AssetDisplayTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _assetDisplayTemplateLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _assetDisplayTemplateLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _assetDisplayTemplateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.asset.display.template.model.AssetDisplayTemplate fetchAssetDisplayTemplate(
		long assetDisplayTemplateId) {
		return _assetDisplayTemplateLocalService.fetchAssetDisplayTemplate(assetDisplayTemplateId);
	}

	@Override
	public com.liferay.asset.display.template.model.AssetDisplayTemplate fetchAssetDisplayTemplate(
		long groupId, long classNameId) {
		return _assetDisplayTemplateLocalService.fetchAssetDisplayTemplate(groupId,
			classNameId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _assetDisplayTemplateLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the asset display template with the primary key.
	*
	* @param assetDisplayTemplateId the primary key of the asset display template
	* @return the asset display template
	* @throws PortalException if a asset display template with the primary key could not be found
	*/
	@Override
	public com.liferay.asset.display.template.model.AssetDisplayTemplate getAssetDisplayTemplate(
		long assetDisplayTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assetDisplayTemplateLocalService.getAssetDisplayTemplate(assetDisplayTemplateId);
	}

	/**
	* Returns a range of all the asset display templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.asset.display.template.model.impl.AssetDisplayTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of asset display templates
	* @param end the upper bound of the range of asset display templates (not inclusive)
	* @return the range of asset display templates
	*/
	@Override
	public java.util.List<com.liferay.asset.display.template.model.AssetDisplayTemplate> getAssetDisplayTemplates(
		int start, int end) {
		return _assetDisplayTemplateLocalService.getAssetDisplayTemplates(start,
			end);
	}

	@Override
	public java.util.List<com.liferay.asset.display.template.model.AssetDisplayTemplate> getAssetDisplayTemplates(
		long groupId) {
		return _assetDisplayTemplateLocalService.getAssetDisplayTemplates(groupId);
	}

	@Override
	public java.util.List<com.liferay.asset.display.template.model.AssetDisplayTemplate> getAssetDisplayTemplates(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.asset.display.template.model.AssetDisplayTemplate> orderByComparator) {
		return _assetDisplayTemplateLocalService.getAssetDisplayTemplates(groupId,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.asset.display.template.model.AssetDisplayTemplate> getAssetDisplayTemplates(
		long groupId, String name) {
		return _assetDisplayTemplateLocalService.getAssetDisplayTemplates(groupId,
			name);
	}

	@Override
	public java.util.List<com.liferay.asset.display.template.model.AssetDisplayTemplate> getAssetDisplayTemplates(
		long groupId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.asset.display.template.model.AssetDisplayTemplate> orderByComparator) {
		return _assetDisplayTemplateLocalService.getAssetDisplayTemplates(groupId,
			name, start, end, orderByComparator);
	}

	/**
	* Returns the number of asset display templates.
	*
	* @return the number of asset display templates
	*/
	@Override
	public int getAssetDisplayTemplatesCount() {
		return _assetDisplayTemplateLocalService.getAssetDisplayTemplatesCount();
	}

	@Override
	public int getAssetDisplayTemplatesCount(long groupId) {
		return _assetDisplayTemplateLocalService.getAssetDisplayTemplatesCount(groupId);
	}

	@Override
	public int getAssetDisplayTemplatesCount(long groupId, String name) {
		return _assetDisplayTemplateLocalService.getAssetDisplayTemplatesCount(groupId,
			name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _assetDisplayTemplateLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _assetDisplayTemplateLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assetDisplayTemplateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the asset display template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param assetDisplayTemplate the asset display template
	* @return the asset display template that was updated
	*/
	@Override
	public com.liferay.asset.display.template.model.AssetDisplayTemplate updateAssetDisplayTemplate(
		com.liferay.asset.display.template.model.AssetDisplayTemplate assetDisplayTemplate) {
		return _assetDisplayTemplateLocalService.updateAssetDisplayTemplate(assetDisplayTemplate);
	}

	@Override
	public com.liferay.asset.display.template.model.AssetDisplayTemplate updateAssetDisplayTemplate(
		long assetDisplayTemplateId, String name, long classNameId,
		String language, String scriptContent, boolean main,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assetDisplayTemplateLocalService.updateAssetDisplayTemplate(assetDisplayTemplateId,
			name, classNameId, language, scriptContent, main, serviceContext);
	}

	@Override
	public AssetDisplayTemplateLocalService getWrappedService() {
		return _assetDisplayTemplateLocalService;
	}

	@Override
	public void setWrappedService(
		AssetDisplayTemplateLocalService assetDisplayTemplateLocalService) {
		_assetDisplayTemplateLocalService = assetDisplayTemplateLocalService;
	}

	private AssetDisplayTemplateLocalService _assetDisplayTemplateLocalService;
}