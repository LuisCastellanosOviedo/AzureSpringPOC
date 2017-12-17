package com.versionManager.versionManager.AzureInfrastructure.ResourceGroup;

import com.microsoft.azure.management.resources.ResourceGroup;
import com.versionManager.versionManager.AzureInfrastructure.IAzureElementVO;

/**
 * Created by LuisCO on 13/12/2017.
 */
public class ResourceGroupVO implements IAzureElementVO {

    private  ResourceGroup resourceGroup;

    public ResourceGroupVO(ResourceGroup resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    public ResourceGroup getResourceGroup() {
        return resourceGroup;
    }
}
