package com.springrest.springrest.mapper;

import com.springrest.springrest.dto.ExampleDto;
import com.springrest.springrest.model.ExampleModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExampleMapper {
    ExampleMapper INSTANCE = Mappers.getMapper(ExampleMapper.class);
    @Mapping(target = "id" , ignore = true)
    ExampleModel convertDtoToExampleEntity(ExampleDto exampleDto);
    ExampleDto convertExampleEntityToDto(ExampleModel exampleModel);
}
