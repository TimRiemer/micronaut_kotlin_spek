package mobi.riemer.greeting

import io.reactivex.Single
import javax.inject.Singleton

@Singleton
internal class GreetingService {

    fun message(name: String): Single<String> {
        return Single.just("Hello $name")
    }
}