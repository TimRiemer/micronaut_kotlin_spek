package mobi.riemer.greeting

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object GreetingControllerSpec : Spek({
    describe("GreetingController Suite") {
        val embeddedServer: EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        val client: HttpClient = HttpClient.create(embeddedServer.url)

        it("test /greeting responds Hello World") {
            val response: String = client.toBlocking().retrieve("/greeting")
            assertEquals("Hello World", response)
        }

        it("test /greeting/Tim responds Hello Tim") {
            val response: String = client.toBlocking().retrieve("/greeting/Tim")
            assertEquals("Hello Tim", response)
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})