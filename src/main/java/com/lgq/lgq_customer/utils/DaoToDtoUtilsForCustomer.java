package com.lgq.lgq_customer.utils;

import com.lgq.lgq_customer.dto.DtoCustmore;
import com.lgq.lgq_customer.entity.tb_custmore;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

/**
 * @program: lgq_customer
 * @description
 * @author: lgq
 * @create: 2020-03-21 18:11
 **/
@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DaoToDtoUtilsForCustomer {

    DaoToDtoUtilsForCustomer INSTANCES = Mappers.getMapper(DaoToDtoUtilsForCustomer.class);

    @Mappings({})
    tb_custmore toTbCustomer(DtoCustmore dtoCustmore);
}
