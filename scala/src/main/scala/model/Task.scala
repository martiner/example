package model

import javax.validation.constraints.Size
import reflect.BeanProperty

class Task (
            @BeanProperty
            var id: Int,

            @BeanProperty
            @Size(min = 1)
            var title: String,

            @BeanProperty
            var desc: String
            )