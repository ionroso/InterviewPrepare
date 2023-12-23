package medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignATodoList {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.addTask(1, "Task1", 50, List.of()); // return 1. This adds a new task for the user with id 1.
        todoList.addTask(1, "Task2", 100, List.of("P1")); // return 2. This adds another task for the user with id 1.
        todoList.getAllTasks(1); // return ["Task1", "Task2"]. User 1 has two uncompleted tasks so far.
        todoList.getAllTasks(5); // return []. User 5 does not have any tasks so far.
        todoList.addTask(1, "Task3", 30,  List.of("P1")); // return 3. This adds another task for the user with id 1.
        todoList.getTasksForTag(1, "P1"); // return ["Task3", "Task2"]. This returns the uncompleted tasks that have the tag "P1" for the user with id 1.
        todoList.completeTask(5, 1); // This does nothing, since task 1 does not belong to user 5.
        todoList.completeTask(1, 2); // This marks task 2 as completed.
        todoList.getTasksForTag(1, "P1"); // return ["Task3"]. This returns the uncompleted tasks that have the tag "P1" for the user with id 1.
        // Notice that we did not include "Task2" because it is completed now.
        todoList.getAllTasks(1); // return ["Task3", "Task1"]. User 1 now has 2 uncompleted tasks.
    }

    static
    class TodoList {
        class Task {
            int userId;
            String taskDescription;
            int dueDate;
            List<String> tags;

            boolean completed;

            public Task(int userId, String taskDescription, int dueDate, List<String> tags) {
                this.userId = userId;
                this.taskDescription = taskDescription;
                this.dueDate = dueDate;
                this.tags = tags;
                this.completed = false;
            }
        }

        int serialId=1;

        Map<Integer, Map<Integer, Task>> userToTask;

        public TodoList() {
            userToTask = new HashMap<>();
        }

        public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
            userToTask.computeIfAbsent(userId, k-> new HashMap<>()).put(serialId, new Task(userId, taskDescription, dueDate, tags));
            return serialId++;
        }

        public List<String> getAllTasks(int userId) {
            if(!userToTask.containsKey(userId)){
                return List.of();
            }
            return userToTask.get(userId).entrySet().stream()
                    .filter(p->!p.getValue().completed)
                    .sorted(Comparator.comparingInt(o -> o.getValue().dueDate))
                    .map(m->m.getValue().taskDescription)
                    .toList();
        }

        public List<String> getTasksForTag(int userId, String tag) {
            if(!userToTask.containsKey(userId)){
                return List.of();
            }

            return userToTask.get(userId).entrySet().stream()
                    .filter(p->p.getValue().tags.contains(tag))
                    .filter(p->!p.getValue().completed)
                    .sorted(Comparator.comparingInt(o -> o.getValue().dueDate))
                    .map(m->m.getValue().taskDescription)
                    .toList();
        }

        public void completeTask(int userId, int taskId) {
            if(!userToTask.containsKey(userId)){
                return;
            }


            if(!userToTask.get(userId).containsKey(taskId)){
                return;
            }

            Task task = userToTask.get(userId).get(taskId);
            task.completed = true;
        }
    }
}
