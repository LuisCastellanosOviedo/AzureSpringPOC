package com.versionManager.versionManager.AzureCreator.versionManager.services;

import com.microsoft.azure.management.Azure;
import com.versionManager.versionManager.AzureEntities.VMConfiguration;
import com.versionManager.versionManager.AzureInfrastructure.IAzureElementVO;
import com.versionManager.versionManager.AzureInfrastructure.InfrastructureCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LuisCO on 13/12/2017.
 */

@Component
public class ResourceGroupService {

    @Autowired
    @Qualifier("resourceGroup")
    private InfrastructureCommand resourceGroup;

    public Map<String,Object> execute(Azure.Authenticated auth,VMConfiguration vmConfiguration,Map<String,Object> params){

        IAzureElementVO rg = resourceGroup.createAzureInfrastructure(auth, vmConfiguration,params);

        return new HashMap<>();
    }
}
