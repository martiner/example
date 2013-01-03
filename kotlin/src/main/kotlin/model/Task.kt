package model

import javax.validation.constraints.Size

public class Task (
        var id: Int?,

        Size(min=1)
        var title: String,

        var desc: String
    ) {
}