package com.springrest.springrest.mapper;

import com.springrest.springrest.dto.StudentDto;
import com.springrest.springrest.model.StudentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    @Mapping(target = "id" , ignore = true)
    StudentModel convertDtoToExampleEntity(StudentDto exampleDto);
    StudentDto convertExampleEntityToDto(StudentModel exampleModel);
}
