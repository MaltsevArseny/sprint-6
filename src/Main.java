public class Main {
    private static String[] args;

    public static void main(String[] args) {
        Main.args = args;
        // args не используется, поэтому игнорируем
        HistoryManager historyManager = getHistoryManager();

        // Выводим историю
        System.out.println("History after adding tasks:");
        historyManager.getHistory().forEach(task -> System.out.println(task.getName()));

        // Удаляем задачу из истории
        historyManager.remove(1);
        System.out.println("History after removing task1:");
        historyManager.getHistory().forEach(task -> System.out.println(task.getName()));

        // Удаляем эпик с подзадачами
        historyManager.remove(3);
        System.out.println("History after removing epic1:");
        historyManager.getHistory().forEach(task -> System.out.println(task.getName()));
    }

    private static HistoryManager getHistoryManager() {
        HistoryManager historyManager = new InMemoryHistoryManager();

        Task task1 = new Task(1, "Task 1");
        Task task2 = new Task(2, "Task 2");
        Epic epic1 = new Epic(3, "Epic 1");
        Subtask subtask1 = new Subtask(4, "Subtask 1", 3);
        Subtask subtask2 = new Subtask(5, "Subtask 2", 3);
        Subtask subtask3 = new Subtask(6, "Subtask 3", 3);
        Epic epic2 = new Epic(7, "Epic 2");

        historyManager.add(task1);
        historyManager.add(task2);
        historyManager.add(epic1);
        historyManager.add(subtask1);
        historyManager.add(subtask2);
        historyManager.add(subtask3);
        historyManager.add(epic2);

        // Запрашиваем задачи несколько раз в разном порядке
        historyManager.add(task1);
        historyManager.add(epic1);
        historyManager.add(task2);
        return historyManager;
    }
}