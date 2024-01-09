//package com.mindex.challenge.util;
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeFormatterBuilder;
//
//import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
//
//public class DateDeserializer extends StdDeserializer<LocalDate> {
//
//    public DateDeserializer() {
//        this(null);
//    }
//
//    public DateDeserializer(Class<?> clazz) {
//        super(clazz);
//    }
//
//    @Override
//    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
//        String date = jsonParser.getText();
//        try {
//            DateTimeFormatter format = new DateTimeFormatterBuilder().toFormatter();
//            return (LocalDate) format.parse(date);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//}
