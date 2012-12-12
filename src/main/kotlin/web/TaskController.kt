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

Controller
RequestMapping(value = array("/task"))
public class TaskController [Autowired] (
        val dao:TaskDao
    ) {

    RequestMapping
    public fun list(model: Model): String {
        model.addAttribute("list", dao.findAll())
        return "list"
    }

    RequestMapping(params = array("edit"))
    public fun form(): String = "form"

    RequestMapping(method = array(RequestMethod.POST))
    public fun save(Valid task:Task, result: BindingResult): String {
        return when (result.hasErrors()) {
            true -> "form"
            else -> {
                dao.save(task)
                "redirect:task?edit=${task.id}"
            }
        }
    }

    ModelAttribute
    public fun model(RequestParam(required = false) edit: Int?): Task? {
        return when (edit) {
            null -> Task(null, "", "")
            else -> dao.findById(edit)
        }
    }
}