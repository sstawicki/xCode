package com.xcode.rest.task.two;

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
