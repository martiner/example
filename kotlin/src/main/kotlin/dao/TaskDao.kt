package dao

import org.springframework.stereotype.Repository
import model.Task
import java.util.LinkedHashMap

Repository
public class TaskDao {

    val tasks: LinkedHashMap<Int,Task> = LinkedHashMap()
    var lastid: Int = 0

    public fun findAll(): Collection<Task> {
        return tasks.values()
    }

    public fun findById(id: Int): Task? {
        return tasks.get(id)
    }

    public fun save(task: Task) {
        if (task.id == null) {
            task.id = lastid++
        }
        tasks.put(task.id!!, task)
    }
}