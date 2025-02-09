package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.DeleteAppointmentCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteAppointmentCommandParser implements Parser<DeleteAppointmentCommand> {
    private static final Logger logger = LogsCenter.getLogger(DeleteCommandParser.class);
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteAppointmentCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        try {
            int index = Integer.parseInt(trimmedArgs);
            logger.info("Successfully parsed integer from DeleteAppointmentCommand: " + index);
            return new DeleteAppointmentCommand(index);
        } catch (NumberFormatException e) {
            logger.warning("Invalid user input for delete appointment command");
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteAppointmentCommand.MESSAGE_USAGE), e);
        }
    }

}
