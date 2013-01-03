package web

import dao.TaskDao
import javax.validation.Valid
import model.Task
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping(Array("/task"))
class TaskController @Autowired() (val dao: TaskDao) {

  @RequestMapping
  def list(model: Model): String = {
    model.addAttribute("list", dao.findAll())
    "list"
  }

  @RequestMapping(params = Array("edit"))
  def form() = "form"

  @RequestMapping(method = Array(RequestMethod.POST))
  def save(@Valid task: Task, result: BindingResult): String = {
    result.hasErrors match {
      case true => "form"
      case false => {
        dao.save(task)
        "redirect:task?edit=" + task.id
      }
    }
  }

  @ModelAttribute
  def model(@RequestParam(required = false) edit: Option[Int]): Option[Task] = {
    edit match {
      case Some(x) => dao.findById(x)
      case None => Option(new Task)
    }
  }
}