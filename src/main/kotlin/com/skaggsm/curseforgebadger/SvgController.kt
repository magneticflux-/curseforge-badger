package com.skaggsm.curseforgebadger

import com.skaggsm.curseforgebadger.curseforge.CurseForgeApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

/**
 * Created by Mitchell Skaggs on 6/27/2019.
 */
@Controller
class SvgController {
    @Autowired
    lateinit var service: CurseForgeApiService

    @GetMapping("/api/{id}")
    fun api(@PathVariable("id") id: String, model: Model): String {
        val project = service.getProject(id)

        val text = project.title

        val width = text.length * 7 + 12

        model["text"] = text
        model["left_color"] = "E04E14"
        model["right_color"] = "2D2D2D"
        model["text_color"] = "fff"
        model["shadow_color"] = "010101"
        model["logo_color"] = "1C1C1C"
        model["width"] = width
        model["total_width"] = width + 30
        model["offset"] = 30.5 + width.toDouble() / 2

        return "api"
    }
}
