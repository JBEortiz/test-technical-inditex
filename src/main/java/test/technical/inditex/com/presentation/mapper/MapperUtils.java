package test.technical.inditex.com.presentation.mapper;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class MapperUtils {
    public LocalDateTime formatIsoOffsetDateTime(LocalDateTime localDateTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = localDateTime.format(dateTimeFormatter);
        return LocalDateTime.parse(formattedDate, dateTimeFormatter);
    }


}
