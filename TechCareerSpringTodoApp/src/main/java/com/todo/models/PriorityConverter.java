package com.todo.models;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

// This class converts the Priority enum to and from a String representation for database storage.
// It is marked with @Converter annotation to indicate that it should be used as an attribute converter.
@Converter(autoApply = true)
public class PriorityConverter implements AttributeConverter<Priority, String>{

    // Converts a Priority enum to a String for database storage.
    @Override
    public String convertToDatabaseColumn(Priority priority) {
        // Return the name of the priority enum if it is not null, otherwise return null.
        return priority != null ? priority.name() : null;
    }

    // Converts a String from the database to a Priority enum.
    @Override
    public Priority convertToEntityAttribute(String value) {
        // Return the Priority enum corresponding to the given name, or null if the value is null.
        return value != null ? Priority.valueOf(value) : null;
    }
}
