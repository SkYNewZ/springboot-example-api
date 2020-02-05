package com.lemairepro.reminder.mapper;

import com.lemairepro.reminder.model.Reminder;
import com.lemairepro.reminder.model.ReminderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReminderMapper {
    ReminderMapper INSTANCE = Mappers.getMapper(ReminderMapper.class);

    Reminder toReminder(ReminderDTO reminderDTO);
    ReminderDTO toReminderDTO(Reminder reminder);
    List<ReminderDTO> toReminderDTOList(List<Reminder> reminders);
}
