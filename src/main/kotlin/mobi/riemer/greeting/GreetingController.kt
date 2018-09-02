package mobi.riemer.greeting

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Single
import javax.inject.Inject

@Controller("/greeting")
class GreetingController {

    @Inject
    private var greetingService: GreetingService? = null

    @Get("/")
    fun greeting(): Single<String> {
        return greetingService!!.message("World")
    }

    @Get("/{name}")
    fun greeting(name: String): Single<String> {
        return greetingService!!.message(name)
    }
}