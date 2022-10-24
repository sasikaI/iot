package com.igreendata.iot.data;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;


public class HealthDataReader{

    public static List<BloodPressureData> getBloodPressureData()  {
        try {
            File csvFile =  ResourceUtils.getFile("classpath:sample-data.csv");

            CsvMapper csvMapper = new CsvMapper();

            CsvSchema csvSchema = csvMapper
                    .typedSchemaFor(BloodPressureData.class)
                    .withHeader()
                    .withColumnSeparator(',')
                    .withComments();

            MappingIterator<BloodPressureData> bloodPressureDataMappingIterator = csvMapper
                    .readerWithTypedSchemaFor(BloodPressureData.class)
                    .with(csvSchema)
                    .readValues(csvFile);
            return bloodPressureDataMappingIterator.readAll().stream()
                    .collect(Collectors.toList());

        }catch (Exception e){
            return Collections.emptyList();
        }
    }
}
