package dao

import org.springframework.stereotype.Repository
import model.Task
import java.util.LinkedHashMap
import java.util.concurrent.atomic.AtomicInteger

Repository
public class TaskDao {

    val tasks: LinkedHashMap<Int,Task> = LinkedHashMap()
    var lastid: AtomicInteger = AtomicInteger(0)

    public fun findAll(): Collection<Task> {
        return tasks.values()
    }

    public fun findById(id: Int): Task? {
        return tasks.get(id)
    }

    public fun save(task: Task) {
        if (task.id == null) {
            task.id = lastid.incrementAndGet()
        }
        tasks.put(task.id!!, task)
    }
}