package com.wuxp.common.resources;

import java.util.List;

/**
 * resource provider
 */
public interface ResourceProvider<R extends Resource<ID>, ID> {

    /**
     * persistence resource
     */
    ID persistence(R resource);

    int update(R resource);

    default boolean deleted(R resource) {
        if (resource == null) {
            return false;
        }
        return this.deletedById(resource.getUniqueIdentifier());
    }

    boolean deletedById(ID id);

    default int deleted(ResourceFindCondition condition) {

        List<R> list = this.findList(condition);
        int count = 0;
        for (R r : list) {
            if (this.deleted(r)) {
                count++;
            }
        }
        return count;
    }

    /**
     * find resource instance by unique identifier
     *
     * @param id
     * @return
     */
    R findById(ID id);

    List<R> findList(ResourceFindCondition condition);
}
