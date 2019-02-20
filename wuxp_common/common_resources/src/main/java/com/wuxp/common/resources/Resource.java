package com.wuxp.common.resources;



/**
 * resource
 */
public interface Resource<ID> {

    /**
     * an instance used to distinguish resources
     *
     * @return resource unique identifier
     */
    ID getUniqueIdentifier();

    /**
     *
     * @return resource type
     */
    ResourceType getResourceType();
}
