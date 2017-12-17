package com.versionManager.versionManager.AzureInfrastructure;

import com.microsoft.azure.management.Azure;
import com.versionManager.versionManager.AzureEntities.VMConfiguration;

import java.util.Map;

/**
 * Created by LuisCO on 30/11/2017.
 */
public interface InfrastructureCommand {

    IAzureElementVO  createAzureInfrastructure(Azure.Authenticated auth, VMConfiguration vmConfiguration, Map<String,Object> params);
}
