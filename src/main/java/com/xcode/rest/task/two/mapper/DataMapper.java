package com.xcode.rest.task.two.mapper;

import com.xcode.rest.task.two.domain.Data;
import com.xcode.rest.task.two.domain.DataDto;
import org.springframework.stereotype.Component;

@Component
public class DataMapper {
    public Data mapToData(final DataDto dataDto) {
        return new Data(dataDto.getNumbers(), dataDto.getOrder());
    }

    public DataDto mapToDataDto (final Data data) {
        return new DataDto(data.getNumbers(), data.getOrder());
    }
}
