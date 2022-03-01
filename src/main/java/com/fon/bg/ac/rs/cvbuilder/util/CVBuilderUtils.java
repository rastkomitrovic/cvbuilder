package com.fon.bg.ac.rs.cvbuilder.util;

import com.fon.bg.ac.rs.cvbuilder.entity.abs.BaseEntity;
import org.hibernate.Hibernate;

import java.util.Collection;
import java.util.List;

public class CVBuilderUtils {

    public static <T extends BaseEntity> boolean isLazyEntityInitialized(T entity) {
        return Hibernate.isInitialized(entity);
    }

    public static <T extends BaseEntity> boolean isLazyInitializedCollection(Collection<T> collection){
        return Hibernate.isInitialized(collection);
    }

    public static void throwExceptionIfHasMessages(List<String> messages) throws CVBuilderException{
        if(!messages.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Greska prilikom izvrsavanja operacije.\nIdentifikovane greske:");
            messages.forEach(it -> stringBuilder.append("\n").append(it));
            throw new CVBuilderException(stringBuilder.toString());
        }
    }
}
