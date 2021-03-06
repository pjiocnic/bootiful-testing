package com.woburn.producer

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.test.StepVerifier
import java.util.*


@DataMongoTest
class PersistenceTests {

    @Autowired
    private lateinit var repo: ReactiveMongoRepository<Cereal, UUID>

    @Test
    fun `should save and find all cereals`() {
        val data = Cereal(UUID.randomUUID(), "Cinnamon Toast")

        val publisher = repo
                .save(data)
                .thenMany(
                        repo.findAll()
                )

        StepVerifier
                .create(publisher)
                .expectSubscription()
                .assertNext {
                    Assertions
                            .assertThat(it)
                            .isNotNull
                            .hasNoNullFieldsOrProperties()
                            .hasFieldOrPropertyWithValue("name", "Cinnamon Toast")
                }
                .verifyComplete()

    }
}