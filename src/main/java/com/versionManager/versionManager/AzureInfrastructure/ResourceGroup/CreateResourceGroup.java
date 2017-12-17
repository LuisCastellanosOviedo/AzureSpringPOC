package com.versionManager.versionManager.AzureInfrastructure.ResourceGroup;

import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.resources.ResourceGroup;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.versionManager.versionManager.AzureAuth.AzureCredentials.AccessCredentials;
import com.versionManager.versionManager.AzureEntities.VMConfiguration;
import com.versionManager.versionManager.AzureInfrastructure.IAzureElementVO;
import com.versionManager.versionManager.AzureInfrastructure.InfrastructureCommand;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by LuisCO on 30/11/2017.
 */
@Component
@Qualifier("resourceGroup")
public class CreateResourceGroup implements InfrastructureCommand {

    @Override
    public IAzureElementVO createAzureInfrastructure(Azure.Authenticated auth, VMConfiguration vmConfiguration, Map<String,Object> params) {

        ResourceGroup resourceGroup =  auth.withSubscription(vmConfiguration.getSubscription())
                .resourceGroups()
                .define(vmConfiguration.getResourceGroupName())
                .withRegion(Region.US_EAST)
                .create();

        return new ResourceGroupVO(resourceGroup);
    }
}
