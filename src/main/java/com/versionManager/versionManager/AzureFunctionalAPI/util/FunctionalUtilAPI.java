package com.versionManager.versionManager.AzureFunctionalAPI.util;

import com.microsoft.azure.management.storage.StorageAccountKey;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by LuisCO on 13/12/2017.
 */
public class FunctionalUtilAPI {

    public static BiFunction<String, String, String> getStringValueOrDefault = (x, y) -> x.isEmpty()?y:x;

    public static Function<List<StorageAccountKey>,String> getFirstAccessKey = x -> x.stream().findFirst().get().value();

    public static  Function<String,String> addSemicolonAtTheEnd = x -> x.concat(";");


}

