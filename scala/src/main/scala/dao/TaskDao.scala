package dao

import org.springframework.stereotype.Repository
import model.Task
import collection.mutable
import java.util.concurrent.atomic.AtomicInteger

@Repository
class TaskDao {

  val tasks = new mutable.LinkedHashMap[Int,Task]
  var lastid = new AtomicInteger

  def findAll(): Iterable[Task] = {
    tasks.values
  }

  def findById(id: Int): Option[Task] = {
    tasks.get(id)
  }

  def save(task: Task) {
    if (task.id == 0) {
      task.id = lastid.incrementAndGet
    }
    tasks.put(task.id, task)
  }
}