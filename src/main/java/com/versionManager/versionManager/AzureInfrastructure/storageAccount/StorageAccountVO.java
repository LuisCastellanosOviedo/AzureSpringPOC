package com.versionManager.versionManager.AzureInfrastructure.storageAccount;

import com.microsoft.azure.management.storage.StorageAccount;
import com.versionManager.versionManager.AzureInfrastructure.IAzureElementVO;

/**
 * Created by LuisCO on 13/12/2017.
 */
public class StorageAccountVO implements IAzureElementVO {

    private StorageAccount storageAccount;

    public StorageAccountVO(StorageAccount storageAccount) {
        this.storageAccount = storageAccount;
    }

    public StorageAccount getStorageAccount() {
        return storageAccount;
    }
}
