package Evaluator;

import Logger.Logger;
import Storage.FileStorage;
import TaskList.TaskList;
import TaskList.ToDo;
import Exception.KevinException;

import java.util.ArrayList;

public class ToDoStrategy extends BaseStrategy {
    public ToDoStrategy(TaskList taskList, ArrayList<String> arguments) {
        super(taskList, arguments);
    }

    @Override
    public boolean evaluate(Logger logger, FileStorage fileStorage, boolean isInFile) throws KevinException {
        Boolean isDone = Boolean.getBoolean(this.arguments.get(0));
        String toDoName = this.arguments.get(1);

        ToDo newToDo = taskList.addToDo(isDone, toDoName);

        if (!isInFile) {
            fileStorage.addToDo(newToDo);
            logger.log("Got it. I've added this task: \n\t\t" + newToDo +
                    "\n\tNow you have " + this.taskList.size() + " tasks in the list.");
        }

        return true;
    }
}
