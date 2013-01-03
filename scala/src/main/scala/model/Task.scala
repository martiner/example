package model

import javax.validation.constraints.Size
import reflect.BeanProperty

class Task {
  @BeanProperty
  var id: Int = _

  @BeanProperty
  @Size(min = 1)
  var title: String = _

  @BeanProperty
  var desc: String = _
}
